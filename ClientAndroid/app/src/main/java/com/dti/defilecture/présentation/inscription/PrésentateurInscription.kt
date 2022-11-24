package com.dti.defilecture.présentation.présentateur;

import com.dti.defilecture.présentation.inscription.ContratVuePrésentateurInscription.IVueInscription
import com.dti.defilecture.présentation.inscription.ContratVuePrésentateurInscription.IPrésentateurInscription

class PrésentateurInscription(var vue: IVueInscription) : IPrésentateurInscription {

    override fun traiterInscription(
        prenomCompte: String,
        nomCompte: String,
        courrielCompte: String,
        pseudonymeCompte: String,
        programmeCompte: String,
        motDePasseCompte: String
    ) {
        //Création du compte
    }

    override fun verifierInfosManquant(
        prenomCompte: String,
        nomCompte: String,
        courrielCompte: String,
        pseudonymeCompte: String,
        programmeCompte: String,
        motDePasseCompte: String,
        motDePasseCompteValidation: String
    ) {
        if ( prenomCompte.isEmpty() || nomCompte.isEmpty() || courrielCompte.isEmpty() ||
            pseudonymeCompte.isEmpty() || programmeCompte.isEmpty() ||
            motDePasseCompte.isEmpty() || motDePasseCompte != motDePasseCompteValidation
        ) {
            vue.afficherAvertissementInfosManquants("Information nécéssaires manquantes !")
        }
        else {
            vue.afficherAvertissementInfosManquants(
                prenomCompte + " " + nomCompte + " " + courrielCompte +
                        " " + pseudonymeCompte + " " + programmeCompte + " " + motDePasseCompte
            )
        }
    }
}
