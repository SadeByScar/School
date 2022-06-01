package DataRetriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataRetriever {
    private static final String COMMA_DELIMITER = ";";
    private Path file = null;
    private HashMap<String, Double> records;

    public DataRetriever(String filename)
    {
        this.file = Paths.get(filename);

        retrieve();
    }

    public HashMap<String, Double> getRecords() {
        return records;
    }

    public void retrieve()
    {
        records = new HashMap<>();
        try
        {
            List<String> lines = Files.readAllLines(file);
            for (String line : lines)
            {
                if (line != null)
                {
                    String[] linie = line.split(COMMA_DELIMITER);
                    String preis = linie[1].replace(',','.' );
                    // System.out.println(linie[0] + "," + preis); //Debug Ausgabe
                    records.put(linie[0], Double.parseDouble(preis));

                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("CSV-file does not exist.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Record does not exist.");
            e.printStackTrace();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
