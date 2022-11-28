package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accesAuxDonnees.Trésorerie.ISourcesDeDonnéesTrésorerie
import com.dti.defilecture.accesAuxDonnees.Trésorerie.SourceÉquipagesBidons
import com.dti.defilecture.domaine.entité.Équipage

class InteractionListeDesÉquipages(  ) {


    var sourceDeDonnées: ISourcesDeDonnéesTrésorerie = SourceÉquipagesBidons()

    var équipage: Équipage = Équipage("",0,0)


    fun initialiser(): Équipage{
        return équipage
    }

    /**
     *  Permet d'obtenir une liste des équipages.
     */
    fun obtenirListe(): MutableList< Équipage >?{
        return sourceDeDonnées.obtenirListeDesÉquipages()
    }

}