package jour02.job04_vehicules;

public class vehicules {
    
    public static void main(String[] args) {
        // Test de la classe Vehicule
        Vehicule vehicule = new Vehicule("Renault", "15/03/2019", 15000.0);
        vehicule.affiche();
        vehicule.calculePrix(2023);
        System.out.println("Prix après calcul : " + vehicule.getPrixCourant() + " €");
        
        System.out.println("\n------------------------------\n");
        
        // Test de la classe Voiture
        Voiture voiture1 = new Voiture("Peugeot", "10/05/2018", 18000.0, 1600, 5, 110, 45000);
        voiture1.affiche();
        voiture1.calculePrix(2023);
        System.out.println("Prix après calcul : " + voiture1.getPrixCourant() + " €");
        
        System.out.println("\n------------------------------\n");
        
        // Test avec une voiture de marque Renault (décote supplémentaire)
        Voiture voiture2 = new Voiture("Renault", "10/05/2018", 18000.0, 1600, 5, 110, 45000);
        voiture2.affiche();
        voiture2.calculePrix(2023);
        System.out.println("Prix après calcul : " + voiture2.getPrixCourant() + " €");
        
        System.out.println("\n------------------------------\n");
        
        // Test avec une voiture de marque Ferrari (bonus de prix)
        Voiture voiture3 = new Voiture("Ferrari", "10/05/2018", 180000.0, 3800, 2, 550, 15000);
        voiture3.affiche();
        voiture3.calculePrix(2023);
        System.out.println("Prix après calcul : " + voiture3.getPrixCourant() + " €");
        
        System.out.println("\n------------------------------\n");
        
        // Test de la classe Avion avec hélices
        Avion avion1 = new Avion("Cessna", "01/01/2015", 500000.0, "HELICES", 450);
        avion1.affiche();
        avion1.calculePrix(2023);
        System.out.println("Prix après calcul : " + avion1.getPrixCourant() + " €");
        
        System.out.println("\n------------------------------\n");
        
        // Test de la classe Avion avec réaction
        Avion avion2 = new Avion("Boeing", "01/01/2015", 2000000.0, "REACTION", 5000);
        avion2.affiche();
        avion2.calculePrix(2023);
        System.out.println("Prix après calcul : " + avion2.getPrixCourant() + " €");
    }
}

/**
 * Classe représentant un véhicule générique
 */
class Vehicule {
    // Attributs
    private String marque;
    private String dateAchat;
    private double prixAchat;
    private double prixCourant;
    
    /**
     * Constructeur de la classe Vehicule
     * @param marque
     * @param dateAchat
     * @param prixAchat
     */
    public Vehicule(String marque, String dateAchat, double prixAchat) {
        this.marque = marque;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
        this.prixCourant = prixAchat; // Par défaut, on initialise le prix courant au prix d'achat
    }
    
    /**
     * Méthode qui affiche les caractéristiques du véhicule
     */
    public void affiche() {
        System.out.println("Caractéristiques du véhicule :");
        System.out.println("Marque : " + marque);
        System.out.println("Date d'achat : " + dateAchat);
        System.out.println("Prix d'achat : " + prixAchat + " €");
        System.out.println("Prix courant : " + prixCourant + " €");
    }
    
    /**
     * Méthode qui calcule le prix courant du véhicule
     * @param anneActuelle L'année actuelle
     */
    public void calculePrix(int anneActuelle) {
        // Extraction de l'année d'achat à partir de la chaîne dateAchat (supposant format DD/MM/YYYY)
        int anneeAchat = Integer.parseInt(dateAchat.substring(dateAchat.lastIndexOf('/') + 1));
        
        // Calcul du nombre d'années écoulées
        int nombreAnnees = anneActuelle - anneeAchat;
        
        // Calcul du prix courant avec dépréciation de 1% par an
        double nouveauPrix = prixAchat * (1 - 0.01 * nombreAnnees);
        
        // Vérification que le prix reste positif
        prixCourant = Math.max(0, nouveauPrix);
    }
    
    // Getters et setters
    
    public String getMarque() {
        return marque;
    }
    
    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    public String getDateAchat() {
        return dateAchat;
    }
    
    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }
    
    public double getPrixAchat() {
        return prixAchat;
    }
    
    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }
    
    public double getPrixCourant() {
        return prixCourant;
    }
    
    public void setPrixCourant(double prixCourant) {
        this.prixCourant = prixCourant;
    }
}

/**
 * Classe représentant une voiture, hérite de la classe Vehicule
 */
class Voiture extends Vehicule {
    // Attributs supplémentaires spécifiques à une voiture
    private int cylindree;
    private int nbPortes;
    private int puissance;
    private int kilometrage;
    
    /**
     * Constructeur de la classe Voiture
     * @param marque La marque de la voiture
     * @param dateAchat La date d'achat de la voiture
     * @param prixAchat Le prix d'achat de la voiture
     * @param cylindree La cylindrée de la voiture en cm³
     * @param nbPortes Le nombre de portes de la voiture
     * @param puissance La puissance de la voiture en chevaux
     * @param kilometrage Le kilométrage de la voiture en km
     */
    public Voiture(String marque, String dateAchat, double prixAchat,
                   int cylindree, int nbPortes, int puissance, int kilometrage) {
        // Appel du constructeur de la classe parente
        super(marque, dateAchat, prixAchat);
        
        // Initialisation des attributs spécifiques
        this.cylindree = cylindree;
        this.nbPortes = nbPortes;
        this.puissance = puissance;
        this.kilometrage = kilometrage;
    }
    
