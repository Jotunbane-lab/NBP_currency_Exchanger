package exchanger;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;




class NbpExchangeRateDownloaderTest {

    @Test
    public void DownloaderShoudWorkOnWorkDays() {
    NbpExchangeRateDownloader subject = NbpExchangeRateDownloader.getInstance();

        //given
        String rightCurrencyCode = "EUR";
        LocalDate rightLocalDate = LocalDate.of(2020,9,4);
        int rightResponseCode = 200;

        //when
        NbpExchangeRateResult result = subject.check(rightCurrencyCode, rightLocalDate);

        //then
        assertEquals(result.getResponseCode(),rightResponseCode);
    }
}