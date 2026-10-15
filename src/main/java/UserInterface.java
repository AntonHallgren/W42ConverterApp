public class UserInterface {

    private static final String thickLine = "=============================";
    private static final String title = "\tLEXICON CONVERTER APP";

    private boolean exitRequested = false;


    public void singleSession()
    {
        printTitle();
        //TODO print list of conversions
        //TODO ask for Option
        //TODO perform conversion, expand on this
        askContinue();
    }

    private void printTitle()
    {
        IO.println(thickLine);
        IO.println(title);
        IO.println(thickLine);
    }

    private void askContinue()
    {
        String continueAnswer = IO.readln("Continue? (yes/ no): ");
        switch (continueAnswer.toLowerCase())
        {
            case "yes", "y" -> exitRequested = false;
            case "no", "n" -> exitRequested = true;
            default ->
            {
                exitRequested = true;
                IO.println("Invalid input");
            }
        }
    }

    public boolean isExitRequested() {
        return exitRequested;
    }
}
