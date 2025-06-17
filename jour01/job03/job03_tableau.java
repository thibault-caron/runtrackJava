package jour01.job03;

public class job03_tableau {
    
    public static void main(String[] args) {
        // Créer un tableau de 10 entiers (de 0 à 9)
        int[] T = new int[10];
        
        // Remplir le tableau avec les valeurs de 0 à 9
        for (int i = 0; i < T.length; i++) {
            T[i] = i;
        }
        
        // Afficher les valeurs demandées
        System.out.println("T[0] = " + T[0]);
        System.out.println("T[1] = " + T[1]);
        System.out.println("T[5] = " + T[5]);
        System.out.println("T[9] = " + T[9]);
        
        // Pour T[10], nous avons un problème car l'index est hors limites
        System.out.println("T[10] = Exception! L'index 10 est hors des limites du tableau (taille 10)");
        System.out.println("En Java, les indices commencent à 0, donc un tableau de taille 10 a des indices de 0 à 9.");
        
        // On peut aussi démontrer l'erreur avec un bloc try-catch
        try {
            System.out.println("Tentative d'accès à T[10]: " + T[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception capturée: " + e.getMessage());
        }
    }
}
