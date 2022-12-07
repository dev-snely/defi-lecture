package com.dti.defilecture.présentation.équipage

import com.dti.defilecture.domaine.entité.Compte

/**
 * Interface de contrats établissant les méthodes utiliser
 * dans un présentateur et sa vue correspondante.
 *
 */
interface IContratVPÉquipage {
    /**
     * Définit les méthodes à utiliser dans une vue Équipage.
     */
    interface IVueÉquipage{
        fun naviguerVersDétailsCompte(position: Int)
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur Équipage.
     */
    interface IPrésentateurÉquipage{
        fun initisaliseurDesComptes(nomÉquipage:String): MutableList<Compte>?

        fun requêteVoirDétailsCompte(position: Int) {

        }
    }
}