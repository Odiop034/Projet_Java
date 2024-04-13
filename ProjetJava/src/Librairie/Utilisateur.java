package Librairie;

import java.util.ArrayList;

class Utilisateur {
    //attributs
    private String nom;
    private int numeroIdentification;
    private ArrayList<Livre> livresEmpruntes;
    private boolean aPayerFrais;

    //constructeurs pour initialiser les attributs
    public Utilisateur(String nom, int numeroIdentification, ArrayList<Livre> livresEmpruntes, boolean aPayerFrais){
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = livresEmpruntes;
        this.aPayerFrais = aPayerFrais;
    }

    //getters et setters
    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public int getnumeroIdentification(){
        return numeroIdentification;
    }

    public void setnumeroIdentification(int  numeroIdentification){
        this.numeroIdentification = numeroIdentification;
    }

    public ArrayList<Livre> getlivresEmpruntes(){
        return livresEmpruntes;
    }

    public void setlivresEmpruntes(ArrayList<Livre> livreEmpruntes){
        this.livresEmpruntes = livreEmpruntes;
    }

    //Methode pour emprunter livre
    public void emprunterLivre(Livre livre){
        livresEmpruntes.add(livre);
    }

    //Methode pour retourner un livre 
    public void retournerLivre(Livre livre){
        livresEmpruntes.remove(livre);
    }

    //Methode pour l'affichage des livres empruntes
    public void afficherLivresEmpruntes() {
        for (Livre livre : livresEmpruntes) {
            System.out.println(livre);
        }
    }

    //Verification eligibilite
    public boolean aPayeFrais() {
        return !aPayerFrais; // Si aPayerFrais est vrai, l'utilisateur n'a pas payé ses frais, donc on retourne false
    }

}


