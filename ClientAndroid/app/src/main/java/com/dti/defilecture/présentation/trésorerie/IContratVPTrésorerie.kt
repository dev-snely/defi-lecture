package com.dti.defilecture.présentation.trésorerie

import com.dti.defilecture.domaine.entité.Équipage

/**
 * Interface de contrats établissant les méthodes utiliser
 * dans un présentateur et sa vue correspondante.
 *
 */
interface IContratVPTrésorerie {
    /**
     * Définit les méthodes à utiliser dans une vue Trésorerie.
     */
    interface IVueTrésorerie{
        fun naviguerVersUnÉquipage()
    }

    /**
     * Définit les méthodes à utiliser dans un présentateur Trésorerie.
     */
    interface IPrésentateurTrésorerie{
        fun initisaliseurDesÉquipages(): MutableList<Équipage>?
    }
}