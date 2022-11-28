package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accesAuxDonnees.ISourcesDesComptesÉquipage
import com.dti.defilecture.accesAuxDonnees.SourceDeComptesBidons
import com.dti.defilecture.domaine.entité.Compte

class InteractionListeDesComptesÉquipage(  ) {


    var sourceDeDonnées: ISourcesDesComptesÉquipage = SourceDeComptesBidons()

    var compte: Compte = Compte("","",0, "", "", "", "")


    fun initialiser(): Compte{
        return compte
    }

    /**
     *  Permet d'obtenir une liste des comptes d'un équipage.
     */
    fun obtenirListe(): MutableList<Compte>?{
        return sourceDeDonnées.obtenirListeDesComptesÉquipage()
    }



}