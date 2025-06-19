package jour03.job04_Commerce;

// Classe Article
public class Article {
    private String reference;
    private String designation;
    private double prixUnitaire;
    private int quantiteStock;
    
    // Constructeur paramétré
    public Article(String reference, String designation, double prixUnitaire, int quantiteStock) {
        this.reference = reference;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
    }
    
    // Constructeur par copie
    public Article(Article a) {
        this.reference = a.reference;
        this.designation = a.designation;
        this.prixUnitaire = a.prixUnitaire;
        this.quantiteStock = a.quantiteStock;
    }
    
    // Accesseurs
    public String getReference() {
        return reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    
    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    public int getQuantiteStock() {
        return quantiteStock;
    }
    
    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
    
    // Méthode d'affichage
    public void affiche() {
        System.out.println("Référence : " + reference);
        System.out.println("Désignation : " + designation);
        System.out.println("Prix unitaire : " + prixUnitaire + " €");
        System.out.println("Quantité en stock : " + quantiteStock);
    }
}
