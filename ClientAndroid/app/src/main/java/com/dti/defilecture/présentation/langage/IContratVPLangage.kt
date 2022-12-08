package com.dti.defilecture.présentation.langage

interface IContratVPLangage {
    interface IVueLangage{
        /**
         * Fonction pour changer la couleur du bouton en vert
         */
        fun boutonActifFrançais()
        /**
         * Fonction pour changer la couleur du bouton en vert
         */
        fun boutonActifEnglish()
    }

    interface IPrésentateurLangage{
        /**
         * Fonction pour changer la langue en français
         */
        fun changerLangueFrançais()
        /**
         * Fonction pour changer la langue en anglais
         */
        fun changerLangueEnglish()
    }
}
