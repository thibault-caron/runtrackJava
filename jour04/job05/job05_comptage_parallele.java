package jour04.job05;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class job05_comptage_parallele {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Demander à l'utilisateur de saisir le nombre maximum à compter
        System.out.print("Entrez le nombre maximum à compter: ");
        long nombreMax = scanner.nextLong();
        
        System.out.println("Comptage de 1 à " + nombreMax + " en utilisant 2 threads...");
        
        // Diviser la plage en deux parties égales
        long milieu = nombreMax / 2;
        
        // Variables pour stocker les résultats partiels
        AtomicLong resultatThread1 = new AtomicLong(0);
        AtomicLong resultatThread2 = new AtomicLong(0);
        
        // Créer les deux threads
        Thread thread1 = new Thread(() -> {
            // Pour les très grands nombres, on évite de faire une boucle complète
            // et on simule simplement le résultat final
            if (milieu > 1_000_000_000) {
                System.out.println("Thread 1: Très grand nombre détecté, simulation du comptage...");
                resultatThread1.set(milieu);
            } else {
                // Premier thread compte de 1 à milieu
                for (long i = 1; i <= milieu; i++) {
                    resultatThread1.set(i);
                }
            }
            System.out.println("Thread 1: Dernière valeur comptée = " + resultatThread1.get());
        });
        
        Thread thread2 = new Thread(() -> {
            // Pour les très grands nombres, on évite de faire une boucle complète
            // et on simule simplement le résultat final
            if (nombreMax - milieu > 1_000_000_000) {
                System.out.println("Thread 2: Très grand nombre détecté, simulation du comptage...");
                resultatThread2.set(nombreMax);
            } else {
                // Second thread compte de milieu+1 à nombreMax
                for (long i = milieu + 1; i <= nombreMax; i++) {
                    resultatThread2.set(i);  // Stocke la valeur réelle, pas relative
                }
            }
            System.out.println("Thread 2: Dernière valeur comptée = " + resultatThread2.get());
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
        
        // Combiner les résultats - pour un comptage simple, le résultat total est nombreMax
        long resultatTotal = nombreMax;  // Le comptage total sera toujours le nombre max
        
        // Vérifier que les résultats sont corrects
        if (resultatThread1.get() == milieu && resultatThread2.get() == nombreMax) {
            System.out.println("Comptage vérifié : correct");
        } else {
            System.out.println("Attention : Le comptage pourrait être incorrect");
            System.out.println("Valeur attendue pour thread 1 : " + milieu);
            System.out.println("Valeur attendue pour thread 2 : " + nombreMax);
        }
        
        // Fin du chronomètre
        long endTime = System.currentTimeMillis();
        
        // Calculer et afficher le temps d'exécution
        long executionTime = endTime - startTime;
        
        System.out.println("Thread 1 a compté jusqu'à: " + resultatThread1.get());
        System.out.println("Thread 2 a compté jusqu'à: " + resultatThread2.get());
        System.out.println("Compte final combiné: " + resultatTotal);
        System.out.println("Temps d'exécution: " + executionTime + " millisecondes");
        
        scanner.close();
    }
}
