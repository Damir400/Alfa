package Aplication.damir.service;

import Aplication.damir.Client.ApiClient;
import Aplication.damir.model.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    public ExchangeRates getExchangeRates(){
        //return apiClient.getTodayRates(appId);
        exchangeRates = apiClient.getTodayRates(appId);
        return exchangeRates;

    }

    public ExchangeRates getExchangeRatesYesterday(){
        //return apiClient.getTodayRates(appId);
        exchangeRates = apiClient.getHistoricalRates(getYesterdayDate(),appId);
        return exchangeRates;

    }

    public String getYesterdayDate()  {

        LocalDate date = LocalDate.now().minusDays(4); // не забыть исправить на 1

        return date.toString();
    }

    public boolean compareRatesResult(String rate){
        Double todayRate = getExchangeRates().getRates().get(rate);
        Double yesterdayRate = getExchangeRatesYesterday().getRates().get(rate);
        return todayRate-yesterdayRate>0;
    }
}
