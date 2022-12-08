package com.dti.defilecture.présentation
import com.dti.defilecture.accèsAuxDonnées.ISourceDeDonnées
import com.dti.defilecture.accèsAuxDonnées.SourceDeDonnéesBidon
import com.dti.defilecture.domaine.entité.Compte
import com.dti.defilecture.domaine.entité.Lecture
import com.dti.defilecture.domaine.entité.Questionnaire
import com.dti.defilecture.domaine.entité.Équipage
import com.dti.defilecture.domaine.intéracteur.*
import java.text.SimpleDateFormat
import java.util.*


class Modèle(var sourceDeDonnées : ISourceDeDonnées = SourceDeDonnéesBidon()) {

    private var lecture = Lecture("","",0,false)
    private var compteConnecté = Compte()
    private var compteTemporaire = Compte()
    private var équipage = Équipage()
    var localHelper: LocaleHelper?=null

    /**
     * Retourne le compte actif
     */
    fun compteActif(): Compte{
        return compteConnecté
    }

    fun compteTemporaire(): Compte{
        return compteTemporaire
    }

    fun équipage(): Équipage {
        return équipage
    }

    /**
     * Ajoute une lecture dans la source de données.
     */
    fun ajouterLectureDansSourceDeDonnée(){
        val aujourdhui = Calendar.getInstance().time
        val adapteur = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        lecture.dateInscription = adapteur.format(aujourdhui)

        InteractionSourceDeDonnées( sourceDeDonnées ).ajouterUneLecture( lecture )
    }

    /**
     * Récupère la liste des lectures de l'utilisateur avec l'intéracteur.
     *
     * @return une liste de lecture.
     */
    fun obtenirListeLecturesDeLUtilisateur(): MutableList<Lecture>?  {
        return InteractionSourceDeDonnées( sourceDeDonnées ).obtenirListeDeLectures()
    }

    /**
     * Initialise un modèle de lecture à l'état vide.
     */
    fun initialiserLecture(){
        lecture = InteractionSourceDeDonnées( sourceDeDonnées ).initialiserUneLecture()
    }

    /**
     * Ajoute un titre a la lecture
     */
    fun ajouterTitreAUneLecture( titre: String ){
        lecture.titreLecture = titre
    }

    /**
     * Ajoute un temps de lecture a la lecture
     */
    fun ajouterTempsAUneLecture( durée: Int ){
        lecture.duréeMinutes = durée
    }
    /**
     * Ajoute une obligation  la lecture
     */
    fun ajouterObligationAUneLecture( obligation: Boolean ){
        lecture.obligatoire = obligation
    }

    /**
     * Renvoie vrai si la lecture est manquante.
     */
    fun verifierLectureTitreManquant(): Boolean{
        return lecture.titreLecture.isEmpty()
    }

    /**
     * Renvoie vrai si la lecture n'a aucune minutes d'entrée.
     */
    fun verifierLectureDureeManquante(): Boolean{
        return lecture.duréeMinutes == 0
    }

    /**
     * Obtient une liste de question depuis la source de données.
     *
     * @return une liste de questions.
     */
    fun obtenirListeQuestion(): Array<Questionnaire>{
        return InteractionSourceDeDonnées( sourceDeDonnées ).obtenirQuestions()
    }

    /**
     * Établis la connexion et initialise le compte connecté selon le compte retourné depuis la source
     * lorsque les bons identifiants ont été entré.
     *
     * @return Vrai si la connexion est établie.
     */
    fun connexion( pseudo: String, mdp: String ): Boolean{
        var connexion = false
        val unCompte: Compte? = InteractionSourceDeDonnées( sourceDeDonnées ).récupérerComptePourConnexion( pseudo, mdp )
        if( unCompte != null ){
            compteConnecté = unCompte
            connexion = true
        }
        return connexion
    }

    fun créationCompteDansSourceDeDonnée( compte : Compte ){
        //À Faire
    }

    /**
     * Obtient une liste des comptes provenant d'un équipage.
     *
     * @return une liste de comptes.
     */
    fun obtenirListeDesComptesÉquipage(nomÉquipage: String): MutableList<Compte>? {
        return InteractionSourceDeDonnées( sourceDeDonnées ).obtenirListeDeComptes(nomÉquipage)
    }

    /**
     * Obtient la liste des Équipages qu'on trouve entre autre dans la trésorerie.
     *
     * @return une liste d'équipage.
     */
    fun obtenirListeDesÉquipages(): MutableList<Équipage>?{
        return InteractionSourceDeDonnées( sourceDeDonnées ).obtenirListeDesÉquipages()
    }

    /**
     * Obtient une liste des comptes provenant d'un équipage temporaire.
     *
     * @return une liste de comptes.
     */
    fun obtenirListeDesComptesÉquipageTemporaire(nomÉquipage : String): MutableList<Compte>? {
        return InteractionSourceDeDonnées( sourceDeDonnées ).obtenirListeDeComptes(nomÉquipage)
    }

    fun initialiserÉquipage(nomÉquipage: String) {

        val liste = InteractionSourceDeDonnées(sourceDeDonnées).obtenirListeDesÉquipages()
            ?.filter { it.nomÉquipage == nomÉquipage }

        if ( !liste.isNullOrEmpty() ) {
            équipage = liste[0]
        } else {
            Équipage()
        }
    }

    fun initialiserCompte(pseudonyme: String, nomÉquipage: String) {
        val liste = InteractionSourceDeDonnées(sourceDeDonnées).obtenirListeDeComptes(nomÉquipage)
            ?.filter { it.pseudonyme == pseudonyme }

        if ( !liste.isNullOrEmpty() ) {
            compteTemporaire = liste[0]
        } else {
            Compte()
        }
    }
}
val modèle = Modèle()


