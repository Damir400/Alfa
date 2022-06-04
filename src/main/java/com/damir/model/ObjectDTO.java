package com.damir.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDTO {


    @JsonProperty(value = "disclaimer")
    private String disclaimer;
    @JsonProperty(value = "license")
    private String license;
    @JsonProperty(value = "timestamp")
    private Integer timestamp;
    @JsonProperty(value = "base")
    private String base;
    @JsonProperty(value = "rates")
    private Map<String, Double> rates;

    public String toString() {
        return String.format("\n disclaimer: %s \n license: %s \n timestamp: %s \n base: %s \n rates: %s \n", disclaimer, license, timestamp, base, rates);
    }
}
