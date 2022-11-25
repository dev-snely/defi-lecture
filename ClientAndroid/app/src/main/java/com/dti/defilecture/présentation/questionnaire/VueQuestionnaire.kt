package com.dti.defilecture.présentation.questionnaire

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.dti.defilecture.R
import com.dti.defilecture.accesAuxDonnees.SourceQuestion
import com.dti.defilecture.présentation.questionnaire.IContratVPQuestionnaire.IVueQuestionnaire
import com.dti.defilecture.présentation.questionnaire.IContratVPQuestionnaire.IPrésentateurQuestionnaire

class VueQuestionnaire : Fragment(), IVueQuestionnaire {
    private lateinit var question: TextView
    private lateinit var reponseA: RadioButton
    private lateinit var reponseB: RadioButton
    private lateinit var reponseC: RadioButton
    private lateinit var reponseD: RadioButton
    private lateinit var soummettre: Button
    private lateinit var rg_questionnaire: RadioGroup

    private lateinit var présentateur: IPrésentateurQuestionnaire

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vue = inflater.inflate(R.layout.fragment_questionnaire, container, false)
        présentateur = PrésentateurQuestionnaire(this)
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        question = view.findViewById(R.id.question)
        reponseA = view.findViewById(R.id.rb_option_a)
        reponseB = view.findViewById(R.id.rb_option_b)
        reponseC = view.findViewById(R.id.rb_option_c)
        reponseD = view.findViewById(R.id.rb_option_d)
        rg_questionnaire = view.findViewById(R.id.rg_questionnaire)

        question.text = présentateur.getQuestion()
        reponseA.text = présentateur.getReponseA()
        reponseB.text = présentateur.getReponseB()
        reponseC.text = présentateur.getReponseC()
        reponseD.text = présentateur.getReponseD()

        soummettre = view.findViewById(R.id.envoyer)
        var choix = ""
        rg_questionnaire.setOnCheckedChangeListener { radioGroup, i ->
            var rb = view.findViewById<RadioButton>(i)
            choix = rb?.text?.toString().toString()

        }
        soummettre.setOnClickListener {
            présentateur.bonneReponse(choix)
        }
    }

    override fun afficherBonneReponse() {
        Toast.makeText(context, "Bonne réponse!!!", Toast.LENGTH_SHORT).show()
    }

    override fun afficherMauvaiseReponse() {
        Toast.makeText(context, "Mauvaise réponse!!!", Toast.LENGTH_SHORT).show()
    }

}

