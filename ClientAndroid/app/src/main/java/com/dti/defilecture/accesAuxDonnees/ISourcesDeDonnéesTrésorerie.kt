package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Équipage

interface ISourcesDeDonnéesTrésorerie {
    fun obtenirListeDesÉquipages() : MutableList<Équipage>?
}