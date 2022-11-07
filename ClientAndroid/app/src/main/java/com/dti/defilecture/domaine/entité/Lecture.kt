package com.dti.defilecture.domaine.entité

import android.os.Build
import androidx.annotation.RequiresApi
import java.sql.Date
import java.time.LocalDate
import java.time.LocalDateTime

class Lecture( val titreLecture: String,val dateInscription: Date,
               val duréeMinutes: Int, val obligatoire: Boolean )