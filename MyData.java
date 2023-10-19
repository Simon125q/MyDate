import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyData
{
    int day;
    int month;
    int year;
    String weekDay;
    private static String[] patterns = new String[]{
        "^\\d{2}/\\d{1,2}/\\d{4}/ [a-z]{3,7}day$",
        "^\\d{4}-\\d{2}-\\d{2} [a-z]{3,7}day$",
        "^[a-z]{3,7}day \\d{2}.\\d{1,2}.\\d{4}$"
    };
    public MyData(String date)
    {   
        int patternNum = findMatchingPattern(date);
        switch(patternNum) {
            case 0:
                decomposeDate("/", "end", date);
                break;
            case 1:
                decomposeDate("-", "end", date);
                break;
            case 2:
                decomposeDate("\\.", "start", date);
                break;
            default:
                System.out.println("Unrecognized date format");
                day = 0;
                month = 0;
                year = 0000;
                weekDay = "ERROR";
          }
    }

    public int findMatchingPattern(String date)
    {
        for (int patternNum = 0; patternNum < patterns.length; patternNum++)
        {
            Pattern pattern = Pattern.compile(patterns[patternNum], Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(date);
            
            boolean found = matcher.find();
            if (found) {
                return patternNum;
            }
        };
        return -99;
    }

    public String toString()
    {
        String date = weekDay + " " + day + "/" + month + "/" + year;

        return date;
    }

    private void decomposeDate(String delimeter, String weekDayPos, String date)
    {
        String[] mainElem = date.split(" ", 0);
        int datePos = 0;
        if (weekDayPos == "start")
        {
            weekDay = mainElem[0];
            datePos = 1;
        }
        else if (weekDayPos == "end")
        {
            weekDay = mainElem[1];
            datePos = 0;
        }
        String[] elements = mainElem[datePos].split(delimeter, 0);
        if (delimeter == "/")
        {
            day = Integer.parseInt(elements[0]);
            month = Integer.parseInt(elements[1]);
            year = Integer.parseInt(elements[2]);
        }
        else if (delimeter == "-")
        {
            day = Integer.parseInt(elements[2]);
            month = Integer.parseInt(elements[1]);
            year = Integer.parseInt(elements[0]);
        }
        else if (delimeter == "\\.")
        {
            day = Integer.parseInt(elements[0]);
            month = Integer.parseInt(elements[1]);
            year = Integer.parseInt(elements[2]);
        }

    }
}