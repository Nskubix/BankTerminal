package bank;
import java.io.*;
import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;



public class MainBank {
    public static void main(String[] args) {
        int wybor = 0;
        AccountManager manager = new AccountManager();
        Scanner myScanner = new Scanner(System.in);
        try {
            System.out.println("Witaj! Napisz 1 aby się zalogować lub 2 aby utworzyć konto!");
            wybor = myScanner.nextInt();
            if (wybor != 1 && wybor != 2) {
                System.out.println("Wybrałeś złą liczbę :(");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.exit(123456789);
            }

        } catch (InputMismatchException e) {
            System.out.print("Nie podałeś liczby!!!!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        }

        Konto konto = null;
        if (wybor == 1) {
            konto = manager.login();
        } else if (wybor == 2) {
            manager.createAccount();
            System.out.println("Pomyślnie utworzono konto. Uruchom ponownie aby się zalogować");
        }

        System.out.println("Pomyślnie Zalogowano!!!\n1-Wpłać\n2-Wypłać");
        int balance = konto.getBalance();
    }


}
