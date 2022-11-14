package com.dti.defilecture.présentation.présentateur;


import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurInscription;
import com.dti.defilecture.présentation.modèle.modèle

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
        TODO("Not yet implemented")
    }

    override fun avertirInfosManquant(
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
            }
    }


}
