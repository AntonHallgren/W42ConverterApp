public class UserInterface {

    private static final String thickLine = "=============================";
    private static final String title = "\tLEXICON CONVERTER APP";


    public void singleSession()
    {
        printTitle();
        //TODO print list of conversions
        //TODO ask for Option
        //TODO perform conversion, expand on this
        //TODO ask to continue, loop
    }

    private void printTitle()
    {
        IO.println(thickLine);
        IO.println(title);
        IO.println(thickLine);
    }
}
