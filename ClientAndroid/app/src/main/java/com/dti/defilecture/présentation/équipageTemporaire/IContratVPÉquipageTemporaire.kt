package com.dti.defilecture.présentation.équipageTemporaire

import com.dti.defilecture.domaine.entité.Compte

/**
 * Interface de contrats établissant les méthodes utiliser
 * dans un présentateur et sa vue correspondante.
 *
 */
interface IContratVPÉquipageTemporaire {
    /**
     * Définit les méthodes à utiliser dans une vue ÉquipageTemporaire.
     */
    interface IVueÉquipageTemporaire{
        fun afficherTotalDoublons()

        fun afficherRang()

        fun naviguerVersDétailsCompteTemporaire()

        fun naviguerVersDétailsCompteActif()
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur ÉquipageTemporaire.
     */
    interface IPrésentateurÉquipageTemporaire{
        fun initisaliseurDesComptesTemporaires(nomÉquipage: String): MutableList<Compte>?

        fun requêteVoirDétailsCompteTemporaire(pseudonyme: String, nomÉquipage: String)

        fun rejoindreÉquipage(compte: Compte)
    }
}