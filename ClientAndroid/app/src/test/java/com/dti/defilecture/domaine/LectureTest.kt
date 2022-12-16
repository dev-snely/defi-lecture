package com.dti.defilecture.domaine

import com.dti.defilecture.domaine.entité.Lecture
import kotlin.test.assertEquals
import kotlin.test.Test

class LectureTest {

    @Test
    fun `test étant donné une nouvelle lecture "Harry Potter", lorsque j'instancie sa Lecture, j'obtiens un objet Lecture avec ses informations`() {

        //Mise en place
        val titreLecture = "Harry Potter"
        val dateInscription = "30 Septembre 2022"
        val duréeMinutes = 45
        val obligatoire = true

        //Action
        val résultat_obtenu = Lecture( titreLecture, dateInscription, duréeMinutes, obligatoire)

        //Vérification
        assertEquals( "Harry Potter", résultat_obtenu.titreLecture )
        assertEquals( "30 Septembre 2022", résultat_obtenu.dateInscription )
        assertEquals( 45, résultat_obtenu.duréeMinutes )
        assertEquals( true, résultat_obtenu.obligatoire )

    }
}