package Aplication.damir.service;

import Aplication.damir.Client.GifClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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


    // Получаем ответ от Giphy.com в виде ResponseEntity<Map>
    public ResponseEntity<Map> getRandomGif(@PathVariable(value = "isRich") Boolean isRich){
        ResponseEntity<Map> result;
        if(isRich){
             result = gifClient.getRandomGif(apiKey, tagRich);
             result.getBody().put("tag","rich");
        }
        else {
            result = gifClient.getRandomGif(apiKey, tagBroke);
            result.getBody().put("tag","broke");
        }
        return result;
    }


}
