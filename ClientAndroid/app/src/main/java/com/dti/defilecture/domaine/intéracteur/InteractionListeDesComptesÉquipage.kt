package com.dti.defilecture.domaine.intéracteur

import com.dti.defilecture.accesAuxDonnees.ISourcesDesComptesÉquipage
import com.dti.defilecture.accesAuxDonnees.SourceDeComptesBidons
import com.dti.defilecture.domaine.entité.Compte

class InteractionListeDesComptesÉquipage(  ) {


    var sourceDeDonnées: ISourcesDesComptesÉquipage = SourceDeComptesBidons()

    var compte: Compte = Compte("","",0, "", "", "", "")

    /**
    Initialise une lecture en la rendant vide lorsque
    l'utilisateur décide d'ajouter une lecture.

    @param lecture La lecture qui sera ajouter dans la liste de lecture de l'utilisateur
     */
    fun initialiser(): Compte{
        return compte
    }

    /**
     *  Permet d'obtenir une liste de lecture.
     */
    fun obtenirListe(): MutableList<Compte>?{
        return sourceDeDonnées.obtenirListeDesComptesÉquipage()
    }



}