package com.dti.defilecture.domaine.entité

import android.os.Build
import androidx.annotation.RequiresApi
import java.sql.Date
import java.time.LocalDate
import java.time.LocalDateTime

class Lecture() {
    var Titre: String = ""
    @RequiresApi(Build.VERSION_CODES.O)
    var DateInscription: LocalDate = LocalDate.now()
    var duréeMinutes : Int = 0
    var obligatoire : Boolean = false
}