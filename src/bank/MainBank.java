package bank;
import java.io.*;
import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;



public class MainBank {

    private  int wybor12(String message){
        int wybor = 0;
        Scanner myScanner = new Scanner(System.in);
        try {
            System.out.println(message);
            wybor = myScanner.nextInt();
            if (wybor != 1 && wybor != 2) {
                System.out.println("Wybrałeś złą liczbę :(");
                System.exit(123456789);
            }

        } catch (InputMismatchException e) {
            System.out.print("Nie podałeś liczby!!!!");
            System.exit(123456789);

        }
        return wybor;
    }

    public static void main(String[] args) throws FileNotFoundException {
        AccountManager manager = new AccountManager();
        MainBank bank = new MainBank();
        int wybor = bank.wybor12("Witaj! Napisz 1 aby się zalogować lub 2 aby utworzyć konto!");

        Konto konto = null;
        if (wybor == 1) {
            konto = manager.login();
        } else if (wybor == 2) {
            manager.createAccount();
            System.out.println("Pomyślnie utworzono konto. Uruchom ponownie aby się zalogować");
            System.exit(8);
        }
        int staryBalance = 0;
        if(konto != null){
            staryBalance = konto.getBalance();
        }
        int wybor1 = bank.wybor12("Pomyślnie Zalogowano!!!\n1-Wpłać\n2-Wypłać");
        if(wybor1 == 1){
            konto.setBalance(konto.getBalance()+konto.wplac());
            EditCSVValue.editValueInCSV(AccountManager.LOCATION_OF_THE_FILE, manager.returnColumnNumberFromLogin(konto.getLogin()), 2,Integer.toString(staryBalance),Integer.toString(konto.getBalance()));

        }
        else if(wybor1 == 2){
            konto.setBalance(konto.getBalance()- konto.wyplac());
            EditCSVValue.editValueInCSV(AccountManager.LOCATION_OF_THE_FILE, manager.returnColumnNumberFromLogin(konto.getLogin()), 2,Integer.toString(staryBalance),Integer.toString(konto.getBalance()));
        }
    }




}
