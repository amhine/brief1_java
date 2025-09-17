package com.banque.metier;



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class compte {
	
	
	private String code;
	private Double solde;
	private List<operation> listeOperations;
	private static final Pattern CODE_PATTERN = Pattern.compile("^CPT-\\d{5}$");
	
    public compte(String code, Double solde) {
    	if (!isValidCode(code)) {
            throw new CodeInvalideException("Le code doit respecter format CPT-12345");
        }
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
	public void SetSolde(Double Solde) {
		this.solde=Solde;
	}
	public List<operation> getListeOperations() {
        return new ArrayList<>(listeOperations);
    }
	public void ajouterOperation(operation operation) {
        this.listeOperations.add(operation);
    }
	
	public abstract void retirerCompte(Double montant,String destination);
	public abstract Double calculerInteret();
	public abstract void afficherDetails();
	
	
	
	
	
	
	
	
}
