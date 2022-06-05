package Aplication.damir;

import Aplication.damir.model.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Service
public class GifService {
    private GifClient gifClient;

    @Value("${giphy.api.key}")
    private String apiKey;
    @Value("${giphy.rich}")
    private String tagRich;
    @Value("${giphy.broke}")
    private String tagBroke;

    @Autowired
    public GifService(GifClient gifClient) {
        this.gifClient = gifClient;
    }


    //@GetMapping("/getgif/{isRich}")
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
