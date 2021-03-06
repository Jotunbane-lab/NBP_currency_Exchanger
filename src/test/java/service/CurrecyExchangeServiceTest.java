package service;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CurrecyExchangeServiceTest {

    @Test
    public void CurrencyExchangeServiceExchangesValidCurrencies() {
//        given
        String validAmount = "10";
        String validCurrencyCode = "EUR";
        LocalDate validDate = LocalDate.of(2020, 9, 4);

        BigDecimal expectedValue = new BigDecimal("44.5080");
//        when
        ExchangeResult result = CurrecyExchangeService.exchangeToPLNFrom(validAmount, validCurrencyCode, validDate);
//        then
        assertEquals(expectedValue, result.getResult());
    }

    @Test
    public void CurrencyExchangeServiceRecognizeInvalidCurrencies() {
        //given
        String validAmount = "10";
        String invalidCurrencyCode = "Rww";
        LocalDate validDate = LocalDate.of(2020, 9, 4);
        int expectedResponseCode = 404;

        //when
        ExchangeResult result = CurrecyExchangeService.exchangeToPLNFrom(validAmount, invalidCurrencyCode, validDate);

        //then
        assertEquals(result.getResponseCode(), expectedResponseCode);
    }

}