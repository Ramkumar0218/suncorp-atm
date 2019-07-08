package net.cashman.base;

import net.cashman.suncorp.atm.ATMMeta;
import net.cashman.suncorp.atm.data.ATMBase;
import net.cashman.suncorp.atm.data.ATMDenomination;
import org.junit.Ignore;

import java.util.Map;


public class ATMTestBase extends ATMBase {
    private static ATMTestBase instance = null;

    private ATMTestBase(Map<ATMDenomination, Integer> quantities) {
        super(quantities);
    }

    public static ATMTestBase getNewInstance(final ATMMeta atmMeta) {
        ATMTestBase.instance = new ATMTestBase(atmMeta.getDefaults());
        return ATMTestBase.instance;
    }
}
