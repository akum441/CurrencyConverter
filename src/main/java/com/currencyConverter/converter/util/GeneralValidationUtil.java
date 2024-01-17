package com.currencyConverter.converter.util;

import com.currencyConverter.converter.models.CurrencyRequest;

public class GeneralValidationUtil {
    public static void validateRequest(CurrencyRequest request) {
        CurrencyConversionUtil.validateAllowedCurrencies(request);
    }
}
