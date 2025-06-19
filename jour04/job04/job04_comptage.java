package jour04.job04;

import java.util.Scanner;

public class job04_comptage {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Demander à l'utilisateur de saisir le nombre maximum à compter
        System.out.print("Entrez le nombre maximum à compter: ");
        long nombreMax = scanner.nextLong(); // Change int to long
        
        System.out.println("Comptage de 1 à " + nombreMax + "...");
        
        // Début du chronomètre
        long startTime = System.currentTimeMillis();
        
        // Comptage séquentiel
        long compteur = 0;
        for (long i = 1; i <= nombreMax; i++) { // Change int to long
            compteur = i;
        }
        
        // Fin du chronomètre
        long endTime = System.currentTimeMillis();
        
        // Calculer et afficher le temps d'exécution
        long executionTime = endTime - startTime;
        
        System.out.println("Compte final: " + compteur);
        System.out.println("Temps d'exécution: " + executionTime + " millisecondes");
        
        scanner.close();
    }
}
