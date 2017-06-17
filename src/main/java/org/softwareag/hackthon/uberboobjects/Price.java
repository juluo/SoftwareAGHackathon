package org.softwareag.hackthon.uberboobjects;

/**
 * Created by rvignesh on 6/17/2017.
 */

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {

    @JsonProperty("localized_display_name")
    private String localizedDisplayName;
    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("high_estimate")
    private double highEstimate;
    @JsonProperty("low_estimate")
    private double lowEstimate;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("estimate")
    private String estimate;
    @JsonProperty("currency_code")
    private Object currencyCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("localized_display_name")
    public String getLocalizedDisplayName() {
        return localizedDisplayName;
    }

    @JsonProperty("localized_display_name")
    public void setLocalizedDisplayName(String localizedDisplayName) {
        this.localizedDisplayName = localizedDisplayName;
    }

    @JsonProperty("distance")
    public Double getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("display_name")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("product_id")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("product_id")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("high_estimate")
    public double getHighEstimate() {
        return highEstimate;
    }

    @JsonProperty("high_estimate")
    public void setHighEstimate(double highEstimate) {
        this.highEstimate = highEstimate;
    }

    @JsonProperty("low_estimate")
    public double getLowEstimate() {
        return lowEstimate;
    }

    @JsonProperty("low_estimate")
    public void setLowEstimate(double lowEstimate) {
        this.lowEstimate = lowEstimate;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("estimate")
    public String getEstimate() {
        return estimate;
    }

    @JsonProperty("estimate")
    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    @JsonProperty("currency_code")
    public Object getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currency_code")
    public void setCurrencyCode(Object currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return "Price{" +
                "localizedDisplayName='" + localizedDisplayName + '\'' +
                ", distance=" + distance +
                ", displayName='" + displayName + '\'' +
                ", productId='" + productId + '\'' +
                ", highEstimate=" + highEstimate +
                ", lowEstimate=" + lowEstimate +
                ", duration=" + duration +
                ", estimate='" + estimate + '\'' +
                ", currencyCode=" + currencyCode +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

