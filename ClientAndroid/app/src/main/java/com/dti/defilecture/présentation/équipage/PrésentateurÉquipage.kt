package com.dti.defilecture.présentation.équipage

import android.util.Log
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
                val comptes = job.await()
                vue.gestionAfficherComptesÉquipage(comptes)
            }
            catch(e: AccèsRessourcesException){
                //vue.afficherMessageErreurInternet()
            }
        }
    }

    override fun requêteVoirDétailsCompte(pseudonyme: String, nomÉquipageCompteUtilisateur: String, nomÉquipage: String) {
        modèle.initialiserCompte(pseudonyme)
        if (nomÉquipageCompteUtilisateur == modèle.compteActif().nomÉquipage) {
            vue.naviguerVersDétailsCompteActif()
        } else {
            vue.naviguerVersDétailsCompteTemporaire()
        }
    }
}