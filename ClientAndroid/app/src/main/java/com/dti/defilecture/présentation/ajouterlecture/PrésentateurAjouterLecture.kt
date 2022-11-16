package com.dti.defilecture.présentation.ajouterlecture

import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.présentation.modèle
import com.dti.defilecture.sourceDeDonnées.*
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class PrésentateurAjouterLecture(var modèle : modèle,
                                 var vue: ContratVuePrésentateurAjouterLecture.IVueAjouterLecture):
    ContratVuePrésentateurAjouterLecture.IPrésentateurAjouterLecture {

    init {
        Remplir()
    }

    override fun traiterObligationDeLecture() {
        vue.afficherObligationDeLecture()
    }


    override fun traiterAjouterMinutes(minuteAAjouter: Int, texteAuCompteur: String) {
        var texteAvecChiffreSeulement = texteAuCompteur.filter { it.isDigit() }
        var mins: Int = texteAvecChiffreSeulement.toInt()
        mins += minuteAAjouter
        vue.modifierMinutesAuCompteur(mins)
    }

    override fun traiterAjouterLecture(titre: String,
                                       minutes: Int,
                                       obligationSelectionné: Boolean,
                                       lectureObligé: Boolean ) {
        if( titre.isNotEmpty() && minutes != 0 && obligationSelectionné ){

            val aujourdhui = LocalDate.now()
            if( !lectureObligé ){
               // doubler les doublons gagné par le joueur.
            }
            modèle.lecture = Lecture( titre, getCurrentDateTime().toString(), minutes, lectureObligé )
        }
        modèle.ajouterLectureDansSourceDeDonnée(modèle.lecture)
    }

    override fun traiterReinitialisationCompteur() {
        vue.réinitialiserMinutesAuCompteur()
    }

    override fun traiterValiderLecture(titre: String, minutes: Int, obligation: Boolean) {

    }

    override fun avertirInfosManquant(titre: String, minutes: Int, obligation: Boolean) {
        if(titre.isEmpty() || minutes == 0 || !obligation){
            vue.afficherAvertissementInfosManquants("Entrer les informations nécéssaires.")
        }
    }

    override fun avertirAjoutReussi(titre: String, minutes: Int, obligation: Boolean) {
        if(titre.isNotEmpty() || minutes != 0 || obligation){
            vue.afficherAvertissementInfosManquants("Ajout Réussi")
        }
    }


}