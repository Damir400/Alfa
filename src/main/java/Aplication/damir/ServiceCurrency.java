package com.damir.service;

import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
@Value
@NoArgsConstructor
public class ServiceCurrency {

    public boolean isTodayRateBiggerThanHistorical(Double todayRate, Double historicalRate){
        return todayRate > historicalRate;
    }

}
