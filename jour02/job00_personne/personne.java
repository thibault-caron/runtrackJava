package jour02.job00_personne;

public class personne {
    // Attributs publics
    public String nom;
    public String prenom;
    
    // Attributs protégés
    protected String dateNaissance;
    protected String lieuNaissance;
    
    // Attributs privés
    private String adresse;
    private String telephone;
    
    // Constructeur
    public personne(String nom, String prenom, String dateNaissance, 
                   String lieuNaissance, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    
    // Getters et setters pour les attributs privés
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    // Getters et setters pour les attributs protégés
    public String getDateNaissance() {
        return dateNaissance;
    }
    
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public String getLieuNaissance() {
        return lieuNaissance;
    }
    
    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }
    
    // Méthode main pour démontrer les différences d'accès
    public static void main(String[] args) {
        personne p = new personne("Dupont", "Jean", "01/01/1990", 
                                 "Paris", "123 rue de la Paix", "0123456789");
        
        // Accès aux attributs publics depuis n'importe où
        System.out.println("Nom: " + p.nom);
        System.out.println("Prénom: " + p.prenom);
        
        // Accès aux attributs protégés depuis la même classe ou sous-classes
        System.out.println("Date de naissance: " + p.dateNaissance);
        System.out.println("Lieu de naissance: " + p.lieuNaissance);
        
        // Accès aux attributs privés uniquement via getters
        System.out.println("Adresse: " + p.getAdresse());
        System.out.println("Téléphone: " + p.getTelephone());
        
        // Explication des différences
        System.out.println("\nDifférences entre les types d'attributs:");
        System.out.println("1. Public: accessibles depuis n'importe où");
        System.out.println("2. Protected: accessibles depuis la même classe, le même package et les sous-classes");
        System.out.println("3. Private: accessibles uniquement depuis la classe elle-même");
        
        System.out.println("\nUtilisation des getters/setters:");
        System.out.println("- Nécessaires pour les attributs privés pour y accéder depuis l'extérieur");
        System.out.println("- Recommandés pour les attributs protégés lorsqu'ils sont utilisés en dehors du package");
        System.out.println("- Facultatifs pour les attributs publics, mais recommandés pour l'encapsulation");
    }
}
