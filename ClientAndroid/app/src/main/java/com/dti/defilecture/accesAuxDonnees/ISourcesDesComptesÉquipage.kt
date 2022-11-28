package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Compte

interface ISourcesDesComptesÉquipage {
    fun obtenirListeDesComptesÉquipage() : MutableList<Compte>?
}