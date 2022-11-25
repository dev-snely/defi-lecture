package com.dti.defilecture.présentation.équipage

import com.dti.defilecture.accesAuxDonnees.*
import com.dti.defilecture.présentation.équipage.ContratVuePrésentateurÉquipage.IVueÉquipage

class PrésentateurÉquipage( var vue: IVueÉquipage ):
    ContratVuePrésentateurÉquipage.IPrésentateurÉquipage {

    init {
        Remplir()
    }


}