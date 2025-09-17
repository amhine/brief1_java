package com.banque.metier;


import java.time.LocalDateTime;
import java.util.UUID;

public abstract class operation {
	
	private String numero;
	private LocalDateTime  date;
	private Double montant;
	
	
	public operation ( Double montant) {
		this.numero=UUID.randomUUID().toString();
		this.date=LocalDateTime.now();
		this.montant=montant;
	}
	
	public String getnumero() {
		return numero;
	}
	
	public LocalDateTime getdate() {
		return date;
	}
	public Double getmontant() {
		return montant;
	}

	
	public abstract void afficherDetails();
    public abstract String getType();
    public void afficherDetailsBase() {
        System.out.println("Numéro: " + numero);
        System.out.println("Date: " + date);
        System.out.println("Montant: " + montant + "dh");
    }
	
	
	
	

}
