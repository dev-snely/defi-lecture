package com.dti.defilecture.présentation.langage
import android.util.Log
import com.dti.defilecture.présentation.langage.IContratVPLangage.IPrésentateurLangage
import com.dti.defilecture.présentation.langage.IContratVPLangage.IVueLangage

import com.dti.defilecture.présentation.modèle

class PrésentateurLangage(var vue: IVueLangage) : IPrésentateurLangage {

    override fun changerLangueFrançais() {
        modèle.localHelper?.setLocale("fr-rCA")
        Log.d("Test","${modèle.localHelper?.getLanguage()}")
        vue.boutonActifFrançais()
    }

    override fun changerLangueEnglish() {
        modèle.localHelper?.setLocale("en-rCA")
        vue.boutonActifEnglish()
        Log.d("Test","${modèle.localHelper?.getLanguage()}")
    }


}