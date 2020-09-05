package launcher;

import service.CurrecyExchangeService;

import java.time.LocalDate;
import java.util.Scanner;

public class ExchangeLauncher {

    public static void main(String[] args) {
        int flag;
        String currencyCode = null;
        String amount = null;
        LocalDate exchangeRateDate = null;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Wybierz czynność:");
            System.out.println("1- Przelicz złotówki na inną walutę");
            System.out.println("2- Przelicz inną walutę na złotówki");
            System.out.println("9- Wyjście");
            flag = scan.nextInt();

            if (flag != 9) {
                System.out.println("Podaj trzy literowy kod waluty:");
                currencyCode = scan.next();
                System.out.println("Podaj sumę do przeliczenia:");
                amount = scan.next();
                System.out.println("Podaj datę z której pobiorę kurs " + currencyCode);
                System.out.print("Rok: ");
                int year = scan.nextInt();
                System.out.print("Miesiąc: ");
                int month = scan.nextInt();
                System.out.print("Dzień: ");
                int day = scan.nextInt();
                exchangeRateDate = LocalDate.of(year, month, day);
            }

            switch (flag) {
                case 2: {
                    System.out.println(CurrecyExchangeService.exchangeToPLNFrom(amount, currencyCode, exchangeRateDate));
                    break;
                }
                case 1: {
                    System.out.println(CurrecyExchangeService.exchangeFromPLNto(amount, currencyCode, exchangeRateDate));
                    break;

                }
                default: {
                }
            }

        } while (flag != 9);


    }
}
