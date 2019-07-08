package net.cashman.services;

import net.cashman.ATMTestConfiguration;
import net.cashman.base.ATMTestBase;
import net.cashman.suncorp.atm.data.ATMBase;
import net.cashman.suncorp.atm.data.ATMDenomination;
import net.cashman.suncorp.atm.services.ATMDenominations;
import net.cashman.suncorp.atm.services.ATMService;
import net.cashman.suncorp.atm.services.dto.ATMDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ATMTestConfiguration.class})
@WebAppConfiguration
@ActiveProfiles("test")
public class ATMServiceTest {

    private static final int TEN = 10;

    private ATMService service;
    private ATMBase base;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Before
    public void setup() {
        base = ATMTestBase.getNewInstance(ATMTestConfiguration.getTestMeta());
        service = new ATMService(new ATMDenominations(base), base, applicationEventPublisher);
    }

    @Test
    public void testATMServiceWithDraw10() throws Exception {

        double currentHolding = base.getTotalHolding();
        service.withdrawMoney(TEN);
        double secondHolding = base.getTotalHolding();
        Assert.assertEquals(currentHolding, secondHolding + TEN, 0);

    }

    @Test
    public void testATMServiceDeposit10() throws Exception {

        ATMDto dto = new ATMDto();
        dto.getTheMoney().put(ATMDenomination.TEN, 1);

        double currentHolding = base.getTotalHolding();
        service.depositMoney(dto);
        double thirdHolding = base.getTotalHolding();
        Assert.assertEquals(currentHolding, thirdHolding - TEN, 0);

    }

    @Test
    public void testATMServiceWithDraw200() throws Exception {

        double currentHolding = base.getTotalHolding();
        service.withdrawMoney(TEN);
        double secondHolding = base.getTotalHolding();
        Assert.assertEquals(currentHolding, secondHolding + TEN, 0);

    }

}
