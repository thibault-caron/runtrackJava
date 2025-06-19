package jour03.job04_Commerce;

// Classe Client qui hérite de Personne
public class Client extends Personne {
    private double chiffreAffaire;
    
    // Constructeur
    public Client(int identite, String nomSocial, String adresse, double chiffreAffaire) {
        super(identite, nomSocial, adresse);
        this.chiffreAffaire = chiffreAffaire;
    }
    
    // Accesseurs pour chiffreAffaire
    public double getChiffreAffaire() {
        return chiffreAffaire;
    }
    
    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }
    
    // Accesseurs publics pour les attributs hérités
    @Override
    public int getIdentite() {
        return super.getIdentite();
    }
    
    @Override
    public String getNomSocial() {
        return super.getNomSocial();
    }
    
    @Override
    public String getAdresse() {
        return super.getAdresse();
    }
    
    // Méthode d'affichage
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Chiffre d'affaire : " + chiffreAffaire + " €");
    }
}
