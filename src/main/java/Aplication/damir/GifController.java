package Aplication.damir;


// @RestController
   // @RequestMapping("/payment")
    public class GifController  {private final String sharedKey = "SHARED_KEY";

//
//        //private static final String GIF = "http://api.giphy.com/v1/gifs/search?q=ryan+gosling&api_key=TxS7uE91W8Jb32wTs8SWCTBC8d7rlf5L&limit=5";
//        private static final String SUCCESS_STATUS = "success";
//        private static final String ERROR_STATUS = "error";
//        private static final int CODE_SUCCESS = 100;
//        private static final int AUTH_FAILURE = 102;
//
//        @GetMapping
//        public BaseResponse showStatus() {
//            return new BaseResponse(SUCCESS_STATUS, 1);
//        }
//
//       // @PostMapping("/pay")
//        public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
//
//            final BaseResponse response;
//
//            if (sharedKey.equalsIgnoreCase(key)) {
//                int userId = request.getUserId();
//                String itemId = request.getItemId();
//                double discount = request.getDiscount();
//                // Process the request
//                // ....
//                // Return success response to the client.
//                response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
//            } else {
//                response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
//            }
//            return response;
//        }

}
