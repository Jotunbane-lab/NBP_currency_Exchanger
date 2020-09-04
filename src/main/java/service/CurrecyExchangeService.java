package service;

import java.util.Scanner;

public class CurrecyExchangeService {

    public static void exchangeFromPLN() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj trzy literowy kod waluty:");
        String currencyCode = scan.nextLine();
        System.out.println("Podaj sumę do przeliczenia:");
        int amount = scan.nextInt();


    }

    public static void exchangeToPLN() {

    }
}
