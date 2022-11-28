package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Équipage

interface ISourcesDesÉquipages {
    fun obtenirListeDesÉquipages() : MutableList<Équipage>?
}