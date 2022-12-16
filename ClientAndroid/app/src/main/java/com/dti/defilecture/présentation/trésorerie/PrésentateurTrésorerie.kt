package com.dti.defilecture.présentation.trésorerie

import android.util.Log
import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.trésorerie.IContratVPTrésorerie.*
import kotlinx.coroutines.*

class PrésentateurTrésorerie(var vue: IVueTrésorerie): IPrésentateurTrésorerie {

    override fun initisaliseurDesÉquipages() {
        GlobalScope.launch(Dispatchers.Main) {

            val job = async(SupervisorJob() + Dispatchers.IO) {
                modèle.obtenirListeDesÉquipages()
            }

            try {
                val équipages = job.await()
                vue.gestionAfficherÉquipagesTrésorerie(équipages)
            }
            catch(e: AccèsRessourcesException){
                //vue.afficherMessageErreurInternet()
            }
        }
    }

    override fun requêteVoirDétailsÉquipage(nomÉquipage: String) {
        modèle.initialiserÉquipage(nomÉquipage)
        if (nomÉquipage == modèle.compteActif().nomÉquipage) {
            vue.naviguerVersDétailsÉquipage()
        } else {
            vue.naviguerVersDétailsÉquipageTemporaire()
        }
        vue.naviguerVersDétailsÉquipage()
    }
}