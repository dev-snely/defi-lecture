package com.dti.defilecture.présentation.voirlectures



import com.dti.defilecture.présentation.voirlectures.IContratVPMesLectures.IVueMesLectures
import org.mockito.Mockito
import kotlin.test.Test
import kotlin.test.assertEquals

class PrésentateurVoirLecturesTest {

    @Test
    fun `test étant donné un PrésentateurMesLectures, losqu'on reçoit une requête «requêteNaviguerVersAjoutTitreLecture», la vue passe à l'écran d'ajouter titre lecture`() {

        // Mise en place
        val mockVue = Mockito.mock( IVueMesLectures::class.java )
        val présentateur = PrésentateurMesLectures( mockVue )

        // Action
        présentateur.requêteNaviguerVersAjoutTitreLecture()

        // Validation
        Mockito.verify( mockVue ).naviguerVersAjoutTitreLecture()
    }

    //Manque Test pour requêteRécupérationLecturesUtilisateurConnecté
}