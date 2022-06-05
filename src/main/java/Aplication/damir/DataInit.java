package Aplication.damir;

import Aplication.damir.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInit {

    private ExchangeRatesService exchangeRatesService;

    @Autowired
    public DataInit(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

//    @PostConstruct
//    public void firstDataInit() {
//        exchangeRatesService.refreshRates();
//    }
}
