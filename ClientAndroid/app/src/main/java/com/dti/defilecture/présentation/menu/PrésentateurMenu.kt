package com.dti.defilecture.présentation.menu

import com.dti.defilecture.présentation.menu.IContratVPMenu.IPrésentateurMenu
import com.dti.defilecture.présentation.menu.IContratVPMenu.IVueMenu


class PrésentateurMenu(var vue: IVueMenu) : IPrésentateurMenu {
    override fun naviguerVersPageLangage(){
        vue.naviguerVersPageLangage()
    }

    override fun naviguerVersPageGlossaire(){
        vue.naviguerVersPageGlossaire()
    }

    override fun naviguerVersPageAPropos(){
        vue.naviguerVersPageAPropos()
    }

    override fun deconnexion(){
        vue.deconnexion()
    }

}