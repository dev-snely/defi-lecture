package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Compte

interface ISourcesDeDonnéesÉquipage {
    fun obtenirListeDesComptesÉquipage() : MutableList<Compte>?
}