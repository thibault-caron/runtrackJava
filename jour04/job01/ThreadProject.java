package jour04.job01;

public class ThreadProject {
    
    public static void main(String[] args) {
        // Instanciation de MyThread
        MyThread thread = new MyThread();
        
        // Démarrage de l'exécution du thread
        thread.start();
        
        // Affiche un message dans le thread principal
        System.out.println("Le thread principal continue son exécution");
    }
}