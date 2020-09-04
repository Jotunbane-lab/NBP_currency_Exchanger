package launcher;

import java.util.Scanner;

public class ExchangeLauncher {

    public static void main(String[] args) {
        int flag;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Wybierz cznność:");
            System.out.println("1- Przelicz złotówki na inną walutę");
            System.out.println("2- Przelicz inną walutę na złotówki");
            System.out.println("9- Wyjście");
            flag = scan.nextInt();
            switch (flag){
                case 1:{

                }
                case 2:{
            }
                default:{}
            }

        }while (flag!=9);


    }
}
