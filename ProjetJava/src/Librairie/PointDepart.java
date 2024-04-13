package Librairie;
import java.util.ArrayList;
import java.util.Scanner;
public class PointDepart {
	
	private static void afficherMenu1() {
	    System.out.println("\nMenu:");
	    System.out.println("1. Gestion des livres");
	    System.out.println("2. Gestions Emprunts");
	    System.out.println("3. Gestions Utilisateurs");
	    System.out.println("0. Quitter");
	    System.out.print("Saisissez votre option: ");
	}
	
	private static void GestionLivres() {
	    System.out.println("\n Gestions des Livres:");
	    System.out.println("1. Afficher la liste des livres");
	    System.out.println("2. Ajouter un nouveau livre");
	    System.out.println("3. Rechercher un livre");
	    System.out.println("4. Supprimer un livre");
	    System.out.println("0. Retourner au menu principal");
	    System.out.print("Saisissez votre option: ");
	}
	
	private static void GestionEmprunts() {
	    System.out.println("\n Gestions Emprunts:");
	    System.out.println("1. Enregistrer les emprunts");
	    System.out.println("2. Retours de livres");
	    System.out.println("3. Afficher les livres empruntés par un utilisateur donné");
	    System.out.println("4. Limiter le nombre de livres qu'un utilisateur peut emprunter simultanément");
	    System.out.println("0. REtourner au menu principal");
	    System.out.print("Saisissez votre option: ");
	}
	
	private static void GestionUtilisateurs() {
	    System.out.println("\n Gestions Utilisateurs:");
	    System.out.println("1. Ajouter un utilisateur");
	    System.out.println("2. Verifier l'éligibilité d'un utilisateur");
	    System.out.println("0. REtourner au menu principal");
	    System.out.print("Saisissez votre option: ");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bibliotheque bibliotheque = new Bibliotheque();
		Scanner scanner = new Scanner(System.in);

        while (true) {
            afficherMenu1();
            String commande = scanner.nextLine();

            switch (commande) {
                case "1":
                	GestionLivres();
                	String option1 = scanner.nextLine();
                	
                	
                	switch (option1) {
                		case "1":
                			bibliotheque.afficherListeLivres();
                			break;
            			
                		case "2":
                			 System.out.println("Donner le titre du livre");
                			String Titre = scanner.nextLine();
                			 System.out.println("Donner l'auteur du livre");
                        	String Auteur = scanner.nextLine();
                        	System.out.println("Donner l'année de publication du livre");
                        	int AnneePublication = Integer.parseInt(scanner.nextLine());
                        	System.out.println("Donner l'ISBN du livre");
                        	String ISBN = scanner.nextLine();
                            Livre livre = new Livre(Titre,Auteur,AnneePublication,ISBN);
                            bibliotheque.ajouterLivre(livre);
                            break;
                            
                		case "3" :
                			System.out.println("Donner le nom ou l'isbn du livre à rechercher");
                			String recherche = scanner.nextLine();
                            bibliotheque.rechercherLivre(recherche);
                            break;
                            
                		case "4" :
                			System.out.println("Donner le nom ou l'isbn du livre à supprimer");
                			String recherche1 = scanner.nextLine();
                            bibliotheque.supprimerLivre(bibliotheque.rechercherLivre(recherche1));
                            break;
                            
                		case "0" :
                			System.out.println("Au revoir!");
                            return;
                            
                        default :
                        	 System.out.println("Commande invalide.");	
                			
                	}
                    break;
                    
                case "2":
                	GestionEmprunts();
                	String option2 = scanner.nextLine();
                	switch (option2) {
            		case "1":
            			System.out.println("Donner le nom ou le numéro de l'emprunteur");
            			String recherche = scanner.nextLine();
            			 if (bibliotheque.rechercherUtilisateur(recherche)==null) {
            				 System.out.println("L'emprunteur n'existe pas");
            				break; 
            			 }
            			 if (bibliotheque.verifierEligibilite(bibliotheque.rechercherUtilisateur(recherche))) {
            				 System.out.println("L'utilisateur n'est pas éligible au programme d'emprunts ");
            				 break;
            			 }
            				 
            			 System.out.println("Donner le nom ou l'isbn su livre à emprunter");
            			 String livret = scanner.nextLine();
            			 if (bibliotheque.rechercherLivre(livret)==null) {
            				 System.out.println("Le livre emprunté n'exixte pas");
            				 break;
            			 }
            			 bibliotheque.emprunterLivre(bibliotheque.rechercherUtilisateur(recherche), bibliotheque.rechercherLivre(livret));
            			 break;
        			
            		case "2":
            			System.out.println("Donner le nom ou le numéro de l'emprunteur");
            			String recherche1 = scanner.nextLine();
            			 if (bibliotheque.rechercherUtilisateur(recherche1)==null) {
            				 System.out.println("L'emprunteur n'existe pas");
            				break; 
            			 }
            			 System.out.println("Donner le nom ou l'isbn du livre à emprunter");
            			 String livret1 = scanner.nextLine();
            			 if (bibliotheque.rechercherLivre(livret1)==null) {
            				 System.out.println("Le livre emprunté n'exixte pas");
            				 break;
            			 }
            			 
            			 bibliotheque.retournerLivre(bibliotheque.rechercherUtilisateur(recherche1), bibliotheque.rechercherLivre(livret1));
                        break;
                        
            		case "3" :
            			System.out.println("Donner le nom ou le numéro de l'emprunteur");
            			String recherche2 = scanner.nextLine();
                        bibliotheque.afficherLivresEmpruntesParUtilisateur(bibliotheque.rechercherUtilisateur(recherche2));
                        break;
                        
            		case "0" :
            			System.out.println("Au revoir!");
                        return;
                        
                    default :
                    	 System.out.println("Commande invalide.");	
                	}
                    break;
                case "3":
                	GestionUtilisateurs();
                	String option3 = scanner.nextLine();
                	switch(option3) {
                		case "1" :
                			System.out.println("Donner le nom de l'utilisateur.");
                        	String nom = scanner.nextLine();
                        	System.out.println("Donner l'identifiant de l'utilisateur.");
                        	int numero = scanner.nextInt();
                        	System.out.println("L'utilisateur a t-il payer les frais ?.");
                        	boolean frais = scanner.nextBoolean();
                        	ArrayList<Livre> livresEmpruntes = new ArrayList<Livre>() ;
                        	Utilisateur utilisateur = new Utilisateur(nom,numero,livresEmpruntes,frais);
                        	bibliotheque.ajouterUtilisateur(utilisateur);
                        	break;
                        	
                		case "2" :
                			System.out.println("Vous voudriez vérifier l'éliligibilité d'un utilisateur \n Dans ce cas donner son nom ou son numéro.");
                			String recherche3 = scanner.nextLine();
                			if (bibliotheque.verifierEligibilite(bibliotheque.rechercherUtilisateur(recherche3))) {
                				System.out.println("Vous etes éligible au programme d'emprunts.");
                			}
                			else 
                				System.out.println("Vous avez atteint le nombre d'emprunts maximals ou vous ne vous etes pas acquittés de vos frais d'adhèsion.");
                	}
               
                    break;     
                case "0":
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Commande invalide.");
            }
        }
    }

  

}
