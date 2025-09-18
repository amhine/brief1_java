package com.banque.metier;

public class compteCourant extends compte{
	
	private Double decouvert;
	
	public compteCourant(String code, double solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }
	public double getDecouvert() {
        return decouvert;
    }
    
    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
	public boolean retirerCompte(Double montant,String destination) {
    	if (montant<=0) {
    		return false;
    	}
    	if(getsolde()-montant>=-decouvert) {
    		retrait retrait = new retrait(montant,destination);
    		this.setsolde(this.getsolde() - montant);
    		ajouterOperation(retrait);
    		return true;
    	}
    	return false;
    	
    	
    }
    
    @Override
    public  Double calculerInteret() {
    	return 0.0;
    }
    
    
    @Override
    public void afficherDetails() {
    	System.out.println(" Compte Courant");
    	System.out.println("Code" + getcode());
    	System.out.println("Solde" + getsolde());
    	System.out.println("Decouvert" + decouvert+ "dh");
    	System.out.println("Solde disponible" + (getsolde()-decouvert)+"dh");
    	System.out.println("");
    }
    
    
    
    


}
