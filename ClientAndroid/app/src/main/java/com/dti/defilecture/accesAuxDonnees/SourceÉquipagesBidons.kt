package com.dti.defilecture.accesAuxDonnees

import android.util.Log
import com.dti.defilecture.domaine.entité.Équipage
import java.util.*


class SourceÉquipagesBidons : ISourcesDesÉquipages{

    init {
        RemplirÉquipages()
    }

    override fun obtenirListeDesÉquipages(): MutableList<Équipage>? {
        return équipages
    }
}

var équipages: MutableList<Équipage>? = null

fun RemplirÉquipages() {
    if (équipages.isNullOrEmpty()) {
        équipages = mutableListOf(
            Équipage( "Équipage 1", 10, 0),
            Équipage( "Équipage 2", 9, 1),
            Équipage( "Équipage 3", 8, 24),
            Équipage( "Équipage 4", 7, 56),
            Équipage( "Équipage 5", 6, 64),
            Équipage( "Équipage 6", 5, 69),
            Équipage( "Équipage 7", 4, 81),
            Équipage( "Équipage 8", 3, 99),
            Équipage( "Équipage 9", 2, 100),
            Équipage( "Équipage 10", 1, 1000)
        )
    }
}

