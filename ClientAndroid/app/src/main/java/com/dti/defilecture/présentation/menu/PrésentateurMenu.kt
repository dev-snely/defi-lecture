package com.dti.defilecture.présentation.menu

import com.dti.defilecture.présentation.menu.IContratVPMenu.IPrésentateurMenu
import com.dti.defilecture.présentation.menu.IContratVPMenu.IVueMenu


class PrésentateurMenu(var vue: IVueMenu) : IPrésentateurMenu {

    override fun requêteNaviguerVersPageLangage(){
        vue.naviguerVersPageLangage()
    }

    override fun requêteNaviguerVersPageGlossaire(){
        vue.naviguerVersPageGlossaire()
    }

    override fun requêteNaviguerVersPageAPropos(){
        vue.naviguerVersPageAPropos()
    }

    override fun requêteDeconnexion(){
        vue.deconnexion()
    }

}