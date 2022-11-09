package com.dti.defilecture.sourceDeDonnées

import android.os.Build
import androidx.annotation.RequiresApi
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.intéracteur.SourceDeLecture
import java.sql.Date
import java.time.LocalDate


class SourceDeLectureBidons : SourceDeLecture{
    override fun récupérerListeDeLecture(): List<Lecture> {
        TODO("Not yet implemented")
    }
    override fun ajouterUneLecture(uneLecture: Lecture) {
        TODO("Not yet implemented")
    }
}

var lectures: MutableList<Lecture>? = null

@RequiresApi(Build.VERSION_CODES.O)
fun Remplir() {
    if (lectures.isNullOrEmpty()) {
        lectures = mutableListOf(
            Lecture("Alchimiste", LocalDate.now(), 75, true),
            Lecture("Tartuffle", LocalDate.now(), 120, false),
            Lecture("Rouge Poison", LocalDate.now(), 75, false),
            Lecture("Tartuffle", LocalDate.now(), 75, false)
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
