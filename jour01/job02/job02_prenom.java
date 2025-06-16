package jour01.job02;

import java.util.Scanner;

public class job02_prenom {
    
    public static void main(String[] args) {
        // Créer un objet Scanner pour lire les entrées clavier
        Scanner scanner = new Scanner(System.in);
        
        // Demander à l'utilisateur d'entrer son prénom
        System.out.println("Entrez votre prénom:");
        
        // Récupérer le prénom saisi
        String prenom = scanner.nextLine();
        
        // Afficher le message de salutation
        System.out.println("bonjour " + prenom);
        
        // Fermer le scanner pour éviter les fuites de ressources
        scanner.close();
    }
}
