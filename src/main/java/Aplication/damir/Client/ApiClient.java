package Aplication.damir.Client;

import Aplication.damir.model.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//Клиент для получения курсов валют

@FeignClient(name = "jsonrates", url = "${openexchangerates.url}")
public interface ApiClient {

    @GetMapping( "/latest.json")
    ExchangeRates getTodayRates(
            @RequestParam("app_id") String appId
    );

    @GetMapping("/historical/{date}.json")
    ExchangeRates getHistoricalRates(
            @PathVariable (value = "date") String date,
            @RequestParam("app_id") String appId
    );
}

