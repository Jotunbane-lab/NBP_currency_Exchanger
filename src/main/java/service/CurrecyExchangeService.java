package service;

import exchanger.NbpExchangeRateDownloader;
import exchanger.NbpExchangeRateResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;

public class CurrecyExchangeService {


    public static ExchangeResult exchangeToPLNFrom(String amount, String currencyCode, LocalDate date) {
        Scanner scan = new Scanner(System.in);
        NbpExchangeRateDownloader nERDL = NbpExchangeRateDownloader.getInstance();
        BigDecimal res = BigDecimal.ZERO;

        NbpExchangeRateResult rate = nERDL.check(currencyCode, date);
        if (rate != null) {
            if (rate.getResponseCode() == 200) {
                res = ((rate.getSeries().getRates().get(0).getMid()).multiply(new BigDecimal(amount)));
            }


            return new ExchangeResult(res, rate.getResponseCode(), rate.getErrorMessage());
        } else return new ExchangeResult(res, 500, "Unable to Connect");
    }

    public static ExchangeResult exchangeFromPLNto(String amount, String currencyCode, LocalDate date) {
        Scanner scan = new Scanner(System.in);
        NbpExchangeRateDownloader nERDL = NbpExchangeRateDownloader.getInstance();
        BigDecimal res = BigDecimal.ZERO;

        NbpExchangeRateResult rate = nERDL.check(currencyCode, date);
        if (rate != null) {
            if (rate.getResponseCode() == 200) {

                res = (new BigDecimal(amount).divide((rate.getSeries().getRates().get(0).getMid()), 2, RoundingMode.DOWN));
            }


            return new ExchangeResult(res, rate.getResponseCode(), rate.getErrorMessage());
        } else return new ExchangeResult(res, 500, "Unable to Connect");
    }
}
