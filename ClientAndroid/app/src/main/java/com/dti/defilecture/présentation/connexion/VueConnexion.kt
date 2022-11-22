package com.dti.defilecture.présentation.connexion

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.connexion.IContratVPConnexion.IPrésentateurConnexion
import com.dti.defilecture.présentation.connexion.IContratVPConnexion.IVueConnexion
import com.dti.defilecture.présentation.connexion.PrésentateurConnexion


class VueConnexion : Fragment(), IVueConnexion {
    lateinit var navController : NavController
    private lateinit var pseudonyme: TextView
    private lateinit var mdp: TextView
    private lateinit var aLabordage: Button
    private lateinit var présentateur: IPrésentateurConnexion

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue=inflater.inflate(R.layout.fragment_connexion, container, false)
        présentateur = PrésentateurConnexion(  this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        pseudonyme=view.findViewById(R.id.pseudo)
        mdp=view.findViewById(R.id.mot_de_passe)

        aLabordage=view.findViewById(R.id.abordage)
        aLabordage.setOnClickListener {
            Log.d("ids","Pseudo: ${pseudonyme.text.toString()}, MDP: ${mdp.text.toString()} ")
            présentateur.validerIdentifiants(pseudonyme.text.toString(),mdp.text.toString())
        }
    }

    override fun connexionReussi(){
        Toast.makeText(context,"Connexion reussie",Toast.LENGTH_SHORT).show()
    }

    override fun connexionEchouer(){
        Toast.makeText(context,"pseudo ou mot de passe incorrect",Toast.LENGTH_SHORT).show()
    }

    override fun naviguerVersDefiLecture(){
        navController.navigate(R.id.action_vueConnexion_to_mainActivity)
    }
}