package net.cashman.suncorp.atm.rest;

import net.cashman.suncorp.atm.services.ATMService;
import net.cashman.suncorp.atm.services.dto.ATMDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atm")
public class ATMController {

    @Autowired
    private ATMService atmService;

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ATMDto withdrawMoney(@RequestParam(name = "amount") final Double amount) {
        return atmService.withdrawMoney(amount);
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean depositMoney(@RequestBody final ATMDto amounts) {
        return atmService.depositMoney(amounts);
    }
}
