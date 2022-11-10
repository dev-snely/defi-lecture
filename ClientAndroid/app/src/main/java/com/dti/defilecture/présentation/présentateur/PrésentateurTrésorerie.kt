package com.dti.defilecture.présentation.présentateur

import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurTrésorerie
import com.dti.defilecture.présentation.modèle.modèle
import com.dti.defilecture.sourceDeDonnées.*

@RequiresApi(Build.VERSION_CODES.O)
class PrésentateurTrésorerie(var modèle : modèle, var vue: ContratVuePrésentateurTrésorerie.IVueTrésorerie):
    ContratVuePrésentateurTrésorerie.IPrésentateurTrésorerie {

    init {
        Remplir()
    }

}