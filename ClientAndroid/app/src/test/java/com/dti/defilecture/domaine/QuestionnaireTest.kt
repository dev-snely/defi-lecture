package com.dti.defilecture.domaine

import com.dti.defilecture.domaine.entité.Questionnaire
import kotlin.test.assertEquals
import kotlin.test.Test

class QuestionnaireTest {

    @Test
    fun `test étant donné une nouvelle question "Est-ce que Harry Potter est le fils de Voldemort?", lorsque j'instancie cette question, j'obtiens un objet Question avec ses informations`() {

        //Mise en place
        val id = 99
        val question = "Est-ce que Harry Potter est le fils de Voldemort?"
        val rep_A = "Oui, Voldemort est le père d'Harry Potter."
        val rep_B = "Non, Voldemort n'est pas le père d'Harry Potter."
        val rep_C = "Non, Harry Potter est le père de Voldemort."
        val rep_D = "Non, Hermione est Harry Potter."
        val bonneReponse = "Non, Voldemort n'est pas le père d'Harry Potter."

        //Action
        val résultat_obtenu = Questionnaire( id, question, rep_A, rep_B, rep_C, rep_D, bonneReponse)

        //Vérification
        assertEquals( 99, résultat_obtenu.id )
        assertEquals("Est-ce que Harry Potter est le fils de Voldemort?", résultat_obtenu.question)
        assertEquals( "Oui, Voldemort est le père d'Harry Potter.", résultat_obtenu.rep_A )
        assertEquals( "Non, Voldemort n'est pas le père d'Harry Potter.", résultat_obtenu.rep_B )
        assertEquals( "Non, Harry Potter est le père de Voldemort.", résultat_obtenu.rep_C )
        assertEquals( "Non, Hermione est Harry Potter.", résultat_obtenu.rep_D )
        assertEquals( "Non, Voldemort n'est pas le père d'Harry Potter.", résultat_obtenu.bonneReponse )


    }
}