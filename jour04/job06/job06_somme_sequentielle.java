package jour04.job06;

import java.util.Scanner;

public class job06_somme_sequentielle {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Demander à l'utilisateur de saisir la taille du tableau
        System.out.print("Entrez la taille du tableau: ");
        int taille = scanner.nextInt();
        
        // Créer le tableau de nombres
        int[] tableau = new int[taille];
        
        // Remplir le tableau avec les valeurs saisies par l'utilisateur
        System.out.println("Entrez " + taille + " nombres:");
        for (int i = 0; i < taille; i++) {
            System.out.print("Nombre " + (i+1) + ": ");
            tableau[i] = scanner.nextInt();
        }
        
        // Début du chronomètre
        long startTime = System.currentTimeMillis();
        
        // Calculer la somme des éléments du tableau séquentiellement
        int somme = 0;
        for (int i = 0; i < taille; i++) {
            somme += tableau[i];
        }
        
        // Fin du chronomètre
        long endTime = System.currentTimeMillis();
        
        // Calculer et afficher le temps d'exécution
        long executionTime = endTime - startTime;
        
        System.out.println("Somme totale: " + somme);
        System.out.println("Temps d'exécution: " + executionTime + " millisecondes");
        
        scanner.close();
    }
}
