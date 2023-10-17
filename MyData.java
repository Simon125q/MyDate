import java.io.FileReader;
import java.io.IOException;

public class MyData
{
    int day;
    int month;
    int year;
    String weekDay;

    public static int convertData(String inFileName, String outFileName)
    {
        System.out.println(inFileName + " " + outFileName);
        readData(inFileName);

        return 2;
    }

    public static void readData(String inFileName)
    {
        try {
            FileReader reader = new FileReader(inFileName);

        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}