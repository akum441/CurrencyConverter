package com.currencyConverter.converter.util;

import com.currencyConverter.converter.constants.CurrencyConstants;
import com.currencyConverter.converter.constants.EndPoints;
import com.currencyConverter.converter.exceptions.CurrencyNotSupportedException;
import com.currencyConverter.converter.models.CurrencyRequest;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CurrencyConversionUtil {
    public static boolean isCurrencyAllowed(String currency) {
        try {
            CurrencyConstants.AllowedCurrency.valueOf(currency.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static String getAllowedCurrencies() {
        return Arrays.stream(CurrencyConstants.AllowedCurrency.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "));
    }

    public static void validateAllowedCurrencies(CurrencyRequest request) {
        String fromCurrency = request.getFromCurrency();
        String toCurrency = request.getToCurrency();
        if (!isCurrencyAllowed(fromCurrency) || !isCurrencyAllowed(toCurrency)) {
            String allowedCurrencies = getAllowedCurrencies();
            throw new CurrencyNotSupportedException("Invalid currency. Only " + allowedCurrencies + " are allowed.");
        }
    }


    public static String getUrlWithCurrencyConversion(CurrencyRequest request){
        String fromCurrency = request.getFromCurrency();
        String toCurrency = request.getToCurrency();
        String date = request.getDate();
        String apiVersion = request.getApiVersion();


        String effectiveApiVersion = Optional.ofNullable(apiVersion)
                .filter(version -> !version.isEmpty())
                .orElse(CurrencyConstants.DEFAULT_API_VERSION);

        String effectiveDate = Optional.ofNullable(date)
                .filter(d -> !d.isEmpty())
                .orElse(CurrencyConstants.DEFAULT_DATE);

        String url = EndPoints.CURRENCY_API_BASE_URL + effectiveApiVersion +
                String.format(EndPoints.CURRENCY_CONVERSION, effectiveDate, fromCurrency.toLowerCase(), toCurrency.toLowerCase());

        return url;

    }

    public static String formatCurrency(double amount, String countryCode) {
        Locale locale;

        switch (countryCode) {
            case "INR":
                locale = new Locale("en", "IN"); // India (English)
                break;
            case "USD":
                locale = Locale.US; // United States (English)
                break;
            case "EUR":
                locale = Locale.GERMANY; // Germany (German)
                break;
            case "JPY":
                locale = Locale.JAPAN; // Japan (Japanese)
                break;
            default:
                return "Unsupported Country Code";
        }

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount);
    }
}
