package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Konto extends AccountManager {

    private int balance = 0;
    private String password;
    private String login;

    public Konto(String[] lista) {
        this.login = lista[0];
        this.password = lista[1];
        this.balance = Integer.parseInt(lista[2]);



    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "balance=" + balance  +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    public int wplac() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Ile chciałby/chciałaby Pan/Pani wpłacić: ");
        try{
            int ilosc = myScanner.nextInt();
            if(ilosc > 10000000){
                System.out.println("Nie wierzę ci, wzywam policję");
            } else{
                return ilosc;
            }
        } catch(InputMismatchException e){
            System.out.println("Zły typ");
        }
        return 0;
    }

    public int wyplac() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Ile chciałby/chciałaby Pan/Pani wypłacić: ");
        try{
            int ilosc = myScanner.nextInt();
            if(ilosc > this.balance){
                System.out.println("Nie masz takich funduszy na koncie!");
                System.exit(-8);
            } else{
                return ilosc;
            }
        } catch(InputMismatchException e){
            System.out.println("Zły typ");
        }
        return 0;
    }

}
