package com.dti.defilecture.accesAuxDonnees

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.io.StringReader

import android.util.JsonReader;
import com.dti.defilecture.domaine.entité.Compte

class SourceDeDonnéesÉquipageHTTP(var ctx: Context, var urlSource: URL) : ISourcesDeDonnéesÉquipage {
    override fun obtenirListeDesComptesÉquipage(): MutableList<Compte> {
        val queue = Volley.newRequestQueue(ctx)

        val promesse: RequestFuture<String> = RequestFuture.newFuture()

        val requête = StringRequest(Request.Method.GET, urlSource.toString(), promesse, promesse)
        queue.add(requête);

        try {
            return réponseJsonToComptes( JsonReader(StringReader(promesse.get())) )
        } catch (e: InterruptedException) {
            e.printStackTrace()
            return arrayOf<Compte>().toMutableList()
        } catch (e: ExecutionException) {
            throw AccèsRessourcesException( e )
        }
    }

    private fun réponseJsonToComptes( jsonReader : JsonReader ): MutableList<Compte> {
        var prénomCompte = ""
        var nomCompte = ""
        var doublonsCompte = 0
        var courrielCompte = ""
        var pseudonymeCompte = ""
        var programCompte = ""
        var motDePasseCompte = ""
        var comptes = mutableListOf<Compte>()

        jsonReader.beginObject()

        while (jsonReader.hasNext()) {
            val clé = jsonReader.nextName()

            when (clé) {
                "prénomCompte" -> {
                    prénomCompte = jsonReader.nextString()
                }

                "nomCompte" -> {
                    nomCompte = jsonReader.nextString()
                }

                "doublonsCompte" -> {
                    doublonsCompte = jsonReader.nextInt()
                }

                "courrielCompte" -> {
                    courrielCompte = jsonReader.nextString()
                }

                "pseudonymeCompte" -> {
                    pseudonymeCompte = jsonReader.nextString()
                }

                "programCompte" -> {
                    programCompte = jsonReader.nextString()
                }

                "motDePasseCompte" -> {
                    motDePasseCompte = jsonReader.nextString()
                }

                "comptes" -> {
                    jsonReader.beginArray()

                    while (jsonReader.hasNext()) {
                        comptes += compteJsonToCompte( jsonReader )
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

    private fun compteJsonToCompte( jsonReader : JsonReader ) : Compte {
        var prénomCompte: String? = null
        var nomCompte: String? = null
        var doublonsCompte: Int? = null
        var courrielCompte: String? = null
        var pseudonymeCompte: String? = null
        var programCompte: String? = null
        var motDePasseCompte: String? = null

        jsonReader.beginObject()

        while (jsonReader.hasNext()) {
            val clé = jsonReader.nextName()
            if (clé == "prénomCompte") {
                prénomCompte = jsonReader.nextString()
            }
            if (clé == "nomCompte") {
                nomCompte = jsonReader.nextString()
            }
            if (clé == "doublonsCompte") {
                doublonsCompte = jsonReader.nextInt()
            }
            if (clé == "courrielCompte") {
                courrielCompte = jsonReader.nextString()
            }
            if (clé == "pseudonymeCompte") {
                pseudonymeCompte = jsonReader.nextString()
            }
            if (clé == "programCompte") {
                programCompte = jsonReader.nextString()
            }
            if (clé == "motDePasseCompte") {
                motDePasseCompte = jsonReader.nextString()
            }
        }

        jsonReader.endObject()

        return Compte(prénomCompte ?: "Anonyme", nomCompte ?: "Anonyme",
            doublonsCompte ?: 0, courrielCompte ?: "email@domaine.com",
            pseudonymeCompte ?: "Anonyme", programCompte ?: "N/A",
            motDePasseCompte ?: "")
    }
}