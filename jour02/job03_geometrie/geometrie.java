package jour02.job03_geometrie;

public class geometrie {
    
    public static void main(String[] args) {
        // Test du cercle
        Cercle cercle = new Cercle(5.0, 7.0, 3.0);
        cercle.affiche();
        System.out.println("Surface du cercle: " + cercle.surface());
        
        // Test si un point est à l'intérieur du cercle
        boolean estInterieur = cercle.estPointInterieur(4.0, 8.0);
        System.out.println("Le point (4,8) est à l'intérieur du cercle: " + estInterieur);
        
        boolean estExterieur = cercle.estPointInterieur(10.0, 10.0);
        System.out.println("Le point (10,10) est à l'intérieur du cercle: " + estExterieur + "\r\n");
        
        // Test du rectangle
        Rectangle rectangle = new Rectangle(4.0, 5.0, 2.0, 3.0);
        rectangle.affiche();
        System.out.println("Surface du rectangle: " + rectangle.surface());
        
        // Test du rectangle coloré
        RectangleColore rectangleColore = new RectangleColore(6.0, 8.0, 4.0, 5.0, 255);
        rectangleColore.affiche();
        System.out.println("Surface du rectangle coloré: " + rectangleColore.surface());
        System.out.println("Couleur du rectangle coloré: " + rectangleColore.getCouleur());
    }
}

// Classe Figure - classe de base pour toutes les figures
class Figure {
    protected double x;  // Coordonnée X du centre
    protected double y;  // Coordonnée Y du centre
    
    // Constructeur
    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Getters et Setters
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    // Méthode pour afficher les coordonnées du centre
    public void affiche() {
        System.out.println("Centre de la figure: (" + x + ", " + y + ")");
    }
}

// Classe Cercle qui hérite maintenant de Figure
class Cercle extends Figure {
    private double rayon;    // Rayon du cercle
    
    // Constructeur modifié
    public Cercle(double x, double y, double r) {
        super(x, y);  // Appel du constructeur de la classe parente Figure
        this.rayon = r;
    }
    
    // Getter et Setter pour le rayon
    public double getRayon() {
        return rayon;
    }
    
    public void setRayon(double rayon) {
        if (rayon > 0) {  // Validation: le rayon doit être positif
            this.rayon = rayon;
        } else {
            throw new IllegalArgumentException("Le rayon doit être positif");
        }
    }
    
    // Méthode pour calculer la surface du cercle
    public double surface() {
        return Math.PI * rayon * rayon;
    }
    
    // Méthode pour vérifier si un point (x,y) est à l'intérieur du cercle
    public boolean estPointInterieur(double x, double y) {
        // Calcul de la distance entre le point et le centre du cercle
        double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        
        // Si la distance est inférieure ou égale au rayon, le point est à l'intérieur
        return distance <= rayon;
    }
}

// Classe Rectangle qui hérite maintenant de Figure
class Rectangle extends Figure {
    private double largeur;
    private double longueur;
    
    // Constructeur modifié
    public Rectangle(double x, double y, double largeur, double longueur) {
        super(x, y);  // Appel du constructeur de la classe parente Figure
        this.largeur = largeur;
        this.longueur = longueur;
    }
    
    // Getters et Setters
    public double getLargeur() {
        return largeur;
    }
    
    public void setLargeur(double largeur) {
        if (largeur > 0) {
            this.largeur = largeur;
        } else {
            throw new IllegalArgumentException("La largeur doit être positive");
        }
    }
    
    public double getLongueur() {
        return longueur;
    }
    
    public void setLongueur(double longueur) {
        if (longueur > 0) {
            this.longueur = longueur;
        } else {
            throw new IllegalArgumentException("La longueur doit être positive");
        }
    }
    
    // Méthode pour calculer la surface du rectangle
    public double surface() {
        return largeur * longueur;
    }
}

// Classe RectangleColore qui hérite de Rectangle
class RectangleColore extends Rectangle {
    private int couleur; // Attribut supplémentaire pour la couleur
    
    // Constructeur modifié
    public RectangleColore(double x, double y, double largeur, double longueur, int couleur) {
        super(x, y, largeur, longueur); // Appel au constructeur de la classe parente
        this.couleur = couleur;
    }
    
    // Getter et Setter pour la couleur
    public int getCouleur() {
        return couleur;
    }
    
    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
}
