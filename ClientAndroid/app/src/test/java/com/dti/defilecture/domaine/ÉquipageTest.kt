package com.dti.defilecture.domaine

import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Équipage
import kotlin.test.assertEquals
import kotlin.test.Test

class ÉquipageTest {

    @Test
    fun `test étant donné un nouveau équipage "Rebel", lorsque j'instancie son Équipage, j'obtiens un objet Équipage avec ses informations`() {

        //Mise en place
        val nomÉquipage = "Rebel"
        val rang = 1
        val doublons = 28
        val listeComptes = mutableListOf(
            Compte(1,"John", "Doe", 30,"john@gmail.com",
                "Barbossa", "Informatique", "johndoe", null, "unÉquipage"),
            Compte(2,"Jess", "Foe", 30,"jesss@gmail.com",
                "Sparrow", "Administration", "blackpearl", null, "unÉquipage"),
            Compte(3, "Snely", "Man", 60, "snel@gmail.com",
                "Jotaro", "Info","okokok", null, "unÉquipage")
        )

        //Action
        val résultat_obtenu = Équipage( nomÉquipage, rang, doublons, listeComptes)

        //Vérification
        assertEquals( "Rebel", résultat_obtenu.nomÉquipage )
        assertEquals( 1, résultat_obtenu.rang )
        assertEquals( 28, résultat_obtenu.doublons )
        assertEquals( "Snely", résultat_obtenu.listeComptes[2].prénom)

    }
}