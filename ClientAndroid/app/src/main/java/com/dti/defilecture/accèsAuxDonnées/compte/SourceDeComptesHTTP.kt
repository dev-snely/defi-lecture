package com.dti.defilecture.accèsAuxDonnées.compte


import com.dti.defilecture.domaine.entité.Compte

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.io.StringReader

import android.util.JsonReader;
import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException

/**
 * Classe qui retourne une source de compte dans le web.
 */
class SourceDeComptesHTTP(var ctx: Context, var urlSource: URL) : ISourceDeComptes {

    override fun validerComptePourLaConnexion(pseudo: String, mdp: String): Compte? {

        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET,
            "$urlSource/api/Compte/$pseudo/$mdp", promesse, promesse)
        queue.add(requête);

        try {
            return réponseJsonToCompte( JsonReader( StringReader( promesse.get() )) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            return Compte()
        }catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
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
                "idEquipe" -> {
                    compte.idEquipe = jsonReader.nextInt()
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
                "prenom" -> {
                    compte.prenom = jsonReader.nextString()
                }
                "pseudo" -> {
                    compte.pseudonyme = jsonReader.nextString()
                }
                "role" -> {
                    compte.role = jsonReader.nextInt()
                }
                "avatar" -> {
                    compte.avatar = jsonReader.nextString()
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


}