package com.dti.defilecture.accèsAuxDonnées

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.JsonReader
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.entité.Questionnaire
import com.dti.defilecture.domaine.entité.Équipage
import java.io.StringReader
import java.net.URL
import java.util.concurrent.ExecutionException


class SourceDeDonnéesHTTP(var ctx: Context, var urlSource: URL) : ISourceDeDonnées {
    override fun validerComptePourLaConnexion(pseudo: String, mdp: String): Compte? {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        Log.e("Quoi","connecte avec : $pseudo et $mdp")

        val requête = StringRequest(Request.Method.GET,
            "$urlSource/api/Compte/$pseudo/$mdp", promesse, promesse)
        queue.add(requête)

        return try {
            réponseJsonToCompte( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Compte()
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
    }

    override fun obtenirListeDeLecturesUtilisateurSource(identifiant: Int): MutableList<Lecture>? {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET,
            "$urlSource/api/Lectures/compte/$identifiant", promesse, promesse)
        queue.add(requête)

        return try {
            réponseJsonToLecture( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            mutableListOf( Lecture("","",0,false) )
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
    }

    override fun ajouterUneLectureALaListeSource(lecture: Lecture) {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.POST,
            "$urlSource/api/Lectures/compte/$lecture", promesse, promesse)
        queue.add(requête)
    }

    override fun obtenirQuestionSource(): Questionnaire {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET,
            "$urlSource/api/questionnaire/question", promesse, promesse)
        queue.add(requête)

        return try {
            réponseJsonToQuestionnaire( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Questionnaire()
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
    }

    override fun obtenirBonneReponseSource(questionnaire: Questionnaire): String {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET,
            "$urlSource/api/questionnaire/bonneReponse", promesse, promesse)
        queue.add(requête)

        return try {
            réponseJsonToBonneReponse( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            questionnaire.bonneReponse
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
    }


    override fun obtenirListeDesComptesÉquipageSource(nomÉquipage: String): MutableList<Compte>? {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET,
            "$urlSource/api/comptes/equipage/$nomÉquipage", promesse, promesse)
        queue.add(requête)

        return try {
            réponseJsonToComptesÉquipage( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            mutableListOf( Compte() )
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
    }

    override fun obtenirListeDesÉquipagesSource(): MutableList<Équipage>? {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET,
            "$urlSource/api/tresorerie/equipages", promesse, promesse)
        queue.add(requête)

        return try {
            réponseJsonToTrésorerie( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            mutableListOf( Équipage() )
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
    }

    /**
     * Méthode qui convertit la réponse JSON en objet kotlin Compte.
     *
     * @param jsonReader Objet permettant la lecture d'un objet JSON
     */
    private fun réponseJsonToLecture( jsonReader: JsonReader ): MutableList<Lecture>? {
        val liste = mutableListOf<Lecture>()

        jsonReader.beginArray()
        while ( jsonReader.hasNext() ) {
            var lecture = Lecture()

            jsonReader.beginObject()
            while ( jsonReader.hasNext() ){
                val clé = jsonReader.nextName()
                when (clé) {
                    "titre" -> {
                        lecture.titreLecture = jsonReader.nextString()
                    }
                    "dateInscription" -> {
                        lecture.dateInscription = jsonReader.nextString()
                    }
                    "tempsLu" -> {
                        lecture.duréeMinutes = jsonReader.nextInt()
                    }
                    "estObligatoire" -> {
                        lecture.obligatoire = jsonReader.nextBoolean()
                    }
                    else -> {
                        jsonReader.skipValue()
                    }
                }

            }
            jsonReader.endObject()
            liste.add(lecture)
        }
        jsonReader.endArray()
        return liste
    }

    /**
     * Méthode qui convertit la réponse JSON en objet kotlin Compte.
     *
     * @param jsonReader Objet permettant la lecture d'un objet JSON
     */
    private fun réponseJsonToCompte(jsonReader: JsonReader): Compte {
        val compte = Compte()

        jsonReader.beginObject()

        while (jsonReader.hasNext()) {

            val clé = jsonReader.nextName()

            when (clé) {
                "idCompte" -> {
                    compte.idCompte = jsonReader.nextInt()
                }
                "courriel" -> {
                    compte.courriel = jsonReader.nextString()
                }
                "motDePasse" -> {
                    compte.motDePasse = jsonReader.nextString()
                }
                "nom" -> {
                    compte.nom = jsonReader.nextString()
                }
                "prénom" -> {
                    compte.prénom = jsonReader.nextString()
                }
                "pseudo" -> {
                    compte.pseudonyme = jsonReader.nextString()
                }
                "avatar" -> {
                    compte.avatar = stringToBitMap(jsonReader.nextString())
                }
                "doublons" -> {
                    compte.doublons = jsonReader.nextInt()
                }
                "programme" -> {
                    compte.programme = jsonReader.nextString()
                }
                "nomÉquipage" -> {
                    compte.nomÉquipage = jsonReader.nextString()
                }
                else -> {
                    jsonReader.skipValue()
                }
            }
        }
        jsonReader.endObject()

        return compte
    }
    /**
     * Méthode qui convertit la réponse JSON en objet kotlin Compte.
     *
     * @param jsonReader Objet permettant la lecture d'un objet JSON
     */
    private fun réponseJsonToComptesÉquipage(jsonReader: JsonReader): MutableList<Compte> {
        val liste = mutableListOf<Compte>()

        jsonReader.beginArray()
        while ( jsonReader.hasNext() ) {
            var compte = Compte()

            jsonReader.beginObject()
            while ( jsonReader.hasNext() ){
                val clé = jsonReader.nextName()
                when (clé) {
                    "idCompte" -> {
                        compte.idCompte = jsonReader.nextInt()
                    }
                    "prénom" -> {
                        compte.prénom = jsonReader.nextString()
                    }
                    "nom" -> {
                        compte.nom = jsonReader.nextString()
                    }
                    "doublons" -> {
                        compte.doublons = jsonReader.nextInt()
                    }
                    "courriel" -> {
                        compte.courriel = jsonReader.nextString()
                    }
                    "pseudonyme" -> {
                        compte.pseudonyme = jsonReader.nextString()
                    }
                    "programme" -> {
                        compte.programme = jsonReader.nextString()
                    }
                    "motDePasse" -> {
                        compte.motDePasse = jsonReader.nextString()
                    }
                    "avatar" -> {
                        compte.avatar = stringToBitMap(jsonReader.nextString())
                    }
                    "nomÉquipage" -> {
                        compte.nomÉquipage = jsonReader.nextString()
                    }
                    else -> {
                        jsonReader.skipValue()
                    }
                }
            }
            jsonReader.endObject()
            liste.add(compte)
        }
        jsonReader.endArray()
        return liste
    }

    /**
     * Méthode qui convertit la réponse JSON en objet kotlin Compte.
     *
     * @param jsonReader Objet permettant la lecture d'un objet JSON
     */
    private fun réponseJsonToÉquipage(jsonReader: JsonReader): Équipage {
        val équipage = Équipage()
        var arrayComptes = arrayOf<Compte>()

        jsonReader.beginObject()

        while (jsonReader.hasNext()) {

            val clé = jsonReader.nextName()

            when (clé) {
                "nomÉquipage" -> {
                    équipage.nomÉquipage = jsonReader.nextString()
                }
                "rang" -> {
                    équipage.rang = jsonReader.nextInt()
                }
                "doublons" -> {
                    équipage.doublons = jsonReader.nextInt()
                }
                "listeComptes" -> {
                    jsonReader.beginArray()

                    while (jsonReader.hasNext()) {
                        arrayComptes += réponseJsonToCompte( jsonReader )
                    }

                    jsonReader.endArray()
                }

                else -> {
                    jsonReader.skipValue()
                }
            }
        }
        jsonReader.endObject()

        return équipage
    }

    /**
     * Méthode qui convertit la réponse JSON en objet kotlin Compte.
     *
     * @param jsonReader Objet permettant la lecture d'un objet JSON
     */
    private fun réponseJsonToTrésorerie( jsonReader: JsonReader ): MutableList<Équipage>? {
        val liste = mutableListOf<Équipage>()

        jsonReader.beginArray()
        while ( jsonReader.hasNext() ) {
            var équipage = Équipage()

            jsonReader.beginObject()
            while ( jsonReader.hasNext() ){
                val clé = jsonReader.nextName()
                when (clé) {
                    "nomÉquipage" -> {
                        équipage.nomÉquipage = jsonReader.nextString()
                    }
                    "rang" -> {
                        équipage.rang = jsonReader.nextInt()
                    }
                    "doublons" -> {
                        équipage.doublons = jsonReader.nextInt()
                    }
                    else -> {
                        jsonReader.skipValue()
                    }
                }
            }
            jsonReader.endObject()
            liste.add(équipage)
        }
        jsonReader.endArray()
        return liste
    }

    /**
     * Méthode qui convertit la réponse JSON en objet kotlin Compte.
     *
     * @param jsonReader Objet permettant la lecture d'un objet JSON
     */
    private fun réponseJsonToQuestionnaire(jsonReader: JsonReader): Questionnaire {
        val questionnaire = Questionnaire()

        jsonReader.beginObject()

        while (jsonReader.hasNext()) {

            val clé = jsonReader.nextName()

            when (clé) {
                "id" -> {
                    questionnaire.id = jsonReader.nextInt()
                }
                "question" -> {
                    questionnaire.question = jsonReader.nextString()
                }
                "rep_A" -> {
                    questionnaire.rep_A = jsonReader.nextString()
                }
                "rep_B" -> {
                    questionnaire.rep_B = jsonReader.nextString()
                }
                "rep_C" -> {
                    questionnaire.rep_C = jsonReader.nextString()
                }
                "rep_D" -> {
                    questionnaire.rep_D = jsonReader.nextString()
                }
                else -> {
                    jsonReader.skipValue()
                }
            }
        }
        jsonReader.endObject()

        return questionnaire
    }

    /**
     * Méthode qui convertit la réponse JSON en objet kotlin Compte.
     *
     * @param jsonReader Objet permettant la lecture d'un objet JSON
     */
    private fun réponseJsonToBonneReponse(jsonReader: JsonReader): String {
        val questionnaire = Questionnaire()

        jsonReader.beginObject()

        while (jsonReader.hasNext()) {

            val clé = jsonReader.nextName()

            when (clé) {
                "bonneReponse" -> {
                    questionnaire.bonneReponse = jsonReader.nextString()
                }
                else -> {
                    jsonReader.skipValue()
                }
            }
        }
        jsonReader.endObject()

        return questionnaire.bonneReponse
    }

    /**
     * Fonction tiré de : https://stackoverflow.com/questions/23005948/convert-string-to-bitmap
     */
    fun stringToBitMap(encodedString: String?): Bitmap? {
        return try {
            val encodeByte = Base64.decode(encodedString, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: Exception) {
            e.message
            null
        }
    }
}