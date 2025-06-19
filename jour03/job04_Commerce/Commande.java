package jour03.job04_Commerce;

// Classe Commande
public class Commande {
    private int numeroCommande;
    private String dateCommande;
    private Client client;
    
    // Constructeur
    public Commande(int numeroCommande, String dateCommande, Client client) {
        this.numeroCommande = numeroCommande;
        this.dateCommande = dateCommande;
        this.client = client;
    }
    
    // Accesseurs
    public int getNumeroCommande() {
        return numeroCommande;
    }
    
    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }
    
    public String getDateCommande() {
        return dateCommande;
    }
    
    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
}
