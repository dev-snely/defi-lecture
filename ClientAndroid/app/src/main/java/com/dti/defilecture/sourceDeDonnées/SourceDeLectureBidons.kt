package com.dti.defilecture.sourceDeDonnées

import android.os.Build
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.intéracteur.SourceDeLecture
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*


class SourceDeLectureBidons : SourceDeLecture{
    init {
        Remplir()
    }
    override fun récupérerListeDeLecture(): List<Lecture>? {
        return if(lectures.isNullOrEmpty()) null else lectures
    }
    override fun ajouterUneLecture(uneLecture: Lecture) {
        lectures?.add(uneLecture)
    }
}

var lectures: MutableList<Lecture>? = null
val date = getCurrentDateTime()
val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())


fun Remplir() {
    if (lectures.isNullOrEmpty()) {
        lectures = mutableListOf(
            Lecture("Alchimiste", formatter.format(date), 75, true),
            Lecture("Tartuffle", formatter.format(date), 120, false),
            Lecture("Rouge Poison", formatter.format(date), 75, false),
            Lecture("Tartuffle", formatter.format(date), 75, false)
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

