package com.dti.defilecture.accesAuxDonnees.Équipage

import com.dti.defilecture.domaine.entité.Compte

interface ISourcesDeDonnéesÉquipage {
    fun obtenirListeDesComptesÉquipage() : MutableList<Compte>?
}