package Aplication.damir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gg")
//@RequestMapping("https://openexchangerates.org/api/getcodes")

public class ExchangeRatesController {

    private ExchangeRatesService exchangeRatesService;
    private ApiClient apiClient;

    @Autowired
    public ExchangeRatesController(ExchangeRatesService exchangeRatesService, ApiClient apiClient) {
        this.exchangeRatesService = exchangeRatesService;
        this.apiClient = apiClient;
    }

    @GetMapping("/getcodes")
    public String getRates() {


//        ExchangeRates exchangeRates =  exchangeRatesService.getExchangeRates();
//        System.out.println(exchangeRates.getBase());
        //System.out.println(exchangeRatesService.getExchangeRates());

        //return ResponseEntity.ok(apiClient.getTodayRates("app_id=e4a8bc487fb6427c8a37e4784deea896").get(0));
        //return exchangeRatesService.getExchangeRates();
        return "qeqeqwe";
    }

}
