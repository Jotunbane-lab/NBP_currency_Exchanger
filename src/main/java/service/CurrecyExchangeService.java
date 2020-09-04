package service;

import java.util.Scanner;

public class CurrecyExchangeService {

    public static ExchangeResult exchangeFromPLN() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj trzy literowy kod waluty:");
        String currencyCode = scan.nextLine();
        System.out.println("Podaj sumę do przeliczenia:");
        int amount = scan.nextInt();

        return null;
    }

    public static ExchangeResult exchangeToPLN() {

        return null;
    }
}
