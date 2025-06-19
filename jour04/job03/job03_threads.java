package jour04.job03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class job03_threads {
    
    // CountDownLatch pour synchroniser les threads
    private static CountDownLatch latch;
    
    public static void main(String[] args) {
                
        Scanner scanner = new Scanner(System.in);
        
        // Demander la longueur de la chaîne à l'utilisateur
        System.out.print("Entrez la longueur de la chaîne de caractères à générer: ");
        int longueur = scanner.nextInt();

        // Début du chronomètre
        long startTime = System.currentTimeMillis();
        
        // Générer une chaîne de caractères aléatoire
        String chaineAleatoire = genererChaineAleatoire(longueur);
        
        // Diviser la chaîne en deux parties
        int milieu = longueur / 2;
        String premierePartie = chaineAleatoire.substring(0, milieu);
        String secondePartie = chaineAleatoire.substring(milieu);
        
        // Définir le chemin du fichier de sortie
        String cheminFichier = "jour04/job03/output.txt";
        
        // Initialiser le CountDownLatch à 2 (pour les deux threads)
        latch = new CountDownLatch(2);
        
        // Créer et démarrer le thread pour écrire la première partie
        Thread thread1 = new Thread(() -> {
            try {
                ecrireDansFichier(cheminFichier, premierePartie, true); // Écraser le fichier
                System.out.println("Thread 1: Première partie écrite");
            } finally {
                latch.countDown();
            }
        });
        
        // Créer et démarrer le thread pour écrire la seconde partie
        Thread thread2 = new Thread(() -> {
            try {
                ecrireDansFichier(cheminFichier, secondePartie, false); // Ajouter au fichier
                System.out.println("Thread 2: Seconde partie écrite");
            } finally {
                latch.countDown();
            }
        });
        
        // Démarrer les threads
        thread1.start();
        thread2.start();
        
        try {
            // Attendre que les deux threads terminent
            latch.await();
        } catch (InterruptedException e) {
            System.err.println("Erreur lors de l'attente des threads: " + e.getMessage());
        }
        
        // Fin du chronomètre
        long endTime = System.currentTimeMillis();
        
        // Calculer et afficher le temps d'exécution
        long executionTime = endTime - startTime;
        System.out.println("Temps d'exécution: " + executionTime + " millisecondes");
        System.out.println("La chaîne a été écrite avec succès dans le fichier " + cheminFichier);
        
        // Comparer avec l'approche mono-thread
        System.out.println("\nDifférence avec l'approche mono-thread:");
        System.out.println("- L'approche multi-thread peut être plus rapide pour de très grandes chaînes");
        System.out.println("- Elle peut également tirer parti des systèmes multiprocesseurs");
        System.out.println("- Cependant, la surcharge due à la création et la synchronisation des threads");
        System.out.println("  peut annuler les gains pour de petites chaînes de caractères");
        
        scanner.close();
    }
    
    /**
     * Génère une chaîne de caractères aléatoire de la longueur spécifiée
     * @param longueur La longueur de la chaîne à générer
     * @return La chaîne aléatoire générée
     */
    private static String genererChaineAleatoire(int longueur) {
        // Caractères possibles pour la chaîne aléatoire
        String caracteresPossibles = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        Random random = new Random();
        StringBuilder chaineBuilder = new StringBuilder(longueur);
        
        // Construire la chaîne caractère par caractère
        for (int i = 0; i < longueur; i++) {
            int indexAleatoire = random.nextInt(caracteresPossibles.length());
            char caractereAleatoire = caracteresPossibles.charAt(indexAleatoire);
            chaineBuilder.append(caractereAleatoire);
        }
        
        return chaineBuilder.toString();
    }
    
    /**
     * Écrit une chaîne de caractères dans un fichier
     * @param nomFichier Le nom du fichier
     * @param contenu Le contenu à écrire
     * @param ecraser Si true, écrase le fichier; sinon, ajoute au fichier
     */
    private static synchronized void ecrireDansFichier(String nomFichier, String contenu, boolean ecraser) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier, !ecraser))) {
            writer.write(contenu);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier: " + e.getMessage());
        }
    }
}
