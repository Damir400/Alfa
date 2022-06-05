package Aplication.damir;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "jsongif", url = "https://api.giphy.com/v1/gifs")
public interface GifClient {

    @GetMapping("/random?search?q=rich&api_key=TxS7uE91W8Jb32wTs8SWCTBC8d7rlf5L&limit=5")
    ResponseEntity<Map> getRandomGif(     //получение гифки rich
            //@RequestParam("api_key") String apiKey,
            //@RequestParam("tag") String tag
    );
}
