package com.dti.defilecture.présentation.trésorerie

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dti.defilecture.R
import com.dti.defilecture.présentation.trésorerie.IContratVPTrésorerie.*

class VueTrésorerie : Fragment(), IVueTrésorerie {

    lateinit var navController : NavController
    lateinit var présentateur : IPrésentateurTrésorerie
    lateinit var adaptateur: VueTrésorerieAdaptateur


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vue = inflater.inflate(R.layout.fragment_tresorerie, container, false)
        présentateur = PrésentateurTrésorerie(this  )
        return vue
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_trésorerie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adaptateur = VueTrésorerieAdaptateur( présentateur.initisaliseurDesÉquipages(), présentateur )
        recyclerView.adapter = adaptateur
    }

    override fun naviguerVersDétailsÉquipage() {
        navController.navigate(R.id.action_vueTrésorerie_to_vueÉquipageTemporaire)
    }
}
