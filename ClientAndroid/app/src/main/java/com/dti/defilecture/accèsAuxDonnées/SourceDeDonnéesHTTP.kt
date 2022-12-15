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
        queue.add(requête);

        return try {
            réponseJsonToCompte( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Compte()
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }

    }

    override fun obtenirListeDesComptes(nomÉquipage: String): MutableList<Compte>? {
        TODO("Not yet implemented")
    }

    override fun obtenirListeDeLecturesUtilisateur(identifiant: Int): MutableList<Lecture>? {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET,
            "$urlSource/api/Lectures/compte/$identifiant", promesse, promesse)
        queue.add(requête)

        return try {
            réponseJsonToLecture( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            mutableListOf<Lecture>( Lecture("","",0,false) )
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
    }

    override fun ajouterUneLectureALaListe(lecture: Lecture) {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.POST,
            "$urlSource/api/Lectures/compte/$lecture", promesse, promesse)
        queue.add(requête)
    }

    override fun obtenirQuestions(): Array<Questionnaire> {
        TODO("Not yet implemented")
    }

    override fun obtenirListeDesÉquipages(): MutableList<Équipage>? {
        TODO("Not yet implemented")
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
                "role" -> {
                    compte.role = jsonReader.nextInt()
                }
                "avatar" -> {
                    compte.avatar = stringToBitMap(jsonReader.nextString())
                }
                "point" -> {
                    compte.doublons = jsonReader.nextInt()
                }
                "programme" -> {
                    compte.programme = jsonReader.nextString()
                }
                "devenirCapitaine" -> {
                    compte.devenirCapitaine = jsonReader.nextBoolean()
                }
                else -> {
                    jsonReader.skipValue()
                }
            }
        }
        jsonReader.endObject()

        return compte
    }

    private fun réponseJsonToLecture( jsonReader: JsonReader ): MutableList<Lecture>? {
        val liste = mutableListOf<Lecture>()

        jsonReader.beginArray()
        while ( jsonReader.hasNext() ) {
            var lecture = Lecture("","",0,false)

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