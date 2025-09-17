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
	 public Double calculerInteret() {
	        return getsolde() * tauxInteret;
	    }
	   
	 

}
