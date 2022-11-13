package com.dti.defilecture.présentation.présentateur

import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurÉquipage
import com.dti.defilecture.présentation.modèle.modèle
import com.dti.defilecture.sourceDeDonnées.*

@RequiresApi(Build.VERSION_CODES.O)
class PrésentateurÉquipage(var modèle : modèle, var vue: ContratVuePrésentateurÉquipage.IVueÉquipage):
    ContratVuePrésentateurÉquipage.IPrésentateurÉquipage {

    init {
        Remplir()
    }


}