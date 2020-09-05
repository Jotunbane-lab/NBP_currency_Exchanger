package exchanger;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;


class NbpExchangeRateDownloaderTest {
    NbpExchangeRateDownloader subject;

    @BeforeEach
    public void setup() {
        subject = NbpExchangeRateDownloader.getInstance();
    }

    @Test
    public void DownloaderShoudWorkOnWorkDays() {


        //given
        String validCurrencyCode = "EUR";
        LocalDate validLocalDate = LocalDate.of(2020, 9, 4);
        int expectedResponseCode = 200;

        //when
        NbpExchangeRateResult result = subject.check(validCurrencyCode, validLocalDate);

        //then
        assertEquals(result.getResponseCode(), expectedResponseCode);
    }

    @Test
    public void DownloaderRecognizeInvalidDateRange1() {
        //given
        String validCurrencyCode = "EUR";
        LocalDate invalidLocalDate = LocalDate.of(2025, 9, 4);
        int expectedResponseCode = 400;

        //when
        NbpExchangeRateResult result = subject.check(validCurrencyCode, invalidLocalDate);

        //then
        assertEquals(result.getResponseCode(), expectedResponseCode);
    }

    @Test
    public void DownloaderRecognizeInvalidDateRange2() {
        //given
        String validCurrencyCode = "EUR";
        LocalDate invalidLocalDate = LocalDate.of(1900, 9, 4);
        String expectedResponseMessageElement = "No data available";

        //when
        NbpExchangeRateResult result = subject.check(validCurrencyCode, invalidLocalDate);

        //then
        assertTrue(result.getErrorMessage().contains(expectedResponseMessageElement));
    }
    @Test
    public void DownloaderWontWorkOnHolidays() {
        //given
        String validCurrencyCode = "EUR";
        LocalDate invalidLocalDate = LocalDate.of(2020, 8, 30);
        String expectedResponseMessageElement = "Not Found";

        //when
        NbpExchangeRateResult result = subject.check(validCurrencyCode, invalidLocalDate);

        //then
        assertTrue(result.getErrorMessage().contains(expectedResponseMessageElement));
    }

    @Test
    public void DownloaderCantRecognizeInvalidCurrencyCode(){

        //given
        String invalidCurrencyCode = "Rww";
        LocalDate validLocalDate = LocalDate.of(2020, 9, 4);
        int expectedResponseCode = 404;

        //when
        NbpExchangeRateResult result = subject.check(invalidCurrencyCode, validLocalDate);

        //then
        assertEquals(result.getResponseCode(), expectedResponseCode);

    }
}