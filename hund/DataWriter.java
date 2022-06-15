package hund;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataWriter
{
    //private static final String COMMA_DELIMITER = ";";
    private Path filepath = null;

    public DataWriter(String filename)
    {
        this.filepath = Paths.get(filename);
    }

    public void write(ArrayList<Hund> hunde) throws IOException
    {
        for (Hund hund:
             hunde) {
            this.write(hund);
        }
    }

    public void write(Hund hund) throws IOException
    {
        File file = new File(String.valueOf(filepath));
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.write(this.convertToCSV(hund));
        } catch (Exception e)
        {
            System.out.println("No File");
        }
    }

/*    public String convertToCSV(String data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }*/

    private String convertToCSV(Hund hund)
    {
        return hund.getName() + ", " + hund.getRasse() + ", " + hund.getGroesse() + ", " + hund.getGewicht();
    }
}
