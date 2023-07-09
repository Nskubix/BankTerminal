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

}
