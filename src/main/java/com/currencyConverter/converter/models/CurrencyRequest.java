package com.currencyConverter.converter.models;

public class CurrencyRequest {
    private String fromCurrency;
    private String toCurrency;
    private Double amount;
    private String apiVersion;

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CurrencyRequest{" +
                "fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", amount=" + amount +
                ", apiVersion='" + apiVersion + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    // Constructors
    public CurrencyRequest() {
    }

    public CurrencyRequest(String fromCurrency, String toCurrency, Double amount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
    }

    // Getters and Setters
    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
