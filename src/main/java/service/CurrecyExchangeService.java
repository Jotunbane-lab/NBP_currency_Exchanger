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

        NbpExchangeRateResult rate = nERDL.check(currencyCode);
        BigDecimal res = ((rate.getSeries().getRates().get(0).getMid()).multiply(BigDecimal.valueOf(amount)));


        return new ExchangeResult(res,rate.getResponseCode(),rate.getErrorMessage());
    }

    public static ExchangeResult exchangeToPLN() {

        return null;
    }
}
