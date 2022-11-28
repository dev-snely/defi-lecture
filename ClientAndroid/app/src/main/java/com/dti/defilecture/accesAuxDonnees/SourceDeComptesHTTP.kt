package com.dti.defilecture.accesAuxDonnees


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.io.StringReader

import android.util.JsonReader;
import com.dti.defilecture.domaine.entité.Compte
import org.json.JSONObject;
import org.json.JSONException;


class SourceDeComptesHTTP(var ctx: Context, var urlSource: URL) : ISourceDeCompte {


    override fun validerComptePourLaConnexion(pseudo: String, mdp: String): Compte? {
        /**
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET, urlSource.toString(), promesse, promesse)

        queue.add(requête);

        try {
            return réponseJsonToComptes( JsonReader( StringReader( promesse.get() ) ) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            return Compte()
        }
        **/
        return null
    }

    /**
    private fun réponseJsonToComptes( jsonReader : JsonReader ): Compte? {
        var compte = Compte()

        jsonReader.beginObject()

        while (jsonReader.hasNext()) {
            val clé = jsonReader.nextName()

            when (clé) {
                "nb_scores" -> {
                    //nb_scores = jsonReader.nextInt()
                }

                "scores" -> {
                    jsonReader.beginArray()

                    while (jsonReader.hasNext()) {
                        //scores += scoreJsonToScore( jsonReader )
                    }

                    jsonReader.endArray()
                }

                else -> {
                    jsonReader.skipValue()
                }
            }
        }
        jsonReader.endObject()

        return comptes
    }


**/

}