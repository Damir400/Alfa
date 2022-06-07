package Aplication.damir.service;

import Aplication.damir.Client.ApiClient;
import Aplication.damir.model.ExchangeRates;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class ExchangeRatesServiceTest {

    private ExchangeRates yesterdayRates;
    private ExchangeRates todayRates;
    @Autowired
    private ExchangeRatesService exchangeRatesService;
    @MockBean
    private ApiClient apiClient;

    // R1 - уменьшается
    // R2 - увеличивается
    @Before
    public void create(){
        this.todayRates = new ExchangeRates();
        this.todayRates.setDisclaimer("https://openexchangerates.org/terms/");
        this.todayRates.setLicense("https://openexchangerates.org/license/");
        this.todayRates.setTimestamp(1654563827);
        this.todayRates.setBase("USD");
        Map<String,Double> todayRates = new HashMap<>();
        todayRates.put("R1",1.14);
        todayRates.put("R2",3.15);
        this.todayRates.setRates(todayRates);

        this.yesterdayRates = new ExchangeRates();
        this.yesterdayRates.setDisclaimer("https://openexchangerates.org/terms/");
        this.yesterdayRates.setLicense("https://openexchangerates.org/license/");
        this.yesterdayRates.setTimestamp(1654563827);
        this.yesterdayRates.setBase("USD");
        Map<String,Double> yesterdayRates = new HashMap<>();
        yesterdayRates.put("R1",2.14);
        yesterdayRates.put("R2",2.15);
        this.yesterdayRates.setRates(yesterdayRates);
    }


    @Test
    public void compareRatesResultPositive() {
        Mockito.when(apiClient.getTodayRates(anyString())).thenReturn(this.todayRates);
        Mockito.when(apiClient.getHistoricalRates(anyString(),anyString())).thenReturn(this.yesterdayRates);
        boolean result = exchangeRatesService.compareRatesResult("R2");
        assertEquals(true,result);
    }

        @Test
        public void compareRatesResultNegative() {
            Mockito.when(apiClient.getTodayRates(anyString())).thenReturn(this.todayRates);
            Mockito.when(apiClient.getHistoricalRates(anyString(),anyString())).thenReturn(this.yesterdayRates);
            boolean result = exchangeRatesService.compareRatesResult("R1");
            assertEquals(false,result);
        }


    @Test
    public void getRatesCodes() {
        Mockito.when(apiClient.getTodayRates(anyString())).thenReturn(this.todayRates);
        Mockito.when(apiClient.getHistoricalRates(anyString(),anyString())).thenReturn(this.yesterdayRates);
        List<String> result = exchangeRatesService.getRatesCodes();
        assertThat(result, containsInAnyOrder("R1","R2"));
    }
}