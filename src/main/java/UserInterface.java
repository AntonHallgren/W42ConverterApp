public class UserInterface {

    private String thickLine = "=============================";
    private String title = "\tLEXICON CONVERTER APP";


    public void singleSession()
    {
        printTitle();
    }

    private void printTitle()
    {
        IO.println(thickLine);
        IO.println(title);
        IO.println(thickLine);
    }
}
