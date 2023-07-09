package bank;
import java.util.Scanner;
import java.io.*;

public class AccountManager {


    public void createAccount() throws FileNotFoundException{
        Scanner myScn = new Scanner(System.in);
        System.out.print("Do utworzenia konta podaj login");
        String login = myScn.nextLine();
        System.out.print("Do utworzenia konta podaj hasło");
        String password = myScn.nextLine();
        myScn.close();
    }



}
