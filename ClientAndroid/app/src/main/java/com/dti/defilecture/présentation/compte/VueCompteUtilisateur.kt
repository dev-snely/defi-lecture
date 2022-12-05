package com.dti.defilecture.présentation.compte

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.drawable.toIcon
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
    lateinit var imgBtnPhotoCompte: ImageButton
    val DEMANDE_PRISE_PHOTO = 100

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
        imgBtnPhotoCompte = view.findViewById(R.id.imgBtnPhotoCompte)

        btnModifierPhoto.setOnClickListener {
            var photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(photoIntent,DEMANDE_PRISE_PHOTO)
            }catch (message: ActivityNotFoundException){
                Log.d("Erreur", message.toString())
            }
        }
        btnModifierInfo.setOnClickListener {
            naviguerVersModifier()
        }
        btnParametre.setOnClickListener {
            naviguerVersMenu()
        }
    }


    override fun naviguerVersModifier() {
        navController.navigate(R.id.action_vueCompteUtilisateur_to_vueModifier)
    }

    override fun naviguerVersMenu() {
        navController.navigate(R.id.action_vueCompteUtilisateur_to_vueMenu)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DEMANDE_PRISE_PHOTO && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imgBtnPhotoCompte.setImageBitmap(imageBitmap)
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }

    }


}