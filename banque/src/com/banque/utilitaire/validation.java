package com.banque.utilitaire;

import java.util.regex.Pattern;

public final class validation {

    private static final Pattern CODE_PATTERN = Pattern.compile("^CPT-\\d{5}$");
    private validation() {}

    public static boolean isValidCompteCode(String code) {
        if (code == null) return false;
        return CODE_PATTERN.matcher(code.trim()).matches();
    }

    public static void ValidCompteCode(String code) {
        if (!isValidCompteCode(code)) {
            throw new IllegalArgumentException("Code de compte invalide. Format attendu: CPT-12345");
        }
    }
    public static void validateMontantPositif(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif.");
        }
    }
}
