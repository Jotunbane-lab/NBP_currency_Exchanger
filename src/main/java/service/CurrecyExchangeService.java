package service;

import exchanger.NbpExchangeRateDownloader;
import exchanger.NbpExchangeRateResult;

import java.math.BigDecimal;
import java.util.Scanner;

public class CurrecyExchangeService {


    public static ExchangeResult exchangeFromPLN() {
        Scanner scan = new Scanner(System.in);
        NbpExchangeRateDownloader nERDL = NbpExchangeRateDownloader.getInstance();

        System.out.println("Podaj trzy literowy kod waluty:");
        String currencyCode = scan.nextLine();
        System.out.println("Podaj sumę do przeliczenia:");
        int amount = scan.nextInt();
        BigDecimal res = BigDecimal.ZERO;

        NbpExchangeRateResult rate = nERDL.check(currencyCode);
        if (rate.getResponseCode()==200) {
            res = ((rate.getSeries().getRates().get(0).getMid()).multiply(BigDecimal.valueOf(amount)));
       }


        return new ExchangeResult(res,rate.getResponseCode(),rate.getErrorMessage());
    }

    public static ExchangeResult exchangeToPLN() {
        Scanner scan = new Scanner(System.in);
        NbpExchangeRateDownloader nERDL = NbpExchangeRateDownloader.getInstance();

        System.out.println("Podaj sumę do przeliczenia:");
        int amount = scan.nextInt();
        System.out.println("Podaj jej trzy literowy kod waluty:");
        String currencyCode = scan.nextLine();

        BigDecimal res = BigDecimal.ZERO;

        NbpExchangeRateResult rate = nERDL.check(currencyCode);
        if (rate.getResponseCode()==200) {
            res = ((rate.getSeries().getRates().get(0).getMid()).multiply(BigDecimal.valueOf(amount)));
        }


        return new ExchangeResult(res,rate.getResponseCode(),rate.getErrorMessage());

    }
}
