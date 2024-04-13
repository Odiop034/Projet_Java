package Librairie;

class Livre{
    //Attributs
    private String titre;
    private String auteur;
    private int anneePublication;
    private String ISBN;

    //Constructeurs pour initialiser les attributs
    public Livre(String titre, String auteur, int anneePublication, String ISBN){
        this.titre = titre;
        this.auteur = auteur ;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
    }


    //Getters et setters
    public String getTitre(){
        return titre;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public String getAuteur(){
        return auteur;
    }

    public void setAuteur(String auteur){
        this.auteur= auteur;
    }

    public int getAnneePublication(){
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication){
        this.anneePublication = anneePublication;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    
    public String toString() {
        return String.format("Livre [ titre = %s, auteur = %s, année de publication = %d, ISBN = %s ]", 
                             titre, auteur, anneePublication, ISBN);
    }
    

}
