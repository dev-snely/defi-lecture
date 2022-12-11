package com.dti.defilecture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dti.defilecture.R
import com.dti.defilecture.accèsAuxDonnées.SourceDeDonnéesHTTP
import com.dti.defilecture.présentation.LocaleHelper
import com.dti.defilecture.présentation.modèle
import java.net.URL

class ConnexionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)
        modèle.localHelper= LocaleHelper(this)
        //modèle.sourceDeDonnées = SourceDeDonnéesHTTP( this, URL("https://f3d45bda-704e-423d-a51a-015d619ac62c.mock.pstmn.io") )
        modèle.sourceDeDonnées = SourceDeDonnéesHTTP( this, URL("http://10.0.2.2:51723") )

    }
}