package com.banque.metier;



import java.util.ArrayList;
import java.util.List;

public abstract class compte {
	
	
	private String code;
	private Double solde;
	private List<operation> listeOperations;
	
    public compte(String code, Double solde) {
    	this.code=code;
    	this.solde=solde;
    	this.listeOperations=new ArrayList<>();
    	
    }
   
	
	public String getcode() {
		return code;
	}
	public Double getsolde() {
		return solde;
	}
	
	public void setCode(String code) {
        this.code = code;
    }
	public void setsolde(Double Solde) {
		this.solde=Solde;
	}
	public List<operation> getListeOperations() {
        return new ArrayList<>(listeOperations);
    }
	
	
	
	public void ajouterOperation(operation operation) {
        this.listeOperations.add(operation);
    }
	
	public abstract boolean  retirerCompte(Double montant,String destination);
	public abstract Double calculerInteret();
	public abstract void afficherDetails();
	
	
	
	
	
	
	
	
}
