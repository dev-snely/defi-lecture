package com.dti.defilecture.sourceDeDonnées

import com.dti.defilecture.domaine.entité.Lecture
import java.sql.Date

/*
    Note pour les méthodes static :

Il est recommandé de résoudre la plupart des besoins
pour les méthodes static avec des fonctions au niveau du package.
Ils sont simplement déclarés en dehors d'une classe dans un fichier KT.

Lien : https://stackoverflow.com/questions/40352684/what-is-the-equivalent-of-java-static-methods-in-kotlin
*/

var lectures: MutableList<Lecture>? = null

fun Remplir() {
    if (lectures.isNullOrEmpty()) {
        lectures = mutableListOf(
            Lecture("Alchimiste", Date(2022, 6, 12), 75, true),
            Lecture("Rouge Poison", Date(2022, 7, 15), 15, false),
            Lecture("Tartuffle", Date(2022, 9, 16), 120, false),
            Lecture("Rouge Poison", Date(2022, 7, 20), 75, false),
            Lecture("Tartuffle", Date(2022, 6, 20), 75, false)
        )
    }
}

/**
 * Méthode qui permet de récupérer une liste de lectures fictives.
 */
fun récupérerListeDeLecture(): List<Lecture>? {
    return if(lectures.isNullOrEmpty()) null else lectures
}

fun ajouterUneLecture(uneLecture: Lecture) {
    lectures?.add(uneLecture)
}
