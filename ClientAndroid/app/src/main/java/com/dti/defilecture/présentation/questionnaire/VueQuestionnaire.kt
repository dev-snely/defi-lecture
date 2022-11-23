package com.dti.defilecture.présentation.questionnaire

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.dti.defilecture.R
import com.dti.defilecture.présentation.questionnaire.IContratVPQuestionnaire.IVueQuestionnaire
import com.dti.defilecture.présentation.questionnaire.IContratVPQuestionnaire.IPrésentateurQuestionnaire

class VueQuestionnaire : Fragment(), IVueQuestionnaire {
    private lateinit var Question: TextView
    private lateinit var ReponseA: Button
    private lateinit var ReponseB: Button
    private lateinit var ReponseC: Button
    private lateinit var ReponseD: Button
    private lateinit var Soummettre: Button

    private lateinit var présentateur: IPrésentateurQuestionnaire

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_questionnaire, container, false)
        présentateur = PrésentateurQuestionnaire( this )
        return vue
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Question=view.findViewById(R.id.question)
        ReponseA=view.findViewById(R.id.rb_option_a)
        ReponseB=view.findViewById(R.id.rb_option_b)
        ReponseC=view.findViewById(R.id.rb_option_c)
        ReponseD=view.findViewById(R.id.rb_option_d)
        Soummettre=view.findViewById(R.id.envoyer)

        ReponseA.setOnClickListener{

        }
        ReponseB.setOnClickListener {

        }
        ReponseC.setOnClickListener {

        }
        ReponseD.setOnClickListener{

        }
        Soummettre.setOnClickListener {

        }
    }

}

