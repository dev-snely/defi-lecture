package com.dti.defilecture.présentation.compteTemporaire

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.présentation.compteUtilisateur.IContratVPCompteTemporaire
import com.dti.defilecture.présentation.modèle

@Suppress("DEPRECATION")
class VueCompteTemporaire : Fragment(), IContratVPCompteTemporaire.IVueCompteTemporaire{

    lateinit var présentateur: IContratVPCompteTemporaire.IPrésentateurCompteTemporaire
    lateinit var navController : NavController

    lateinit var imgBtnPhotoCompteTemporaire: ImageButton
    lateinit var tvPseudonymeTemporaire: TextView
    lateinit var tvPrénomTemporaire: TextView
    lateinit var tvNomTemporaire: TextView
    lateinit var tvDoublonCompteTemporaire: TextView
    lateinit var tvCourrielTemporaire: TextView
    lateinit var tvProgrammeTemporaire: TextView

    val compteActif = modèle.compteActif()
    val compteTemporaire = modèle.compteTemporaire()
    val DEMANDE_PRISE_PHOTO = 100

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_compte_temporaire, container, false)
        présentateur = PrésentateurCompteTemporaire( this)

        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        imgBtnPhotoCompteTemporaire = view.findViewById(R.id.imgBtnPhotoCompteTemporaire)
        tvPseudonymeTemporaire = view.findViewById(R.id.tvPseudonymeCompteTemporaire)
        tvPrénomTemporaire = view.findViewById(R.id.tvPrénomCompteTemporaire)
        tvNomTemporaire = view.findViewById(R.id.tvNomCompteTemporaire)
        tvDoublonCompteTemporaire = view.findViewById(R.id.tv_doublonCompteTemporaire)
        tvCourrielTemporaire = view.findViewById(R.id.tvCourrielCompteTemporaire)
        tvProgrammeTemporaire = view.findViewById(R.id.tvProgrammeCompteTemporaire)

        présentateur.initialiserCompteTemporaire()

        tvPseudonymeTemporaire.text = compteTemporaire.pseudonyme
        tvPrénomTemporaire.text = compteTemporaire.prénom
        tvNomTemporaire.text = compteTemporaire.nom
        tvDoublonCompteTemporaire.text = compteTemporaire.doublons.toString()
        tvCourrielTemporaire.text = compteTemporaire.courriel
        tvProgrammeTemporaire.text = compteTemporaire.programme
        if(compteTemporaire.avatar!=null){
            imgBtnPhotoCompteTemporaire.setImageBitmap(compteTemporaire.avatar)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DEMANDE_PRISE_PHOTO && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            compteActif.avatar = imageBitmap
            imgBtnPhotoCompteTemporaire.setImageBitmap(imageBitmap)
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun naviguerVersDétailsCompte(pseudonyme: String) {
        navController.navigate(R.id.action_vueÉquipageTemporaire_to_vueCompteTemporaire)
    }
}