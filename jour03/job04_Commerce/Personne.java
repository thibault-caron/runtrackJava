package jour03.job04_Commerce;

// Classe abstraite Personne
public abstract class Personne {
    protected int identite;
    protected String nomSocial;
    protected String adresse;
    
    // Constructeur
    protected Personne(int identite, String nomSocial, String adresse) {
        this.identite = identite;
        this.nomSocial = nomSocial;
        this.adresse = adresse;
    }
    
    // Accesseurs (getters et setters)
    protected int getIdentite() {
        return identite;
    }
    
    protected void setIdentite(int identite) {
        this.identite = identite;
    }
    
    protected String getNomSocial() {
        return nomSocial;
    }
    
    protected void setNomSocial(String nomSocial) {
        this.nomSocial = nomSocial;
    }
    
    protected String getAdresse() {
        return adresse;
    }
    
    protected void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    // Méthode d'affichage
    protected void affiche() {
        System.out.println("Identité : " + identite);
        System.out.println("Nom Social : " + nomSocial);
        System.out.println("Adresse : " + adresse);
    }
}
