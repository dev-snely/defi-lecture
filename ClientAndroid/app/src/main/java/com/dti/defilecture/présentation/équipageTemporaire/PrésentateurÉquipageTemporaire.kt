package com.dti.defilecture.présentation.équipageTemporaire

import com.dti.defilecture.accèsAuxDonnées.AccèsRessourcesException
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.présentation.équipageTemporaire.IContratVPÉquipageTemporaire.*
import kotlinx.coroutines.*

class PrésentateurÉquipageTemporaire (var vue: IVueÉquipageTemporaire): IPrésentateurÉquipageTemporaire {

    override fun initisaliseurDesComptesTemporaires() {
        GlobalScope.launch(Dispatchers.Main) {

            val job = async(SupervisorJob() + Dispatchers.IO) {
                modèle.obtenirListeDesComptesÉquipageTemporaire()
            }

            try {
                val listeComptes = job.await()
                vue.gestionAfficherComptesÉquipageTemporaire(listeComptes)
            }
            catch(e: AccèsRessourcesException){
                //vue.afficherMessageErreurInternet()
            }
        }
    }

    override fun requêteVoirDétailsCompteTemporaire(pseudonyme: String) {
        modèle.initialiserCompte(pseudonyme)
        if (pseudonyme == modèle.compteActif().pseudonyme) {
            vue.naviguerVersDétailsCompteActif()
        } else {
            vue.naviguerVersDétailsCompteTemporaire()
        }
    }

    override fun rejoindreÉquipage(compte: Compte) {
        TODO("Not yet implemented")
    }
}