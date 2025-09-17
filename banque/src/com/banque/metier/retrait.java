package com.banque.metier;

public class retrait extends operation{
	
	private String destination;

	public retrait(Double montant , String destination) {
		super(montant);
		this.destination=destination;
		
	}
	public String getdestination() {
		return destination;
	}
	
}
