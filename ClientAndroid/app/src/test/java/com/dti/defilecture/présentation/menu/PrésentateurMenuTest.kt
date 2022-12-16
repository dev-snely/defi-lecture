package com.dti.defilecture.présentation.menu

import com.dti.defilecture.présentation.menu.IContratVPMenu.IVueMenu
import org.mockito.Mockito
import kotlin.test.Test
import kotlin.test.assertEquals

class PrésentateurMenuTest {

    @Test
    fun `test étant donné un PrésentateurMenu, losqu'on reçoit une requête «requêteNaviguerVersPageLangage», la vue passe à l'écran de langage`() {

        // Mise en place
        val mockVue = Mockito.mock( IVueMenu::class.java )
        val présentateur = PrésentateurMenu( mockVue )

        // Action
        présentateur.requêteNaviguerVersPageLangage()

        // Validation
        Mockito.verify( mockVue ).naviguerVersPageLangage()
    }

    @Test
    fun `test étant donné un PrésentateurMenu, losqu'on reçoit une requête «requêteNaviguerVersPageGlossaire», la vue passe à l'écran de glossaire`() {

        // Mise en place
        val mockVue = Mockito.mock( IVueMenu::class.java )
        val présentateur = PrésentateurMenu( mockVue )

        // Action
        présentateur.requêteNaviguerVersPageGlossaire()

        // Validation
        Mockito.verify( mockVue ).naviguerVersPageGlossaire()
    }

    @Test
    fun `test étant donné un PrésentateurMenu, losqu'on reçoit une requête «requêteNaviguerVersPageAPropos», la vue passe à l'écran de À Propos`() {

        // Mise en place
        val mockVue = Mockito.mock( IVueMenu::class.java )
        val présentateur = PrésentateurMenu( mockVue )

        // Action
        présentateur.requêteNaviguerVersPageAPropos()

        // Validation
        Mockito.verify( mockVue ).naviguerVersPageAPropos()
    }

    @Test
    fun `test étant donné un PrésentateurMenu, losqu'on reçoit une requête «requêteDeconnexionr», la vue passe à l'écran de deconnexion`() {

        // Mise en place
        val mockVue = Mockito.mock( IVueMenu::class.java )
        val présentateur = PrésentateurMenu( mockVue )

        // Action
        présentateur.requêteDeconnexion()

        // Validation
        Mockito.verify( mockVue ).deconnexion()
    }
}