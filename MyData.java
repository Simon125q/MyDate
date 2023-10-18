import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyData
{
    int day;
    int month;
    int year;
    String weekDay;
    private static String[] patterns = new String[]{
        "^\\d{2}/\\d{1,2}/\\d{4}/ [a-z]{3,6}day$",
        "^\\d{4}-\\d{2}-\\d{2} [a-z]{3,6}day\\n$",
        "^[a-z]{3,6}day \\d{2}.\\d{1,2}.\\d{4}\\n$"
    };
    public MyData(String date)
    {   
        int patternNum = findMatchingPattern(date);
        day = patternNum;
        month = 12;
        year = 2003;
        weekDay = date;
    }

    public int findMatchingPattern(String date)
    {
        for (int patternNum = 0; patternNum < patterns.length; patternNum++)
        {
            Pattern pattern = Pattern.compile(patterns[patternNum], Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(date);
            
            boolean found = matcher.find();
            if (found)
            {
                return patternNum; 
            }
        };
        return -1;
    }

    public String toString()
    {
        String date = weekDay + " " + day + "/" + month + "/" + year;

        return date;
    }
}