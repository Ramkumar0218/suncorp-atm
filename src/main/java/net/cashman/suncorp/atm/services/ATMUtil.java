package net.cashman.suncorp.atm.services;

import net.cashman.suncorp.atm.data.ATMDenomination;

import java.util.Map;

public final class ATMUtil {

    private ATMUtil() {
    }

    public static double calculateTotalValue(final Map<ATMDenomination, Integer> notes) {
        double total = 0;
        for (ATMDenomination denomination : notes.keySet()) {
            total += (notes.get(denomination) * denomination.getNominalValue());
        }
        return total;
    }

}
