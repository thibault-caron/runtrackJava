package jour03.job02_Magiciens;

public class magiciens {
    
    public static void main(String[] args) {
        // Création d'un jeu
        Jeu monJeu = new Jeu();
        
        // Ajout de différentes cartes au jeu
        monJeu.piocher(new Terrain('B')); // Terrain blanc
        monJeu.piocher(new Terrain('r')); // Terrain rouge
        monJeu.piocher(new Creature("Gobelin", 2, 1, 2));
        monJeu.piocher(new Creature("Dragon", 5, 5, 7));
        monJeu.piocher(new Sortilege("Éclair", "Inflige 3 points de dégâts à n'importe quelle cible.", 1));
        monJeu.piocher(new Sortilege("Croissance Gigantesque", "Double les points de vie d'une créature.", 3));
        
        // Affichage du jeu
        System.out.println("\n===== CONTENU DU JEU =====");
        monJeu.afficher();
        
        // Jouer quelques cartes
        System.out.println("\n===== JOUER DES CARTES =====");
        monJeu.jouer();
        monJeu.jouer();
        
        // Affichage du jeu après avoir joué des cartes
        System.out.println("\n===== CONTENU DU JEU APRÈS AVOIR JOUÉ =====");
        monJeu.afficher();
    }
}

/**
 * Classe abstraite représentant une carte de base
 */
abstract class Carte {
    protected int cout;
    
    public Carte(int cout) {
        this.cout = cout;
    }
    
    public int getCout() {
        return cout;
    }
    
    // Méthode abstraite à implémenter par les sous-classes
    public abstract void afficher();
}

/**
 * Classe représentant une carte de type Terrain
 */
class Terrain extends Carte {
    private char couleur; // 'B'-blanc, 'b'-bleu, 'n'-noir, 'r'-rouge, 'v'-vert
    
    public Terrain(char couleur) {
        super(0); // Le coût d'un terrain est toujours 0
        this.couleur = couleur;
        System.out.println("Création d'une carte Terrain");
    }
    
    @Override
    public void afficher() {
        System.out.print("Terrain | Coût: " + getCout() + " | Couleur: ");
        switch(couleur) {
            case 'B': System.out.println("Blanc"); break;
            case 'b': System.out.println("Bleu"); break;
            case 'n': System.out.println("Noir"); break;
            case 'r': System.out.println("Rouge"); break;
            case 'v': System.out.println("Vert"); break;
            default: System.out.println("Inconnue");
        }
    }
}

/**
 * Classe représentant une carte de type Créature
 */
class Creature extends Carte {
    private String nom;
    private int pointsDegats;
    private int pointsVie;
    
    public Creature(String nom, int pointsDegats, int pointsVie, int cout) {
        super(cout);
        this.nom = nom;
        this.pointsDegats = pointsDegats;
        this.pointsVie = pointsVie;
        System.out.println("Création d'une carte Créature");
    }
    
    @Override
    public void afficher() {
        System.out.println("Créature | Coût: " + getCout() + " | Nom: " + nom + 
                           " | Dégâts: " + pointsDegats + " | Vie: " + pointsVie);
    }
}

/**
 * Classe représentant une carte de type Sortilège
 */
class Sortilege extends Carte {
    private String nom;
    private String explication;
    
    public Sortilege(String nom, String explication, int cout) {
        super(cout);
        this.nom = nom;
        this.explication = explication;
        System.out.println("Création d'une carte Sortilège");
    }
    
    @Override
    public void afficher() {
        System.out.println("Sortilège | Coût: " + getCout() + " | Nom: " + nom + 
                           " | Description: " + explication);
    }
}

/**
 * Classe représentant un jeu de cartes
 */
class Jeu {
    private static final int TAILLE_MAX = 60;
    private Carte[] cartes;
    private int nbCartes;
    
    public Jeu() {
        cartes = new Carte[TAILLE_MAX];
        nbCartes = 0;
    }
    
    /**
     * Ajoute une carte au jeu
     */
    public void piocher(Carte carte) {
        if (nbCartes < TAILLE_MAX) {
            cartes[nbCartes] = carte;
            nbCartes++;
            System.out.println("Carte ajoutée au jeu.");
        } else {
            System.out.println("Le jeu est plein, impossible d'ajouter plus de cartes.");
        }
    }
    
    /**
     * Joue la première carte du jeu
     */
    public void jouer() {
        for (int i = 0; i < TAILLE_MAX; i++) {
            if (cartes[i] != null) {
                System.out.println("Carte jouée :");
                cartes[i].afficher();
                cartes[i] = null;
                return;
            }
        }
        System.out.println("Aucune carte à jouer.");
    }
    
    /**
     * Affiche le contenu du jeu
     */
    public void afficher() {
        boolean jeuVide = true;
        for (int i = 0; i < TAILLE_MAX; i++) {
            if (cartes[i] != null) {
                System.out.print((i + 1) + ". ");
                cartes[i].afficher();
                jeuVide = false;
            }
        }
        if (jeuVide) {
            System.out.println("Le jeu est vide.");
        }
    }
}
