package bank;
import java.sql.Struct;
import java.util.Scanner;
import java.io.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;

public class AccountManager {
    private static String LOCATION_OF_THE_FILE = "E:\\Kuba\\Programowanie\\JavaIntellij\\BankTerminal\\src\\bank\\accounts.csv"; // zmień to na swoją ścieżke

    public void createAccount(){
        Scanner myScn = new Scanner(System.in);
        System.out.print("Do utworzenia konta podaj login: ");
        String login = myScn.nextLine();
        System.out.print("Do utworzenia konta podaj hasło: ");
        String password = myScn.nextLine();
        File file = new File(LOCATION_OF_THE_FILE);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file,true);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);


            // add data to csv
            String[] data1 = { login, password, Integer.toString(0) };
            writer.writeNext(data1,false);


            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        myScn.close();
    }

    public void readAllAccounts() throws FileNotFoundException {
        try {
            FileReader freader = new FileReader(LOCATION_OF_THE_FILE);//created an object of freader class
            @SuppressWarnings("resource")
            CSVReader creader = new CSVReader(freader);// created creader object by parsing freader as a parameter
            String[] nextRecord; // nextRecord = whole line
            while ((nextRecord = creader.readNext()) != null) {
                for(String token:nextRecord){
                    System.out.print(token+" ");
                }
                System.out.println("");
            }
            System.out.println();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean isInputEqual(String providedLogin,String providedPassword) throws FileNotFoundException {
        try {
            FileReader freader = new FileReader(LOCATION_OF_THE_FILE);//created an object of freader class
            @SuppressWarnings("resource")
            CSVReader creader = new CSVReader(freader);// created creader object by parsing freader as a parameter
            String[] nextRecord; // nextRecord = whole line
            while ((nextRecord = creader.readNext()) != null) {
                if(nextRecord[0].equals(providedLogin) && nextRecord[1].equals(providedPassword)){
                    return true;
                }

            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }



    public Konto login(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Podaj login: ");
        String providedLogin = myScanner.nextLine();
        System.out.println("");
        System.out.print("Podaj hasło: ");
        String providedPassword = myScanner.nextLine();
        System.out.println(" ");
        String[] lista = null;
        try{
            if(isInputEqual(providedLogin,providedPassword)){
                lista = new String[]{providedLogin,providedPassword,"0"};
            } else{
                System.out.println("Niepoprawny login lub hasło Spróbuj ponownie");
                Thread.sleep(3000);
                System.exit(123);
            }
        } catch (FileNotFoundException | InterruptedException e){
            e.printStackTrace();
        }


        Konto konto = null;
        if(lista != null){
            konto = new Konto(lista);
        }

        return konto;
    }

}
