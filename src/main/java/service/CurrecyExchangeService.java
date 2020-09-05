package service;

import exchanger.NbpExchangeRateDownloader;
import exchanger.NbpExchangeRateResult;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class CurrecyExchangeService {


    public static ExchangeResult exchangeFromPLN(int amount, String currencyCode, LocalDate date) {
        Scanner scan = new Scanner(System.in);
        NbpExchangeRateDownloader nERDL = NbpExchangeRateDownloader.getInstance();
        BigDecimal res = BigDecimal.ZERO;

        NbpExchangeRateResult rate = nERDL.check(currencyCode, date);
        if (rate.getResponseCode() == 200) {
            res = ((rate.getSeries().getRates().get(0).getMid()).multiply(BigDecimal.valueOf(amount)));
        }


        return new ExchangeResult(res, rate.getResponseCode(), rate.getErrorMessage());
    }

    public static ExchangeResult exchangeToPLN(int amount, String currencyCode) {

        return null;

    }
}
