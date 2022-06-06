package Aplication.damir.Controller;

import Aplication.damir.service.ExchangeRatesService;
import Aplication.damir.service.GifService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
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
    //Метод возвращает список кодов валют
    @GetMapping("/getcodes")
    public List<String> getRateCodes() {
        return exchangeRatesService.getRatesCodes();
    }

    //Метод возвращает 1 рандомную гифку в зависимости от разницы курса валют
    @GetMapping("/getgif/{coderates}")
    public ResponseEntity<Map> getRandomGif(@PathVariable(value = "coderates") String codeRates)  {

        return gifService.getRandomGif(exchangeRatesService.compareRatesResult(codeRates));
    }



}
