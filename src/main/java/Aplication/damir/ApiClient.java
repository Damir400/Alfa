package Aplication.damir;

import Aplication.damir.model.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "jsonrates", url = "https://openexchangerates.org/api")
public interface ApiClient {


//    @GetMapping("/latest.json")
//    ExchangeRates getTodayRates(
//            @RequestParam("app_id") String appId
//    );

    //@GetMapping("/latest.json")
    @GetMapping( "/latest.json")  //method = RequestMethod.GET, value =
    ExchangeRates getTodayRates(
            @RequestParam("app_id") String appId
    );

//    @RequestMapping(method = RequestMethod.GET, value = "/latest.json")
//    String getTodayRates(
//            @RequestParam("app_id") String appId
//    );


    @GetMapping("/historical/{date}.json")
    ExchangeRates getHistoricalRates(
            @PathVariable String date,
            @RequestParam("app_id") String appId
    );

//    @RequestMapping(method = GET, value = "/", consumes = APPLICATION_JSON_VALUE)
//    List<Post> getPosts(@RequestParam("_limit") final int postLimit);
//
//    @RequestMapping(method = POST, value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    Post savePost(@RequestBody Post post);
}

