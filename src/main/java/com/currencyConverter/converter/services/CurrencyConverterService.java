package com.currencyConverter.converter.services;

import com.currencyConverter.converter.exceptions.CurrencyConversionClientException;
import com.currencyConverter.converter.exceptions.CurrencyConversionException;
import com.currencyConverter.converter.exceptions.CurrencyConversionServerException;
import com.currencyConverter.converter.models.CurrencyRequest;
import com.currencyConverter.converter.util.CurrencyConversionUtil;
import com.currencyConverter.converter.util.GeneralValidationUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyConverterService {

    private final RestTemplate restTemplate;


    @Autowired
    public CurrencyConverterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String convertCurrency(CurrencyRequest request) {
        Double amount = request.getAmount();
        String toCurrency = request.getToCurrency();
        GeneralValidationUtil.validateRequest(request);
        String url = CurrencyConversionUtil.getUrlWithCurrencyConversion(request);

        try {
            ResponseEntity<String> response
                    = restTemplate.getForEntity(url, String.class);

            JSONObject jsonObject = new JSONObject(response.getBody());
            double result = jsonObject.getDouble(toCurrency.toLowerCase());
            return  CurrencyConversionUtil.formatCurrency(amount * result,toCurrency.toUpperCase());
        } catch (HttpClientErrorException e) {
            throw new CurrencyConversionClientException("Client error while calling currency conversion API", e);
        } catch (RestClientException e) {
            throw new CurrencyConversionServerException("Server error or issue with RestTemplate while calling currency conversion API", e);
        } catch (Exception e) {
            throw new CurrencyConversionException("An error occurred while calling currency conversion API", e);
        }
    }
}
