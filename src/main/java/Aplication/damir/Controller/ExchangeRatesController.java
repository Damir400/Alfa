package Aplication.damir.Controller;

import Aplication.damir.Client.ApiClient;
import Aplication.damir.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public Map<String, Double> getRates() {
        return exchangeRatesService.getExchangeRates().getRates();
    }

    @GetMapping("/getcodesyesterday")
    public Map<String, Double> getHistoricalRates() {
        return exchangeRatesService.getExchangeRatesYesterday().getRates();
    }


    @GetMapping("/{coderates}")
    public Boolean getBool(@PathVariable(value = "coderates") String codeRates) {
        return exchangeRatesService.compareRatesResult(codeRates);
    }

}
