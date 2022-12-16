package com.dti.defilecture.domaine

import com.dti.defilecture.domaine.entité.Compte
import kotlin.test.Test
import kotlin.test.assertEquals


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
        val motDePasse = "allo12345"
        val avatar = null
        val nomÉquipage = "Empire"

        //Action
        val résultat_obtenu = Compte( idCompte, prénom, nom, doublons, courriel, pseudonyme, programme,motDePasse, avatar, nomÉquipage)

        //Vérification
        assertEquals( 99, résultat_obtenu.idCompte )
        assertEquals( "Julie", résultat_obtenu.prénom )
        assertEquals( "Dufrène", résultat_obtenu.nom )
        assertEquals( 28, résultat_obtenu.doublons )
        assertEquals("julie@crosemont.qc.ca", résultat_obtenu.courriel)
        assertEquals("Jullieta", résultat_obtenu.pseudonyme)
        assertEquals("Informatique", résultat_obtenu.programme)
        assertEquals("allo12345", résultat_obtenu.motDePasse)
        assertEquals(null, résultat_obtenu.avatar)
        assertEquals("Empire", résultat_obtenu.nomÉquipage)
    }
}