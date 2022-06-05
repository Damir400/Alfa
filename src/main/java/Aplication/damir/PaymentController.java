package Aplication.damir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

   private final String EXCHANGE_URL = "https://openexchangerates.org/api/latest.json?app_id=e4a8bc487fb6427c8a37e4784deea896";
   private final String EXCHANGE_URL_2 = "https://openexchangerates.org/api/historical/2022-06-04.json?app_id=e4a8bc487fb6427c8a37e4784deea896";
   private final String GIF_URL_RICH = "https://api.giphy.com/v1/gifs/random?search?q=rich&api_key=TxS7uE91W8Jb32wTs8SWCTBC8d7rlf5L&limit=5";
   private final String GIF_URL_BROKE = "https://api.giphy.com/v1/gifs/random?search?q=broke&api_key=TxS7uE91W8Jb32wTs8SWCTBC8d7rlf5L&limit=5";

    @Autowired
    private final ServiceCurrency serviceCurrency = new ServiceCurrency();

//    @GetMapping("/{currency}")
//    public String showStatus(@PathVariable String currency) {
//        final RestTemplate restTemplate = new RestTemplate();
//        ObjectDTO objectDTOToday =  restTemplate.getForObject(EXCHANGE_URL, ObjectDTO.class);
//        Map<String, Double> mapToday = objectDTOToday.getRates();
//
//        final RestTemplate restTemplate2 = new RestTemplate();
//        ObjectDTO objectDTOYesterday =  restTemplate2.getForObject(EXCHANGE_URL_2, ObjectDTO.class);
//        Map<String, Double> mapYesterday = objectDTOYesterday.getRates();
//        final RestTemplate restTemplate3 = new RestTemplate();
//        if(serviceCurrency.isTodayRateBiggerThanHistorical(mapToday.get(currency), mapYesterday.get(currency))){
//            System.out.println("rich");
//            return restTemplate3.getForObject(GIF_URL_RICH, String.class);
//        } else {
//            System.out.println("broke");
//            return restTemplate3.getForObject(GIF_URL_BROKE, String.class);
//        }
//    }

//    @PostMapping("/payq1")
//    //@GetMapping("/pay")
//    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
//        //public BaseResponse pay(@RequestParam(value = "key") String key) {
//        final BaseResponse response;
//
//        if (sharedKey.equalsIgnoreCase(key)) {
//            int userId = request.getUserId();
//            String itemId = request.getItemId();
//            double discount = request.getDiscount();
//            // Process the request
//            // ....
//            // Return success response to the client.
//            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
//        } else {
//            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
//        }
//        return response;
//        //return showStatus();
   // }
}
