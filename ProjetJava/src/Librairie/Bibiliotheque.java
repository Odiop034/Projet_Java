package Librairie;

import java.util.ArrayList;
import java.util.HashMap;

class Bibliotheque {
    //attributs
    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur,ArrayList<Livre>> empruntsUtilisateurs;
    

    //Constructeur
    public Bibliotheque() {
        listeLivres = new ArrayList<>();
        empruntsUtilisateurs = new HashMap<>();
    }

    //methode ajouter un livre
    public void ajouterLivre(Livre livre){
        listeLivres.add(livre);
    }

    //methode supprimer un livre
    public void supprimerLivre(Livre livre){
        listeLivres.remove(livre);
    }

    // Méthode pour rechercher un livre par titre, auteur ou ISBN
    public Livre rechercherLivre(String recherche) {
        for (Livre livre : listeLivres) {
            if (livre.getTitre().equalsIgnoreCase(recherche) ||
                livre.getAuteur().equalsIgnoreCase(recherche) ||
                livre.getISBN().equalsIgnoreCase(recherche)) {
                return livre;
            }
        }
        return null; // Livre non trouvé
    }
    
    //Méthode pour ajouter un utilisateur
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return false;
        }

        if (empruntsUtilisateurs.containsKey(utilisateur)) {
            System.out.println("L'utilisateur " + utilisateur.getNom() + " existe déjà.");
            return false;
        }

        // Ajouter l'utilisateur à la map
        empruntsUtilisateurs.put(utilisateur, utilisateur.getlivresEmpruntes());
        System.out.println("L'utilisateur " + utilisateur.getNom() + " a été ajouté avec succès.");
        return true;
    }

    
    // Méthode pour rechercher un utilisateur
    public Utilisateur rechercherUtilisateur(String nomUtilisateur) {
        for (Utilisateur utilisateur : empruntsUtilisateurs.keySet()) {
            if (utilisateur.getNom().equals(nomUtilisateur) ||
            	Integer.toString(utilisateur.getnumeroIdentification()).equals(nomUtilisateur)){
            	
                return utilisateur;
            }
        }
        return null;
    }
    
    //Méthode pour afficher les livres empruntés par un utilisateur
    public void afficherLivresEmpruntesParUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null) {
            System.out.println("Utilisateur invalide.");
            return;
        }

        ArrayList<Livre> livresEmpruntes = empruntsUtilisateurs.get(utilisateur);
        if (livresEmpruntes == null || livresEmpruntes.isEmpty()) {
            System.out.println("L'utilisateur " + utilisateur.getNom() + " n'a pas emprunté de livres.");
            return;
        }

        System.out.println("\nLivres empruntés par " + utilisateur.getNom() + " :");
        System.out.println("---------------------------------");

        for (Livre livre : livresEmpruntes) {
            System.out.println("- " + livre.getTitre() + " (" + livre.getAuteur() + ")");
        }
    }

    
    // Méthode pour enregistrer l'emprunt d'un livre par un utilisateur
    public void emprunterLivre(Utilisateur utilisateur, Livre livre) {
        ArrayList<Livre> emprunts = empruntsUtilisateurs.getOrDefault(utilisateur, new ArrayList<>());
        emprunts.add(livre);
        empruntsUtilisateurs.put(utilisateur, emprunts);
        System.out.println("L'utilisateur " + utilisateur.getNom() + " a emprunté avec succès le livre " +livre.getTitre());
    }

    // Méthode pour enregistrer le retour d'un livre par un utilisateur
    public void retournerLivre(Utilisateur utilisateur, Livre livre) {
        ArrayList<Livre> emprunts = empruntsUtilisateurs.get(utilisateur);
        if (emprunts != null) {
            emprunts.remove(livre);
            System.out.println("L'utilisateur " + utilisateur.getNom() + " a retourner avec succès le livre " +livre.getTitre());
        }
    }

    
    // Méthode pour vérifier l'éligibilité d'un utilisateur à emprunter un livre
   public boolean verifierEligibilite(Utilisateur utilisateur) {
    // Vérifier si l'utilisateur a payé ses frais
        if (!utilisateur.aPayeFrais()) {
            return false; // L'utilisateur n'est pas éligible s'il n'a pas payé ses frais
        }

        ArrayList<Livre> emprunts = empruntsUtilisateurs.getOrDefault(utilisateur, new ArrayList<>());
        return emprunts.size() < 3;
    }
   
   public void afficherListeLivres() {
	    if (listeLivres.isEmpty()) {
	        System.out.println("Aucun livre disponible.");
	        return;
	    }

	    System.out.println("\nListe des livres:");
	    System.out.println("------------------");

	    for (Livre livre : listeLivres) {
	        System.out.println("- " + livre.getTitre() + " (" + livre.getAuteur() + ")");
	        
	    }
	}


        
    
}

