import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileHandler {
    ArrayList<String> lines = new ArrayList<>();

    public ArrayList<String> readDataToArrrArrayList(String inFileName) throws IOException
    {
    
        BufferedReader reader = new BufferedReader(new FileReader(inFileName));
        String line = reader.readLine();
        while (line != null)
        {
            lines.add(line);
            line = reader.readLine();
        }
        reader.close();

        return lines;
    }

    public void saveData(String outFileName, ArrayList<String> result) throws IOException
    {
        
        FileWriter writer = new FileWriter(outFileName);
        Iterator<String> resultIterator = result.iterator();
        while (resultIterator.hasNext())
        {
            String date = resultIterator.next();
            writer.write(date.toString());
            writer.write("\r\n");
        }
        writer.close();
    }
}
