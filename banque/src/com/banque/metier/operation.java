package com.banque.metier;


import java.time.LocalDateTime;
import java.util.UUID;

public abstract class operation {
	
	private String numero;
	private LocalDateTime  date;
	private double montant;
	
	
	public operation ( double montant) {
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
	public void setmontant(double montant) {
        this.montant = montant;
    }

	@Override
    public String toString() {
        return "Opération #" + numero + 
               " - Date: " + date.toLocalDate() + 
               " - Montant: " + montant + " dh";
    }
	 
	
	
	
	

}
