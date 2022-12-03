package com.dti.defilecture.accesAuxDonnees.Trésorerie

import com.dti.defilecture.domaine.entité.Équipage

interface ISourcesDeDonnéesTrésorerie {
    fun obtenirListeDesÉquipages() : MutableList<Équipage>?
}