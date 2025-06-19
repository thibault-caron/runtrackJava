package jour04.job02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class job02_chaine {
    
    public static void main(String[] args) {
                       
        Scanner scanner = new Scanner(System.in);
        
        // Demander la longueur de la chaîne à l'utilisateur
        System.out.print("Entrez la longueur de la chaîne de caractères à générer: ");
        int longueur = scanner.nextInt();

        // Début du chronomètre
        long startTime = System.currentTimeMillis();
        
        // Générer une chaîne de caractères aléatoire
        String chaineAleatoire = genererChaineAleatoire(longueur);
        
        // Écrire la chaîne dans un fichier output.txt
        String cheminFichier = "jour04/job02/output.txt";
        ecrireDansFichier(cheminFichier, chaineAleatoire);
        
        // Fin du chronomètre
        long endTime = System.currentTimeMillis();
        
        // Calculer et afficher le temps d'exécution
        long executionTime = endTime - startTime;
        System.out.println("Temps d'exécution: " + executionTime + " millisecondes");
        
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
     */
    private static void ecrireDansFichier(String nomFichier, String contenu) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
            writer.write(contenu);
            System.out.println("La chaîne a été écrite avec succès dans le fichier " + nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier: " + e.getMessage());
        }
    }
}
