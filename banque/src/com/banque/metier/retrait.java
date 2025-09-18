package com.banque.metier;

public class retrait extends operation{
	
	private String destination;

	public retrait(double montant , String destination) {
		super(montant);
		this.destination=destination;
		
	}
	public String getdestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
        this.destination = destination;
    }
	 @Override
	    public String toString() {
	        return "Retrair - " + super.toString() + " - Destination: " + destination;
	    }
	
}
