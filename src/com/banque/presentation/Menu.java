package com.banque.presentation;


import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.banque.metier.compte;
import com.banque.metier.compteCourant;
import com.banque.metier.compteEpargne;
import com.banque.metier.operation;
import com.banque.utilitaire.validation;

public class Menu {
	
	private static Map<String, compte> comptes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void afficherMenu() {
        boolean quitter = false;
        while (!quitter) {
            System.out.println("=== Menu Gestion de Comptes Bancaires ===");
            System.out.println("1. Créer un compte courant");
            System.out.println("2. Créer un compte épargne");
            System.out.println("3. Effectuer un versement");
            System.out.println("4. Effectuer un retrait");
            System.out.println("5. Effectuer un virement");
            System.out.println("6. Consulter le solde d'un compte");
            System.out.println("7. Consulter la liste des opérations d'un compte");
            System.out.println("8. Quitter");
            
            try {
            	int choix = scanner.nextInt();
                scanner.nextLine(); 
                switch (choix) {
                    case 1:
                        creerCompteCourant();
                        break;
                    case 2:
                        creerCompteEpargne();
                        break;
                    case 3:
                        effectuerVersement();
                        break;
                    case 4:
                        effectuerRetrait();
                        break;
                    case 5:
                        effectuerVirement();
                        break;
                    case 6:
                        consulterSolde();
                        break;
                    case 7:
                        consulterOperations();
                        break;
                    case 8:
                        quitter = true;
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                
            } 
                } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Une erreur inattendue est survenue: " + e.getMessage());
            }
            System.out.println("");
        }
    }
    
    private static void creerCompteCourant() {
        System.out.print("Entrez le code du compte (format CPT-XXXXX): ");
        String code = scanner.nextLine();
        validation.ValidCompteCode(code);
        
        if (comptes.containsKey(code)) {
            throw new IllegalArgumentException("Un compte avec ce code existe déjà.");
        }
        
        System.out.print("Entrez le solde initial: ");
        double solde = scanner.nextDouble();
        validation.validateMontantPositif(solde);
        
        System.out.print("Entrez le découvert autorisé: ");
        double decouvert = scanner.nextDouble();
        validation.validateMontantPositif(decouvert);
        
        compteCourant compte = new compteCourant(code, solde, decouvert);
        comptes.put(code, compte);
        System.out.println("Compte courant créé avec succès.");
    }
    
    private static void creerCompteEpargne() {
        System.out.print("Entrez le code du compte (format CPT-XXXXX): ");
        String code = scanner.nextLine();
        validation.ValidCompteCode(code);
        
        if (comptes.containsKey(code)) {
            throw new IllegalArgumentException("Un compte avec ce code existe déjà.");
        }
        
        System.out.print("Entrez le solde initial: ");
        double solde = scanner.nextDouble();
        validation.validateMontantPositif(solde);
        
        System.out.print("Entrez le taux d'intérêt : ");
        double taux = scanner.nextDouble();
        taux = taux / 100.0;
        if (taux <= 0) {
            throw new IllegalArgumentException("Le taux d'intérêt doit être positif.");
        }
        
        compteEpargne compte = new compteEpargne(code, solde, taux);
        comptes.put(code, compte);
        System.out.println("Compte épargne créé avec succès.");
    }
    
    private static void effectuerVersement() {
        System.out.print("Entrez le code du compte: ");
        String code = scanner.nextLine();
        compte compte = comptes.get(code);
        if (compte == null) {
            System.out.println("Compte non trouvé.");
            return;
        }
        
        System.out.print("Entrez le montant à verser: ");
        double montant = scanner.nextDouble();
        scanner.nextLine(); 
        validation.validateMontantPositif(montant);
        
        System.out.print("Entrez la source (ex: Salaire): ");
        String source = scanner.nextLine();
        
        if (compte.verser(montant, source)) {
            System.out.println("Versement effectué avec succès.");
        } else {
            System.out.println("Échec du versement.");
        }
    }
    
    private static void effectuerRetrait() {
        System.out.print("Entrez le code du compte: ");
        String code = scanner.nextLine();
        compte compte = comptes.get(code);
        if (compte == null) {
            System.out.println("Compte non trouvé.");
            return;
        }
        
        System.out.print("Entrez le montant à retirer: ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        validation.validateMontantPositif(montant);
        
        System.out.print("Entrez la destination (ex: ATM): ");
        String destination = scanner.nextLine();
        
        if (compte.retirerCompte(montant, destination)) {
            System.out.println("Retrait effectué avec succès.");
        } else {
            System.out.println("Échec du retrait (solde insuffisant ou règles non respectées).");
        }
    }
    
    private static void effectuerVirement() {
        System.out.print("Entrez le code du compte source: ");
        String codeSource = scanner.nextLine();
        compte source = comptes.get(codeSource);
        
        System.out.print("Entrez le code du compte destination: ");
        String codeDest = scanner.nextLine();
        compte dest = comptes.get(codeDest);
        
        if (source == null || dest == null) {
            System.out.println("Un ou plusieurs comptes non trouvés.");
            return;
        }
        
        System.out.print("Entrez le montant à virer: ");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        validation.validateMontantPositif(montant);
        
        System.out.print("Entrez une description: ");
        String description = scanner.nextLine();
        
        if (source.retirerCompte(montant, "Virement vers " + codeDest + " - " + description)) {
            dest.verser(montant, "Virement de " + codeSource + " - " + description);
            System.out.println("Virement effectué avec succès.");
        } else {
            System.out.println("Échec du virement (solde insuffisant).");
        }
    }
    private static void consulterSolde() {
        System.out.print("Entrez le code du compte: ");
        String code = scanner.nextLine();
        compte compte = comptes.get(code);
        if (compte == null) {
            System.out.println("Compte non trouvé.");
            return;
        }
        compte.afficherDetails();
    }
    
    private static void consulterOperations() {
        System.out.print("Entrez le code du compte: ");
        String code = scanner.nextLine();
        compte compte = comptes.get(code);
        if (compte == null) {
            System.out.println("Compte non trouvé.");
            return;
        }
        List<operation> operations = compte.getListeOperations();
        if (operations.isEmpty()) {
            System.out.println("Aucune opération.");
        } else {
            System.out.println("Liste des opérations:");
            for (operation op : operations) {
                System.out.println(op.toString());
            }
        }
    }

}
