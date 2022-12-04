package com.dti.defilecture.accèsAuxDonnées.lecture

import java.text.SimpleDateFormat
import java.util.*

val date = getCurrentDateTime()
val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
// Étant donnée notre API minimum de 21, j'ai tiré cette méthode de stackoverflow, parce que
// celle que j'utilisais, soit LocalDateTime.now() obligeais un api minimum de 26.
// Source : https://stackoverflow.com/questions/47006254/how-to-get-current-local-date-and-time-in-kotlin
// Consulté le : 15-11-2022
fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

