package bank;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class EditCSVValue {

    public static void editValueInCSV(String filePath, int rowNumber, int columnNumber, String oldValue, String newValue) {


        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            if (rowNumber >= 0 && rowNumber < records.size()) {
                String[] row = records.get(rowNumber);
                if (columnNumber >= 0 && columnNumber < row.length && row[columnNumber].equals(oldValue)) {
                    row[columnNumber] = newValue;
                    records.set(rowNumber, row);
                } else {
                    System.out.println("Wartość wskazanej komórki nie zgadza się z oczekiwaną.");
                }
            } else {
                System.out.println("Nieprawidłowy numer wiersza.");
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
                writer.writeAll(records);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

    }





}