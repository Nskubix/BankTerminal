package bank;
import java.util.Scanner;
import java.io.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;

public class AccountManager {
    public static String LOCATION_OF_THE_FILE = "src/bank/accounts.csv";

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
            outputfile.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readBalanceFromLogin(String providedLogin) throws FileNotFoundException {
        try {
            FileReader freader = new FileReader(LOCATION_OF_THE_FILE);//created an object of freader class
            @SuppressWarnings("resource")
            CSVReader creader = new CSVReader(freader);// created creader object by parsing freader as a parameter
            String[] nextRecord; // nextRecord = whole line
            while ((nextRecord = creader.readNext()) != null) {
                for(String token:nextRecord){
                    if(token.equals(providedLogin)){
                       return nextRecord[2];
                    }

                }
                System.out.println("");
            }
            System.out.println();
            freader.close();
            creader.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public int returnColumnNumberFromLogin(String providedLogin) throws FileNotFoundException {
        try {
            FileReader freader = new FileReader(LOCATION_OF_THE_FILE);//created an object of freader class
            @SuppressWarnings("resource")
            CSVReader creader = new CSVReader(freader);// created creader object by parsing freader as a parameter
            String[] nextRecord; // nextRecord = whole line
            int i = 0;
            while ((nextRecord = creader.readNext()) != null) {
                for(String token:nextRecord){
                    if(token.equals(providedLogin)){
                        return i;
                    }

                }
                i++;
            }

            System.out.println();
            freader.close();
            creader.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
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
            freader.close();
            creader.close();
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
                lista = new String[]{providedLogin,providedPassword,readBalanceFromLogin(providedLogin)};
            } else{
                System.out.println("Niepoprawny login lub hasło Spróbuj ponownie");
                System.exit(-9);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


        Konto konto = null;
        if(lista != null){
            konto = new Konto(lista);
        }

        return konto;
    }


}
