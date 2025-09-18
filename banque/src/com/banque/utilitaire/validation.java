package com.banque.utilitaire;


import java.util.regex.Pattern;
public final class validation {

	private static final Pattern CODE_PATTERN = Pattern.compile("^CPT-\\d{5}$");
	
}
