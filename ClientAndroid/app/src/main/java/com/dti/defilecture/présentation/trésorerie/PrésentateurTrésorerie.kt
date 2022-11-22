package com.dti.defilecture.présentation.trésorerie

import android.os.Build
import com.dti.defilecture.accesAuxDonnees.*
import com.dti.defilecture.présentation.Modèle

class PrésentateurTrésorerie(var modèle : Modèle, var vue: ContratVuePrésentateurTrésorerie.IVueTrésorerie):
    ContratVuePrésentateurTrésorerie.IPrésentateurTrésorerie {

    init {
        Remplir()
    }

}