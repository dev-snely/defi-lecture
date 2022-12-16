package com.dti.defilecture.présentation.bienvenue

import org.junit.Test
import org.mockito.Mockito

class PrésentateurBienvenueTests {
    @Test
    fun `étant donné un PrésentateurBienvenue, lorsqu'on reçoit une requête « naviguerVersPageDInscription », la vue passe à l'écran d'inscription`(){

        //Mise en place
        val mockVue = Mockito.mock( IContratVPBienvenue.IVueBienvenue::class.java )
        val présentateur = PrésentateurBienvenue( mockVue )

        //Action
        présentateur.naviguerVersPageDInscription()

        //Validation
        Mockito.verify( mockVue ).naviguerVersInscription()
    }
    @Test
    fun `étant donné un PrésentateurBienvenue, lorsqu'on reçoit une requête « naviguerVersPageDeConnexion », la vue passe à l'écran de connexion`(){

        //Mise en place
        val mockVue = Mockito.mock( IContratVPBienvenue.IVueBienvenue::class.java )
        val présentateur = PrésentateurBienvenue( mockVue )

        //Action
        présentateur.naviguerVersPageDeConnexion()

        //Validation
        Mockito.verify( mockVue ).naviguerVersConnexion()
    }
}