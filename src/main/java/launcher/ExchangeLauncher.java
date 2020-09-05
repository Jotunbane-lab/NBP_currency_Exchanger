package launcher;

import service.CurrecyExchangeService;

import java.util.Scanner;

public class ExchangeLauncher {

    public static void main(String[] args) {
        int flag;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Wybierz czynność:");
            System.out.println("1- Przelicz złotówki na inną walutę, po ostatnim kursie");
            System.out.println("2- Przelicz inną walutę na złotówki, po ostatnim kursie");
            System.out.println("9- Wyjście");
            flag = scan.nextInt();
            switch (flag) {
                case 1: {
                    System.out.println(CurrecyExchangeService.exchangeFromPLN());
                }
                case 2: {
                    CurrecyExchangeService.exchangeToPLN();
                }
                default: {
                }
            }

        } while (flag != 9);


    }
}
