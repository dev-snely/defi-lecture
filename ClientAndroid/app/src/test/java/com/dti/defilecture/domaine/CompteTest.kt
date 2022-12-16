package com.dti.defilecture.domaine

import com.dti.defilecture.domaine.entité.Compte
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class CompteTest {

    @Test
    fun `test étant donné un nouveau compte "Julie", lorsque j'instancie son Compte, j'obtiens un objet Compte avec ses informations`() {

        //Mise en place
        val idCompte = 99
        val prénom = "Julie"
        val nom = "Dufrène"
        val doublons = 28
        val courriel = "julie@crosemont.qc.ca"
        val pseudonyme = "Jullieta"
        val programme = "Informatique"
        val role = 1
        val motDePasse = "allo12345"
        val devenirCapitaine = false
        val avatar = null

        //Action
        val résultat_obtenu = Compte( idCompte, prénom, nom, doublons, courriel, pseudonyme, programme, role, motDePasse, devenirCapitaine, avatar)

        //Vérification
        assertEquals( 99, résultat_obtenu.idCompte )
        assertEquals( "Julie", résultat_obtenu.prénom )
        assertEquals( "Dufrène", résultat_obtenu.nom )
        assertEquals( 28, résultat_obtenu.doublons )
        assertEquals("julie@crosemont.qc.ca", résultat_obtenu.courriel)
        assertEquals("Jullieta", résultat_obtenu.pseudonyme)
        assertEquals("Informatique", résultat_obtenu.programme)
        assertEquals(1, résultat_obtenu.role)
        assertEquals("allo12345", résultat_obtenu.motDePasse)
        assertEquals(false, résultat_obtenu.devenirCapitaine)
        assertEquals(null, résultat_obtenu.avatar)
    }

}