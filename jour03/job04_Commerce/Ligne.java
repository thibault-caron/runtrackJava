package jour03.job04_Commerce;

// Classe Ligne (association entre Commande et Article)
public class Ligne {
    private Commande commande;
    private Article article;
    private int quantiteCommande;
    
    // Constructeur
    public Ligne(Commande commande, Article article, int quantiteCommande) {
        this.commande = commande;
        this.article = article;
        this.quantiteCommande = quantiteCommande;
    }
    
    // Accesseurs
    public Commande getCommande() {
        return commande;
    }
    
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    public Article getArticle() {
        return article;
    }
    
    public void setArticle(Article article) {
        this.article = article;
    }
    
    public int getQuantiteCommande() {
        return quantiteCommande;
    }
    
    public void setQuantiteCommande(int quantiteCommande) {
        this.quantiteCommande = quantiteCommande;
    }
}
