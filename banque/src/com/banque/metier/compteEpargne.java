package com.banque.metier;

public class compteEpargne extends compte{
	
	private Double tauxInteret;
	
	public compteEpargne (String code , Double solde, Double tauxInteret) {
		super(code,solde);
		this.tauxInteret=tauxInteret;
		
	}
	
	public Double gettauxInteret() {
		return tauxInteret;
	}
	public void settauxInteret(Double tauxInteret) {
		this.tauxInteret=tauxInteret;
	}
	
	
	@Override
	public boolean retirerCompte(Double montant,String destination) {
		if (montant<= 0) {
			return false;
		}
		
		if(getsolde()>= montant) {
			retrait retrait = new retrait(montant,destination);
    		this.setsolde(this.getsolde() - montant);
    		ajouterOperation(retrait);
    		return true;
			}
		return false;
		
	}

	
	@Override
	public Double calculerInteret() {
	      return getsolde() * tauxInteret;
	   }
	
	@Override
	public void afficherDetails() {
		System.out.println(" Compte Epargne");
    	System.out.println("Code" + getcode());
    	System.out.println("Solde" + getsolde());
    	System.out.println("Taux d'interet" + (tauxInteret*100)+ "%");
    	System.out.println("Votre Interet" + calculerInteret()+"dh");
    	System.out.println("");
	}

	   
	 

}
