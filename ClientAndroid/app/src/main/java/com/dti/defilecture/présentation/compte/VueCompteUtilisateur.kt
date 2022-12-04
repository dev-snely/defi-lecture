package com.dti.defilecture.présentation.compte

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.compte.IContratVPCompte.IPrésentateurCompte
import com.dti.defilecture.présentation.compte.IContratVPCompte.IVueCompte

class VueCompteUtilisateur : Fragment(), IVueCompte{

    lateinit var présentateur: IPrésentateurCompte
    lateinit var navController : NavController
    lateinit var btnModifierInfo : ImageButton
    lateinit var btnModifierPhoto : ImageButton
    lateinit var btnParametre: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_compte_utilisateur, container, false)
        présentateur = PrésentateurCompteUtilisateur( this )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnModifierInfo = view.findViewById(R.id.btnModifierInfo)
        btnModifierPhoto = view.findViewById(R.id.btnModifierPhoto)
        btnParametre = view.findViewById(R.id.btnParametre)

        btnModifierInfo.setOnClickListener {
            Log.d("Test", "Rediretion vers Modification.")
            naviguerVersModifier()
        }
    }


    override fun naviguerVersModifier() {
        navController.navigate(R.id.action_vueCompteUtilisateur_to_vueModifier)
    }


}