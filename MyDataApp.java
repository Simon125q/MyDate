public class MyDataApp
{
    public static void main(String[] args)
    {
        MyData dates = new MyData();
        int datesCount = dates.convertData("file_in.txt", "file_out.txt");
        System.out.println("Number of unique dates: " + datesCount);
    }
}