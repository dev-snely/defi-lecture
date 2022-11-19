package com.dti.defilecture.présentation.trésorerie

import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.accesAuxDonnees.*

@RequiresApi(Build.VERSION_CODES.O)
class PrésentateurTrésorerie(var modèle : modèle, var vue: ContratVuePrésentateurTrésorerie.IVueTrésorerie):
    ContratVuePrésentateurTrésorerie.IPrésentateurTrésorerie {

    init {
        Remplir()
    }

}