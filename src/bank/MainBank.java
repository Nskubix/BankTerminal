package bank;
import java.io.*;
import java.lang.*;


public class MainBank {
    public static void main(String[] args) throws FileNotFoundException {
        AccountManager manager = new AccountManager();
        Konto konto = new Konto();
        manager.readAllAccounts();
        manager.createAccount();
        manager.readAllAccounts();

    }
}
