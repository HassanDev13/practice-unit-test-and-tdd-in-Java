package com.tp.tp5;

import java.util.List;

import com.tp.tp5.exception.ErreurPersistance;
import com.tp.tp5.exception.TooMuchResultException;

public class ProgrammeVoiture{ 
    // Objet persistance qui sera lié par le principe d'injection de dépendances 
    private IPersistanceModeleVoiture persistance; 
  
    /** Méthodes à tester */ 
  
    /** 
     * Rechercher une liste de modèles en fonction de la marque 
     * @param String marque 
     * @return List<ModeleVoiture> tous les modèles en base appartenant à cette marque 
     */ 
    public List<ModeleVoiture> rechercherVoitureParMarque(String marque){ 
        CritereRerchercheModeleVoiture citere = new CritereRerchercheModeleVoiture(); 
        citere.setMarqueModele(marque); 
        return persistance.searchModeleVoiture(citere); 
    } 
  
    /** 
     * Rechercher un modèle de voiture via son id en base 
     * @param Long id 
     * @return ModeleVoiture résultat correspondant à la recherche 
     */ 
    public ModeleVoiture rechercherVoitureParId(Long id){ 
        try { 
            return persistance.searchModeleVoitureById(id); 
        } catch (TooMuchResultException e){ 
            System.out.println("Trop de résultats avec le même id, revoyez la structure de votre table !"); 
            return null; 
        } 
    } 
  
    /** 
     * Enregistrer un modèle valorisé à partir d'un formulaire de création/modification 
     * Doit mettre à jour en base le modèle ou l'ajouter dans le cas ou il n'existe pas 
     * @param ModeleVoiture modele 
     */ 
    public boolean enregisterModeleVoiture(ModeleVoiture modele){ 
        try{ 
            if (null != modele.getId()){ 
                persistance.updateModeleVoiture(modele); 
            } else { 
                persistance.addModeleVoiture(modele); 
            } 
            return true;
        } catch (ErreurPersistance e){ 
            System.out.println ("Erreur : " + e.getMessage()); 
            return false;
        } 
    } 
  
    /** Getters et setters */ 
    public IPersistanceModeleVoiture getPersistance() { 
        return persistance; 
    } 
  
    public void setPersistance(IPersistanceModeleVoiture persistance) { 
        this.persistance = persistance; 
    } 
}