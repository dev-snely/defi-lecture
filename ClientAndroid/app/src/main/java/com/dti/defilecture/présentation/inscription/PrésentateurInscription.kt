package com.dti.defilecture.présentation.présentateur;


import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.présentation.inscription.ContratVuePrésentateurInscription
import com.dti.defilecture.présentation.modèle

@RequiresApi(Build.VERSION_CODES.O)
class PrésentateurInscription(var modèle : modèle,
                              var vue: ContratVuePrésentateurInscription.IVueInscription):
    ContratVuePrésentateurInscription.IPrésentateurInscription {

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
        if (prenomCompte.isEmpty() || nomCompte.isEmpty() || courrielCompte.isEmpty()
            || pseudonymeCompte.isEmpty() || programmeCompte.isEmpty() ||
            motDePasseCompte.isEmpty() || (motDePasseCompte != motDePasseCompteValidation)) {
                vue.afficherAvertissementInfosManquants("Information nécéssaires manquantes !")
            }else {
                vue.afficherAvertissementInfosManquants(prenomCompte+ " "+nomCompte+" "+courrielCompte+
                        " "+pseudonymeCompte+ " "+programmeCompte+ " "+motDePasseCompte)
            }
    }


}
