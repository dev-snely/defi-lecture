package com.dti.defilecture.accesAuxDonnees

import com.dti.defilecture.domaine.entité.Compte

class SourceDeCompteBidons: ISourceDeCompte {

    override fun validerComptePourLaConnexion( pseudo : String, mdp : String ): Compte?{

        var _compte: Compte? = null

        for(compte in listeDeCompte){
           if ( compte.pseudonyme == pseudo && compte.motDePasse == mdp){
                _compte = compte
           }
        }
        return _compte
    }

    var listeDeCompte : MutableList<Compte> = mutableListOf(
        Compte(1,null,"John", "Doe", 30,"john@gmail.com",
            "Barbossa", "Informatique", 1, "johndoe", true, null),
        Compte(2,1,"Jess", "Foe", 30,"jesss@gmail.com",
            "Sparrow", "Administration", 2, "blackpearl", false, null)
    )
}