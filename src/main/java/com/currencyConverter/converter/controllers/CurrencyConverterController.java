package com.currencyConverter.converter.controllers;


import com.currencyConverter.converter.models.CurrencyRequest;
import com.currencyConverter.converter.services.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterService currencyConverterService;

    @GetMapping("/")
    public String currencyForm(Model model) {
        model.addAttribute("currencyRequest", new CurrencyRequest());
        return "currency-converter";
    }

    @PostMapping("/convert")
    public String convertCurrency(CurrencyRequest request, Model model) {
        try {
            String result = currencyConverterService.convertCurrency(request);
            model.addAttribute("message", "Converted Amount: " + result);
        } catch (Exception e) {
            model.addAttribute("error", "Error: " + e.getMessage());
        }
        return "currency-converter";
    }
}
