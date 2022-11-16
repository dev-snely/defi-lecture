package com.dti.defilecture.présentation.équipage

import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.sourceDeDonnées.*
import com.dti.defilecture.présentation.équipage.ContratVuePrésentateurÉquipage.IVueÉquipage
import com.dti.defilecture.présentation.équipage.ContratVuePrésentateurÉquipage.IPrésentateurÉquipage

class PrésentateurÉquipage(var modèle : modèle, var vue: IVueÉquipage):
    ContratVuePrésentateurÉquipage.IPrésentateurÉquipage {

    init {
        Remplir()
    }


}