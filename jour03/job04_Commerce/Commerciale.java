package jour03.job04_Commerce;

import java.util.Vector;

// Classe Commerciale
public class Commerciale {
    private Vector<Article> articles;
    private Vector<Client> clients;
    private Vector<Commande> commandes;
    private Vector<Ligne> lignes;
    
    // Constructeur
    public Commerciale() {
        this.articles = new Vector<>();
        this.clients = new Vector<>();
        this.commandes = new Vector<>();
        this.lignes = new Vector<>();
    }
    
    // Méthodes pour la gestion des commandes
    public void passerCommande(Commande c) {
        commandes.add(c);
    }
    
    public void annulerCommande(Commande c) {
        // Remettre les articles en stock
        for (Ligne l : lignes) {
            if (l.getCommande() == c) {
                Article article = l.getArticle();
                article.setQuantiteStock(article.getQuantiteStock() + l.getQuantiteCommande());
            }
        }
        
        // Supprimer les lignes associées à cette commande
        Vector<Ligne> lignesToRemove = new Vector<>();
        for (Ligne l : lignes) {
            if (l.getCommande() == c) {
                lignesToRemove.add(l);
            }
        }
        lignes.removeAll(lignesToRemove);
        
        // Supprimer la commande
        commandes.remove(c);
    }
    
    // Méthodes pour la gestion des articles
    public void ajouterArticle(Article a) {
        articles.add(a);
    }
    
    public void supprimerArticle(Article a) {
        articles.remove(a);
    }
    
    // Méthodes pour la gestion des clients
    public void ajouterClient(Client c) {
        clients.add(c);
    }
    
    public void supprimerClient(Client c) {
        clients.remove(c);
    }
    
    // Méthode pour ajouter une ligne de commande
    public void ajouterLigne(Ligne l) {
        lignes.add(l);
    }
    
    // Accesseurs pour les vecteurs
    public Vector<Article> getArticles() {
        return articles;
    }
    
    public Vector<Client> getClients() {
        return clients;
    }
    
    public Vector<Commande> getCommandes() {
        return commandes;
    }
    
    public Vector<Ligne> getLignes() {
        return lignes;
    }
}
