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
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dti.defilecture.R
import com.dti.defilecture.domaine.entité.Équipage
import com.dti.defilecture.présentation.modèle

@Suppress("DEPRECATION")
class VueCompteUtilisateur : Fragment(), IContratVPCompte.IVueCompteUtilisateur{

    lateinit var présentateur: IContratVPCompte.IPrésentateurCompteUtilisateur
    lateinit var navController : NavController
    lateinit var btnModifierInfo : ImageButton
    lateinit var btnModifierPhoto : ImageButton
    lateinit var btnParametre: ImageButton
    lateinit var imgBtnPhotoCompte: ImageButton
    lateinit var tvPseudonyme: TextView
    lateinit var tvPrénom: TextView
    lateinit var tvNom: TextView
    lateinit var tvCourriel: TextView
    lateinit var tvProgramme: TextView
    val compteActif = modèle.compteActif()
    val DEMANDE_PRISE_PHOTO = 100

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_compte_utilisateur, container, false)
        présentateur = PrésentateurCompteUtilisateur( modèle,this)

        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnModifierInfo = view.findViewById(R.id.btnModifierInfo)
        btnModifierPhoto = view.findViewById(R.id.btnModifierPhoto)
        btnParametre = view.findViewById(R.id.btnParametre)
        imgBtnPhotoCompte = view.findViewById(R.id.imgBtnPhotoCompte)
        tvPseudonyme = view.findViewById(R.id.tvPseudonymeCompte)
        tvPrénom = view.findViewById(R.id.tvPrénomCompte)
        tvNom = view.findViewById(R.id.tvNomCompte)
        tvCourriel = view.findViewById(R.id.tvCourrielCompte)
        tvProgramme = view.findViewById(R.id.tvProgrammeCompte)

        présentateur.requêteInitialiserCompte()


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

    override fun initCompte(pseudonyme:String, nom: String, prénom: String,
                            courriel: String, programme: String, avatar: Bitmap?, nomÉquipage: String) {
        tvPseudonyme.text = pseudonyme
        tvPrénom.text = getString(R.string.PrenomCompteUtilisateur,prénom)
        tvNom.text = getString(R.string.NomCompteUtilisateur,nom)
        tvCourriel.text = getString(R.string.CourrielCompteUtilisateur,courriel)
        tvProgramme.text = getString(R.string.ProgrammeCompteUtilisateur,programme)
        if(avatar!=null){
            imgBtnPhotoCompte.setImageBitmap(avatar)
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
            compteActif.avatar = imageBitmap
            imgBtnPhotoCompte.setImageBitmap(imageBitmap)
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }

    }


}