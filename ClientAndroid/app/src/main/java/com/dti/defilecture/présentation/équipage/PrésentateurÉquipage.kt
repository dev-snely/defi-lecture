package com.dti.defilecture.présentation.équipage

import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.IVueÉquipage
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.équipage.IContratVPÉquipage.*
import kotlinx.coroutines.*

class PrésentateurÉquipage(var vue: IVueÉquipage): IPrésentateurÉquipage {

    override fun initisaliseurDesComptes(nomÉquipage: String) {
        GlobalScope.launch(Dispatchers.Main) {

            val job = async(SupervisorJob() + Dispatchers.IO) {
                modèle.obtenirListeDesComptesÉquipage(nomÉquipage)
            }

            try {
                val listeComptes = job.await()
                vue.gestionAfficherComptesÉquipage(listeComptes)
            }
            catch(e: AccèsRessourcesException){
                //vue.afficherMessageErreurInternet()
            }
        }
    }

    override fun requêteVoirDétailsCompte(pseudonyme: String, nomÉquipage: String) {
        modèle.initialiserCompte(pseudonyme, nomÉquipage)
        if (pseudonyme == modèle.compteActif().pseudonyme) {
            vue.naviguerVersDétailsCompteActif()
        } else {
            vue.naviguerVersDétailsCompteTemporaire()
        }
    }
}