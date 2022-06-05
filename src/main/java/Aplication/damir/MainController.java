package Aplication.damir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("api")
public class MainController {
    private GifService gifService;
    private ExchangeRatesService exchangeRatesService;

    public MainController(GifService gifService, ExchangeRatesService exchangeRatesService) {
        this.gifService = gifService;
        this.exchangeRatesService = exchangeRatesService;
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

    @GetMapping("/getgif/{coderates}")
    public ResponseEntity<Map> getRandomGif(@PathVariable(value = "coderates") String codeRates) {
        return gifService.gifRates(exchangeRatesService.compareRatesResult(codeRates));
    }



}
