package jour04.job07;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class job07_somme_parallele {
    
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
        
        // Diviser le tableau en deux moitiés
        int milieu = taille / 2;
        
        // Variables pour stocker les sommes partielles
        AtomicInteger sommePartie1 = new AtomicInteger(0);
        AtomicInteger sommePartie2 = new AtomicInteger(0);
        
        // Créer les deux threads
        Thread thread1 = new Thread(() -> {
            // Premier thread calcule la somme de la première moitié
            int sommeLocale = 0;
            for (int i = 0; i < milieu; i++) {
                sommeLocale += tableau[i];
            }
            sommePartie1.set(sommeLocale);
            System.out.println("Thread 1: Somme calculée = " + sommePartie1.get());
        });
        
        Thread thread2 = new Thread(() -> {
            // Second thread calcule la somme de la seconde moitié
            int sommeLocale = 0;
            for (int i = milieu; i < taille; i++) {
                sommeLocale += tableau[i];
            }
            sommePartie2.set(sommeLocale);
            System.out.println("Thread 2: Somme calculée = " + sommePartie2.get());
        });
        
        // Début du chronomètre
        long startTime = System.currentTimeMillis();
        
        // Démarrer les deux threads
        thread1.start();
        thread2.start();
        
        try {
            // Attendre que les deux threads terminent
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrompu: " + e.getMessage());
        }
        
        // Combiner les résultats
        int sommeTotal = sommePartie1.get() + sommePartie2.get();
        
        // Fin du chronomètre
        long endTime = System.currentTimeMillis();
        
        // Calculer et afficher le temps d'exécution
        long executionTime = endTime - startTime;
        
        System.out.println("Somme partielle 1: " + sommePartie1.get());
        System.out.println("Somme partielle 2: " + sommePartie2.get());
        System.out.println("Somme totale: " + sommeTotal);
        System.out.println("Temps d'exécution: " + executionTime + " millisecondes");
        
        // Vérification du résultat
        int sommeVerification = 0;
        for (int valeur : tableau) {
            sommeVerification += valeur;
        }
        System.out.println("Vérification de la somme (méthode séquentielle): " + sommeVerification);
        System.out.println("Les résultats sont " + (sommeTotal == sommeVerification ? "identiques" : "différents"));
        
        scanner.close();
    }
}
