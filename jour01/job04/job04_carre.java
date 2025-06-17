package jour01.job04;

import java.util.Scanner;

public class job04_carre {
    
    public static void main(String[] args) {
        // Créer un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        
        // Demander à l'utilisateur de saisir un nombre
        System.out.println("Veuillez saisir un nombre:");
        
        // Lire le nombre saisi par l'utilisateur
        double nombre = scanner.nextDouble();
        
        // Calculer le carré du nombre
        double carre = nombre * nombre;
        
        // Afficher le résultat
        System.out.println("Le carré de " + nombre + " est: " + carre);
        
        // Fermer le scanner pour éviter les fuites de ressources
        scanner.close();
    }
}
