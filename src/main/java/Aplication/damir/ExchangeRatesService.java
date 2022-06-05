import com.damir.model.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRatesService {
    private ApiClient apiClient;
    private ExchangeRates exchangeRates;

    @Value("${openexchangerates.api.key}")
    private String appId;

    @Autowired
    public ExchangeRatesService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    //public ExchangeRates getExchangeRates(){
    public String getExchangeRates(){
        //return apiClient.getTodayRates(appId);
        exchangeRates = apiClient.getTodayRates(appId);
        return exchangeRates.getBase();

    }
}
