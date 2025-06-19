package jour03.job04_Commerce;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        // Création de l'objet Commerciale
        Commerciale commerciale = new Commerciale();
        
        // Scanner pour la saisie utilisateur
        Scanner scanner = new Scanner(System.in);
        
        int choix = 0;
        
        do {
            // Affichage du menu
            System.out.println("\n===== MENU GESTION COMMERCIALE =====");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Supprimer un client");
            System.out.println("3. Ajouter un article");
            System.out.println("4. Supprimer un article");
            System.out.println("5. Passer une commande");
            System.out.println("6. Annuler une commande");
            System.out.println("7. Afficher tous les clients");
            System.out.println("8. Afficher tous les articles");
            System.out.println("9. Afficher toutes les commandes");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            
            try {
                choix = scanner.nextInt();
                scanner.nextLine(); // Consomme la nouvelle ligne
                
                switch (choix) {
                    case 1:
                        ajouterClient(scanner, commerciale);
                        break;
                    case 2:
                        supprimerClient(scanner, commerciale);
                        break;
                    case 3:
                        ajouterArticle(scanner, commerciale);
                        break;
                    case 4:
                        supprimerArticle(scanner, commerciale);
                        break;
                    case 5:
                        passerCommande(scanner, commerciale);
                        break;
                    case 6:
                        annulerCommande(scanner, commerciale);
                        break;
                    case 7:
                        afficherClients(commerciale);
                        break;
                    case 8:
                        afficherArticles(commerciale);
                        break;
                    case 9:
                        afficherCommandes(commerciale);
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide !");
                }
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
                scanner.nextLine(); // Consomme l'entrée erronée
                choix = -1;
            }
        } while (choix != 0);
        
        scanner.close();
    }
    
    // Méthodes auxiliaires pour interagir avec l'utilisateur
    private static void ajouterClient(Scanner scanner, Commerciale commerciale) {
        System.out.println("\n=== Ajout d'un nouveau client ===");
        
        System.out.print("Identifiant : ");
        int identite = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne
        
        System.out.print("Nom social : ");
        String nomSocial = scanner.nextLine();
        
        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        
        System.out.print("Chiffre d'affaire : ");
        double chiffreAffaire = scanner.nextDouble();
        
        Client client = new Client(identite, nomSocial, adresse, chiffreAffaire);
        commerciale.ajouterClient(client);
        System.out.println("Client ajouté avec succès !");
    }
    
    private static void supprimerClient(Scanner scanner, Commerciale commerciale) {
        System.out.println("\n=== Suppression d'un client ===");
        
        // Afficher la liste des clients
        afficherClients(commerciale);
        
        if (commerciale.getClients().isEmpty()) {
            return;
        }
        
        System.out.print("Entrez l'identifiant du client à supprimer : ");
        int identite = scanner.nextInt();
        
        // Recherche du client dans le vecteur
        for (Client c : commerciale.getClients()) {
            if (c.getIdentite() == identite) {
                commerciale.supprimerClient(c);
                System.out.println("Client supprimé avec succès !");
                return;
            }
        }
        
        System.out.println("Client non trouvé !");
    }
    
    private static void ajouterArticle(Scanner scanner, Commerciale commerciale) {
        System.out.println("\n=== Ajout d'un nouvel article ===");
        
        System.out.print("Référence : ");
        String reference = scanner.nextLine();
        
        System.out.print("Désignation : ");
        String designation = scanner.nextLine();
        
        System.out.print("Prix unitaire : ");
        double prixUnitaire = scanner.nextDouble();
        
        System.out.print("Quantité en stock : ");
        int quantiteStock = scanner.nextInt();
        
        Article article = new Article(reference, designation, prixUnitaire, quantiteStock);
        commerciale.ajouterArticle(article);
        System.out.println("Article ajouté avec succès !");
    }
    
    private static void supprimerArticle(Scanner scanner, Commerciale commerciale) {
        System.out.println("\n=== Suppression d'un article ===");
        
        // Afficher la liste des articles
        afficherArticles(commerciale);
        
        if (commerciale.getArticles().isEmpty()) {
            return;
        }
        
        System.out.print("Entrez la référence de l'article à supprimer : ");
        String reference = scanner.nextLine();
        
        // Recherche de l'article dans le vecteur
        for (Article a : commerciale.getArticles()) {
            if (a.getReference().equals(reference)) {
                commerciale.supprimerArticle(a);
                System.out.println("Article supprimé avec succès !");
                return;
            }
        }
        
        System.out.println("Article non trouvé !");
    }
    
    private static void passerCommande(Scanner scanner, Commerciale commerciale) {
        System.out.println("\n=== Passer une nouvelle commande ===");
        
        // Vérifier s'il y a des clients et des articles
        if (commerciale.getClients().isEmpty()) {
            System.out.println("Aucun client disponible ! Veuillez d'abord ajouter des clients.");
            return;
        }
        
        if (commerciale.getArticles().isEmpty()) {
            System.out.println("Aucun article disponible ! Veuillez d'abord ajouter des articles.");
            return;
        }
        
        System.out.print("Numéro de commande : ");
        int numeroCommande = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne
        
        System.out.print("Date de commande (JJ/MM/AAAA) : ");
        String dateCommande = scanner.nextLine();
        
        // Afficher la liste des clients
        afficherClients(commerciale);
        
        System.out.print("Entrez l'identifiant du client : ");
        int identite = scanner.nextInt();
        
        // Recherche du client
        Client clientCommande = null;
        for (Client c : commerciale.getClients()) {
            if (c.getIdentite() == identite) {
                clientCommande = c;
                break;
            }
        }
        
        if (clientCommande == null) {
            System.out.println("Client non trouvé !");
            return;
        }
        
        // Création de la commande
        Commande commande = new Commande(numeroCommande, dateCommande, clientCommande);
        
        // Ajout des lignes de commande
        boolean ajouterLigne = true;
        while (ajouterLigne) {
            // Afficher la liste des articles
            afficherArticles(commerciale);
            
            System.out.print("Entrez la référence de l'article : ");
            scanner.nextLine(); // Consomme la nouvelle ligne
            String reference = scanner.nextLine();
            
            // Recherche de l'article
            Article articleCommande = null;
            for (Article a : commerciale.getArticles()) {
                if (a.getReference().equals(reference)) {
                    articleCommande = a;
                    break;
                }
            }
            
            if (articleCommande == null) {
                System.out.println("Article non trouvé !");
                continue;
            }
            
            System.out.print("Quantité commandée : ");
            int quantiteCommande = scanner.nextInt();
            
            if (quantiteCommande > articleCommande.getQuantiteStock()) {
                System.out.println("Stock insuffisant !");
                continue;
            }
            
            // Créer et ajouter la ligne de commande
            Ligne ligne = new Ligne(commande, articleCommande, quantiteCommande);
            commerciale.ajouterLigne(ligne);
            
            // Mettre à jour le stock
            articleCommande.setQuantiteStock(articleCommande.getQuantiteStock() - quantiteCommande);
            
            System.out.print("Voulez-vous ajouter un autre article à la commande ? (O/N) : ");
            String reponse = scanner.next();
            ajouterLigne = reponse.equalsIgnoreCase("O");
        }
        
        // Ajouter la commande
        commerciale.passerCommande(commande);
        System.out.println("Commande passée avec succès !");
    }
    
    private static void annulerCommande(Scanner scanner, Commerciale commerciale) {
        System.out.println("\n=== Annulation d'une commande ===");
        
        // Afficher les commandes
        afficherCommandes(commerciale);
        
        if (commerciale.getCommandes().isEmpty()) {
            return;
        }
        
        System.out.print("Entrez le numéro de la commande à annuler : ");
        int numeroCommande = scanner.nextInt();
        
        // Recherche de la commande
        Commande commandeAnnuler = null;
        for (Commande c : commerciale.getCommandes()) {
            if (c.getNumeroCommande() == numeroCommande) {
                commandeAnnuler = c;
                break;
            }
        }
        
        if (commandeAnnuler == null) {
            System.out.println("Commande non trouvée !");
            return;
        }
        
        // Annuler la commande
        commerciale.annulerCommande(commandeAnnuler);
        System.out.println("Commande annulée avec succès !");
    }
    
    private static void afficherClients(Commerciale commerciale) {
        System.out.println("\n=== Liste des clients ===");
        
        if (commerciale.getClients().isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return;
        }
        
        for (Client c : commerciale.getClients()) {
            c.affiche();
            System.out.println("-------------------------");
        }
    }
    
    private static void afficherArticles(Commerciale commerciale) {
        System.out.println("\n=== Liste des articles ===");
        
        if (commerciale.getArticles().isEmpty()) {
            System.out.println("Aucun article enregistré.");
            return;
        }
        
        for (Article a : commerciale.getArticles()) {
            a.affiche();
            System.out.println("-------------------------");
        }
    }
    
    private static void afficherCommandes(Commerciale commerciale) {
        System.out.println("\n=== Liste des commandes ===");
        
        if (commerciale.getCommandes().isEmpty()) {
            System.out.println("Aucune commande enregistrée.");
            return;
        }
        
        for (Commande c : commerciale.getCommandes()) {
            System.out.println("Commande n°" + c.getNumeroCommande());
            System.out.println("Date : " + c.getDateCommande());
            System.out.println("Client : " + c.getClient().getNomSocial());
            
            // Afficher les lignes de commande associées
            System.out.println("Articles commandés :");
            for (Ligne l : commerciale.getLignes()) {
                if (l.getCommande() == c) {
                    System.out.println("  - " + l.getArticle().getDesignation() + 
                                       " x " + l.getQuantiteCommande() + 
                                       " (" + l.getArticle().getPrixUnitaire() + "€ unité)");
                }
            }
            System.out.println("-------------------------");
        }
    }
}
