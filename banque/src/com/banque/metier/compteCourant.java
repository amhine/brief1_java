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
	

}
