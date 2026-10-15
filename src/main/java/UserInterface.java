public class UserInterface {

    private static final String thickLine = "=============================";
    private static final String title = "\tLEXICON CONVERTER APP";

    private boolean exitRequested = false;

    private final UnitType length = UnitType.Length();


    public void singleSession()
    {
        printTitle();
        askOption();
        if(!exitRequested)
        {
            askContinue();
        }
    }

    private void printTitle()
    {
        IO.println(thickLine);
        IO.println(title);
        IO.println(thickLine);
    }

    private void askOption()
    {
        printOptionsList();
        IO.println(thickLine);
        int choice = Integer.parseInt(IO.readln("Choose an option: "));
        switch(choice)
        {
            case 1 -> length.handleRequest();
            case 4 -> exitRequested = true;
        }



    }

    private void printOptionsList()
    {
        IO.println("1. Length Converter");
        IO.println("4. Exit");
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
