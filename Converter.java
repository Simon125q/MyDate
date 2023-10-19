import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;

public class Converter {
    ArrayList<MyData> lines = new ArrayList<>();

    public int convertData(String inFileName, String outFileName)
    {
        readData(inFileName);
        
        System.out.println(lines);

        int uniqueDatesNum = saveData(outFileName);
        return uniqueDatesNum;
    }

    public void readData(String inFileName)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFileName));
            String line = reader.readLine();
            while (line != null)
            {
                lines.add(new MyData(line));
                line = reader.readLine();
            }
 
            reader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int saveData(String outFileName)
    {
        HashSet<String> uniqueDates = new HashSet<>();
        try {
            FileWriter writer = new FileWriter(outFileName);
            Iterator<MyData> linesIterator = lines.iterator();
            while (linesIterator.hasNext())
            {
                MyData date = linesIterator.next();
                if (!uniqueDates.contains(date.toString()))
                {
                    uniqueDates.add(date.toString());
                    writer.write(date.toString());
                    writer.write("\r\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return uniqueDates.size();
    }
}

