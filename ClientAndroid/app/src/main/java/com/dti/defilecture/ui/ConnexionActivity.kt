package com.dti.defilecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dti.defilecture.R
import com.dti.defilecture.accèsAuxDonnées.compte.SourceDeComptesHTTP
import com.dti.defilecture.présentation.modèle
import java.net.URL

class ConnexionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)

        modèle.sourceDeCompte = SourceDeComptesHTTP( this.applicationContext, URL("http://localhost:51723"))
    }
}