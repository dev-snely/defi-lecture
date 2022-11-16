package com.dti.defilecture.présentation.équipage

import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.sourceDeDonnées.*

class PrésentateurÉquipage(var modèle : modèle, var vue: ContratVuePrésentateurÉquipage.IVueÉquipage):
    ContratVuePrésentateurÉquipage.IPrésentateurÉquipage {

    init {
        Remplir()
    }


}