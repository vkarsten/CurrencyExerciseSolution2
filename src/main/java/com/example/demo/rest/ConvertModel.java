package com.example.demo.rest;

public class ConvertModel {
    private String firstCurrency;
    private String otherCurrency;
    private Double amount;
    private Double convertedAmount;

    public ConvertModel() {
    }

    public ConvertModel(String firstCurrency, String otherCurrency, Double amount, Double convertedAmount) {
        this.firstCurrency = firstCurrency;
        this.otherCurrency = otherCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    public String getFirstCurrency() {
        return firstCurrency;
    }

    public void setFirstCurrency(String firstCurrency) {
        this.firstCurrency = firstCurrency;
    }

    public String getOtherCurrency() {
        return otherCurrency;
    }

    public void setOtherCurrency(String otherCurrency) {
        this.otherCurrency = otherCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
