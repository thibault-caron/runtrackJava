package jour04.job08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class job08_parallel_sum {
    
    // Nombre maximum à calculer
    private static final int MAX_NUMBER = 10_000_000;
    
    // Nombre de threads à utiliser (basé sur les cœurs disponibles)
    private static final int NUM_THREADS = Math.max(1, Runtime.getRuntime().availableProcessors());
    
    // Somme partagée entre les threads
    private static final AtomicLong sharedSum = new AtomicLong(0);
    
    public static void main(String[] args) {
        System.out.println("Calcul de la somme des nombres de 1 à " + MAX_NUMBER);
        System.out.println("Utilisation de " + NUM_THREADS + " threads");
        
        // Début du chronomètre
        long startTime = System.currentTimeMillis();
        
        // Calculer la somme en parallèle
        parallelSum();
        
        // Fin du chronomètre
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        System.out.println("\nSomme calculée (parallèle): " + sharedSum.get());
        System.out.println("Temps d'exécution (parallèle): " + executionTime + " millisecondes");
        
        // Vérification avec la méthode séquentielle
        startTime = System.currentTimeMillis();
        long sequentialSum = sequentialSum();
        endTime = System.currentTimeMillis();
        long sequentialTime = endTime - startTime;
        
        System.out.println("\nSomme calculée (séquentielle): " + sequentialSum);
        System.out.println("Temps d'exécution (séquentielle): " + sequentialTime + " millisecondes");
        
        // Vérification avec la formule mathématique
        long formulaSum = (long) MAX_NUMBER * (MAX_NUMBER + 1L) / 2L;
        System.out.println("\nSomme calculée (formule mathématique): " + formulaSum);
        
        // Comparer les résultats
        if (sharedSum.get() == formulaSum && sequentialSum == formulaSum) {
            System.out.println("Tous les résultats sont corrects!");
        } else {
            System.out.println("Attention: les résultats sont différents!");
        }
        
        System.out.println("\nAccélération avec parallélisme: " + 
                           String.format("%.2f", (double) sequentialTime / executionTime) + "x");
        
        // Discussion sur les risques
        System.out.println("\n=== DISCUSSION SUR LES RISQUES ===");
        System.out.println("Une implémentation incorrecte peut causer:");
        System.out.println("1. Fork bomb - Création incontrôlée de threads");
        System.out.println("2. Race conditions - Accès concurrents non synchronisés");
        System.out.println("3. Overhead - Trop de threads peut réduire les performances");
        System.out.println("4. OutOfMemoryError - Trop de threads consomment trop de mémoire");
        System.out.println("\nApproche sécurisée utilisée:");
        System.out.println("1. Utilisation d'un ExecutorService (thread pool)");
        System.out.println("2. Nombre de threads basé sur les cœurs disponibles");
        System.out.println("3. AtomicLong pour gérer les accès concurrents");
        System.out.println("4. Division du travail en tâches de taille appropriée");
    }
    
    // Méthode pour calculer la somme en parallèle
    private static void parallelSum() {
        // Créer un pool de threads avec un nombre fixe de threads
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        
        // Calculer la taille des blocs pour chaque thread
        int blockSize = MAX_NUMBER / NUM_THREADS;
        
        try {
            // Soumettre les tâches au pool de threads
            for (int i = 0; i < NUM_THREADS; i++) {
                final int startValue = i * blockSize + 1;
                // Le dernier thread prend tout ce qui reste
                final int endValue = (i == NUM_THREADS - 1) ? MAX_NUMBER : (i + 1) * blockSize;
                
                executor.submit(() -> {
                    long localSum = 0;
                    for (int j = startValue; j <= endValue; j++) {
                        localSum += j;
                    }
                    // Ajouter la somme locale à la somme partagée de manière atomique
                    sharedSum.addAndGet(localSum);
                    System.out.println("Thread calculé: " + startValue + " à " + endValue + 
                                       " = " + localSum);
                });
            }
            
            // Arrêter d'accepter de nouvelles tâches et attendre que toutes les tâches soient terminées
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
            
        } catch (InterruptedException e) {
            System.err.println("L'exécution des threads a été interrompue: " + e.getMessage());
        }
    }
    
    // Méthode pour calculer la somme séquentiellement (pour comparaison)
    private static long sequentialSum() {
        long sum = 0;
        for (int i = 1; i <= MAX_NUMBER; i++) {
            sum += i;
        }
        return sum;
    }
}