    /**
     * Méthode qui affiche les caractéristiques de la voiture
     * en utilisant la méthode de la classe parente
     */
    @Override
    public void affiche() {
        // Appel de la méthode d'affichage de la classe parente
        super.affiche();
        
        // Ajout des attributs spécifiques à la voiture
        System.out.println("Informations spécifiques à la voiture :");
        System.out.println("Cylindrée : " + cylindree + " cm³");
        System.out.println("Nombre de portes : " + nbPortes);
        System.out.println("Puissance : " + puissance + " ch");
        System.out.println("Kilométrage : " + kilometrage + " km");
    }
    
    /**
     * Méthode qui calcule le prix courant de la voiture
     * @param anneActuelle L'année actuelle
     */
    @Override
    public void calculePrix(int anneActuelle) {
        // Extraction de l'année d'achat
        int anneeAchat = Integer.parseInt(getDateAchat().substring(getDateAchat().lastIndexOf('/') + 1));
        
        // Calcul du nombre d'années écoulées
        int nombreAnnees = anneActuelle - anneeAchat;
        
        // Calcul du prix de base
        double nouveauPrix = getPrixAchat();
        
        // Dépréciation de 2% par an
        nouveauPrix = nouveauPrix * (1 - 0.02 * nombreAnnees);
        
        // Dépréciation de 5% par tranche de 10000km
        int tranches = Math.round(kilometrage / 10000.0f);
        nouveauPrix = nouveauPrix * (1 - 0.05 * tranches);
        
        // Ajustement selon la marque
        String marque = getMarque().toLowerCase();
        if (marque.equals("renault") || marque.equals("fiat")) {
            nouveauPrix = nouveauPrix * 0.90; // -10%
        } else if (marque.equals("ferrari") || marque.equals("porsche")) {
            nouveauPrix = nouveauPrix * 1.20; // +20%
        }
        
        // Vérification que le prix reste positif
        setPrixCourant(Math.max(0, nouveauPrix));
    }
    
    // Getters et setters pour les attributs spécifiques
    public int getCylindree() {
        return cylindree;
    }
    
    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }
    
    public int getNbPortes() {
        return nbPortes;
    }
    
    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }
    
    public int getPuissance() {
        return puissance;
    }
    
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
    
    public int getKilometrage() {
        return kilometrage;
    }
    
    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }
}

/**
 * Classe représentant un avion, hérite de la classe Vehicule
 */
class Avion extends Vehicule {
    // Attributs supplémentaires spécifiques à un avion
    private String typeMoteur;    // (HELICES ou REACTION)
    private int heuresVol;
    
    /**
     * Constructeur de la classe Avion
     * @param marque La marque de l'avion
     * @param dateAchat La date d'achat de l'avion
     * @param prixAchat Le prix d'achat de l'avion
     * @param typeMoteur Le type de moteur (HELICES ou REACTION)
     * @param heuresVol Le nombre d'heures de vol
     */
    public Avion(String marque, String dateAchat, double prixAchat, 
                 String typeMoteur, int heuresVol) {
        // Appel du constructeur de la classe parente
        super(marque, dateAchat, prixAchat);
        
        // Initialisation des attributs spécifiques
        this.typeMoteur = typeMoteur;
        this.heuresVol = heuresVol;
    }
    
    /**
     * Méthode qui affiche les caractéristiques de l'avion
     * en utilisant la méthode de la classe parente
     */
    @Override
    public void affiche() {
        // Appel de la méthode d'affichage de la classe parente
        super.affiche();
        
        // Ajout des attributs spécifiques à l'avion
        System.out.println("Informations spécifiques à l'avion :");
        System.out.println("Type de moteur : " + typeMoteur);
        System.out.println("Nombre d'heures de vol : " + heuresVol + " h");
    }
    
    /**
     * Méthode qui calcule le prix courant de l'avion
     * @param anneActuelle L'année actuelle
     */
    @Override
    public void calculePrix(int anneActuelle) {
        // Calcul du prix de base
        double nouveauPrix = getPrixAchat();
        
        // Dépréciation basée sur les heures de vol selon le type de moteur
        if (typeMoteur.equals("HELICES")) {
            // 10% par tranche de 100 heures pour les avions à hélices
            int tranches = (int) Math.ceil(heuresVol / 100.0);
            nouveauPrix = nouveauPrix * (1 - 0.10 * tranches);
        } else {
            // 10% par tranche de 1000 heures pour les autres types
            int tranches = (int) Math.ceil(heuresVol / 1000.0);
            nouveauPrix = nouveauPrix * (1 - 0.10 * tranches);
        }
        
        // Vérification que le prix reste positif
        setPrixCourant(Math.max(0, nouveauPrix));
    }
    
    // Getters et setters pour les attributs spécifiques
    public String getTypeMoteur() {
        return typeMoteur;
    }
    
    public void setTypeMoteur(String typeMoteur) {
        this.typeMoteur = typeMoteur;
    }
    
    public int getHeuresVol() {
        return heuresVol;
    }
    
    public void setHeuresVol(int heuresVol) {
        this.heuresVol = heuresVol;
    }
}
