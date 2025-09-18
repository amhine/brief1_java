package com.banque.metier;

public class virsement extends operation{
	
	private String source;
	
	public virsement (double montant , String source) {
		super(montant);
		this.source=source;
	}

	public String getsource() {
		return source;
	}
	public void setsource(String source) {
        this.source = source;
    }
	
	 @Override
	    public String toString() {
	        return "VERSEMENT - " + super.toString() +
	        		" - Source: " + source;
	    }
	   
}
