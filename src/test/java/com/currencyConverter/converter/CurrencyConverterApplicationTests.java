package com.currencyConverter.converter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue; // Import the assertTrue method
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals; // Import the correct assertEquals method

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyConverterApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCurrencyConversion() throws Exception {
        // Create a sample JSON request body
        String requestBody = "{\"fromCurrency\":\"USD\",\"toCurrency\":\"EUR\",\"amount\":100.0}";

        // Perform a POST request to the /api/currency/convert endpoint
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/currency/convert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andReturn();

        // Verify the response status code (200 OK in this case)
        int status = result.getResponse().getStatus();
        assertEquals(200, status); // Use the correct assertEquals method

        // Verify the response content (you may need to adjust this based on your actual response format)
        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains("convertedAmount"));

        // Add more assertions as needed to verify the response content
    }
}
