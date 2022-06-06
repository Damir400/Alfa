package Aplication.damir.service;

import Aplication.damir.Client.ApiClient;
import Aplication.damir.model.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    //Получение сегодняшних котировок
    public ExchangeRates getExchangeRates(){
        exchangeRates = apiClient.getTodayRates(appId);
        return exchangeRates;
    }
    //Получение вчерашних котировок
    public ExchangeRates getExchangeRatesYesterday(){
        exchangeRates = apiClient.getHistoricalRates(getYesterdayDate(),appId);
        return exchangeRates;
    }
    // Получение вчерашней даты
    public String getYesterdayDate()  {
        LocalDate date = LocalDate.now().minusDays(1);
        return date.toString();
    }
    //Сравнение котировок за вчерашний и сегодняшний день
    public boolean compareRatesResult(String rate){
        Double todayRate = getExchangeRates().getRates().get(rate);
        Double yesterdayRate = getExchangeRatesYesterday().getRates().get(rate);
        return todayRate-yesterdayRate>0;
    }

    public List<String> getRatesCodes(){
        return new ArrayList<String>(getExchangeRates().getRates().keySet());
    }
}
