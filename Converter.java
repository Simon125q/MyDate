import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;

public class Converter {
    ArrayList<MyData> dates = new ArrayList<>();

    public static void main(String[] args)
    {
        Converter dates = new Converter();
        
        int datesCount = dates.convertData("file_in.txt", "file_out.txt");
        System.out.println("Number of unique dates: " + datesCount);

    }

    public int convertData(String inFileName, String outFileName)
    {
        int uniqueDatesNum = 0;
    	try {
            FileHandler saveReadDates = new FileHandler();
            ArrayList<String> lines = new ArrayList<>();
            ArrayList<MyData> dates = new ArrayList<>();
            ArrayList<String> uniqueDates = new ArrayList<>();

            lines = saveReadDates.readDataToArrrArrayList(inFileName);
       
            dates =  convertArray(lines);
            
            uniqueDates = getArrayOfUniqueStrings(dates);
		
            saveReadDates.saveData("file_out.txt", uniqueDates);
            
            uniqueDatesNum = uniqueDates.size();
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        } 

        return uniqueDatesNum;
    }

    public ArrayList<MyData> convertArray(ArrayList<String> lines)
    {
        Iterator<String> linIterable = lines.iterator();
        ArrayList<MyData> dates = new ArrayList<>();

        while(linIterable.hasNext())
        {
            dates.add(new MyData(linIterable.next()));
        }
        return dates;
    }

    public ArrayList<String> getArrayOfUniqueStrings(ArrayList<MyData> dates)
    {
        Iterator<MyData> datesIterator = dates.iterator();
        ArrayList<String> uniqueDates = new ArrayList<>();
        HashSet<String> datesChecker = new HashSet<>();

        String date = datesIterator.next().toString();
        while (datesIterator.hasNext())
        {
            if (!datesChecker.contains(date))
            {
                uniqueDates.add(date);
                datesChecker.add(date);
            }
            date = datesIterator.next().toString();
        }
        
        return uniqueDates;
    }
    
}

