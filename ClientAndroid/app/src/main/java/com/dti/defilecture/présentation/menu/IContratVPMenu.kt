package com.dti.defilecture.présentation.menu

interface IContratVPMenu{
    interface IVueMenu{
        fun naviguerVersPageLangage()
        fun naviguerVersPageGlossaire()
        fun naviguerVersPageAPropos()
        fun deconnexion()
    }

    interface IPrésentateurMenu{
        fun naviguerVersPageLangage()
        fun naviguerVersPageGlossaire()
        fun naviguerVersPageAPropos()
        fun deconnexion()
    }
}