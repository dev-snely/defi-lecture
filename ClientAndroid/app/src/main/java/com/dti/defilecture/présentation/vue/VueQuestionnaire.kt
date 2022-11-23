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
import com.dti.defilecture.présentation.présentateur.PrésentateurQuestionnaire

class VueQuestionnaire : Fragment(), View.OnClickListener {
    private lateinit var Question: TextView
    private lateinit var ReponseA: Button
    private lateinit var ReponseB: Button
    private lateinit var ReponseC: Button
    private lateinit var ReponseD: Button
    private lateinit var Soummettre: Button

    private lateinit var présentateur: PrésentateurQuestionnaire

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_questionnaire, container, false)
        présentateur = PrésentateurQuestionnaire(Modèle,this)
        return vue
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Question=view.findViewById(R.id.question)
        ReponseA=view.findViewById(R.id.rep_A)
        ReponseB=view.findViewById(R.id.rep_B)
        ReponseC=view.findViewById(R.id.rep_C)
        ReponseD=view.findViewById(R.id.rep_D)
        Soummettre=view.findViewById(R.id.envoyer)

        ReponseA.setOnClickListener(this)
        ReponseB.setOnClickListener(this)
        ReponseC.setOnClickListener(this)
        ReponseD.setOnClickListener(this)
        Soummettre.setOnClickListener(this)

        }

    }

