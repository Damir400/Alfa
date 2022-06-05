package Aplication.damir.Controller;


import Aplication.damir.Client.GifClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping ("gg")
public class GifController {
    private GifClient gifClient;
    @Value("${giphy.api.key}")
    private String apiKey;
    @Value("${giphy.rich}")
    private String tagRich;
    @Value("${giphy.broke}")
    private String tagBroke;

    @Autowired
    public GifController(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    @GetMapping("/getgif/{isRich}")
    public ResponseEntity<Map> gifRates(@PathVariable(value = "isRich") Boolean isRich){

        ResponseEntity<Map> result;
        if(isRich){
            result = gifClient.getRandomGif(apiKey, tagRich);
        }
        else {
             result = gifClient.getRandomGif(apiKey,tagBroke);

        }

        return result;
    }
}
