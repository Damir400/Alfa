package Aplication;


import Aplication.damir.GifClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping ("gg")
public class GifController {
    private GifClient gifClient;

    @Autowired
    public GifController(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    @GetMapping("getgif")
    public ResponseEntity<Map> gifRates(){
        ResponseEntity<Map> result = gifClient.getRandomGif();
        return result;
    }
}
