public class ConverterApp
{
    public static void main(String[] args)
    {
        Converter dates = new Converter();
        int datesCount = dates.convertData("file_in.txt", "file_out.txt");
        System.out.println("Number of unique dates: " + datesCount);
    }
}