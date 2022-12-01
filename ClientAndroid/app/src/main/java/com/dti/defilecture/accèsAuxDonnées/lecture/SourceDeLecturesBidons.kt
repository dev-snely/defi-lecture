package com.dti.defilecture.accèsAuxDonnées.lecture

import com.dti.defilecture.domaine.entité.Lecture
import java.text.SimpleDateFormat
import java.util.*


class SourceDeLectureBidons : ISourceDeLectures {

    init {
        Remplir()
    }

    override fun obtenirListeDeLecturesBidon(): MutableList<Lecture>? {
        return lectures
    }

    override fun ajouterUneLectureALaListe(uneLecture: Lecture) {
        lectures?.add( uneLecture )
    }
}

var lectures: MutableList<Lecture>? = null
val date = getCurrentDateTime()
val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

fun Remplir() {
    if (lectures.isNullOrEmpty()) {
        lectures = mutableListOf(
            Lecture("Alchimiste", formatter.format(date), 75, false),
            Lecture("Tartuffle", formatter.format(date), 45, true),
            Lecture("Tartuffle", formatter.format(date), 30, true),
            Lecture("Le Joueur", formatter.format(date), 60, false)
        )
    }
}

// Étant donnée notre API minimum de 21, j'ai tiré cette méthode de stackoverflow, parce que
// celle que j'utilisais, soit LocalDateTime.now() obligeais un api minimum de 26.
// Source : https://stackoverflow.com/questions/47006254/how-to-get-current-local-date-and-time-in-kotlin
// Consulté le : 15-11-2022
fun getCurrentDateTime(): java.util.Date {
    return Calendar.getInstance().time
}

