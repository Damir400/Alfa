package Aplication.damir.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "jsongif", url = "https://api.giphy.com/v1/gifs")
public interface GifClient {

    @GetMapping("/random")
    ResponseEntity<Map> getRandomGif(     //получение гифки
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag
    );
}
