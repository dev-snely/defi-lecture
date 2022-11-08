package com.dti.defilecture.présentation.vue



import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.présentation.contrat.ContratVuePrésentateurÉquipage
import com.dti.defilecture.présentation.modèle.Modèle



class VueÉquipage : Fragment(), ContratVuePrésentateurÉquipage.IVueÉquipage  {
    lateinit var présentateur : ContratVuePrésentateurÉquipage.IPrésentateurÉquipage
    lateinit var nomÉquipage: TextView
    lateinit var numéroRang: TextView
    lateinit var totalDoublons: TextView
    lateinit var listePersonnesÉquipage: RecyclerView

}