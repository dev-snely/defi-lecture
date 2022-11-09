package com.dti.defilecture.domaine.entité

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*

class Lecture(val titreLecture: String, val dateInscription: LocalDate,
              val duréeMinutes: Int, val obligatoire: Boolean )