package com.banque.metier;

import java.time.LocalDateTime;

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
	        return "Versement {" +
	               "numero='" + getnumero() + '\'' +
	               ", date=" + getdate() +
	               ", montant=" + getmontant() + " dh" +
	               ", source='" + source + '\'' +
	               '}';
	    }
	   
}
