package com.dti.defilecture.présentation.vue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.dti.defilecture.R
import com.dti.defilecture.présentation.modèle.Modèle
import com.dti.defilecture.présentation.présentateur.PrésentateurConnexion


class VueConnexion : Fragment() {
    private lateinit var pseudonyme: TextView
    private lateinit var mdp: TextView
    private lateinit var aLabordage: Button
    private lateinit var présentateur:PrésentateurConnexion

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue=inflater.inflate(R.layout.fragment_connexion, container, false)
        présentateur= PrésentateurConnexion(Modèle,this)
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pseudonyme=view.findViewById(R.id.pseudo)
        mdp=view.findViewById(R.id.mot_de_passe)
        aLabordage=view.findViewById(R.id.abordage)
        aLabordage.setOnClickListener {
            présentateur.validerIdentifiant(pseudonyme.text.toString(),mdp.text.toString())
        }
    }
     fun connexionReussi(){
        Toast.makeText(this.context,"Connexion reussie",Toast.LENGTH_SHORT).show()
    }
    fun connexionEchouer(){
        Toast.makeText(this.context,"pseudo ou mot de passe incorrect",Toast.LENGTH_SHORT).show()
    }
}