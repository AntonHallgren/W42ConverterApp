public class UserInterface {

    private static final String thickLine = "=============================";
    private static final String title = "\tLEXICON CONVERTER APP";

    private boolean exitRequested = false;

    private final UnitType length = UnitType.length();
    private final UnitType weight = UnitType.weight();
    private final UnitType time = UnitType.time();

    private final StringBuilder history = new StringBuilder();

    public void singleSession()
    {
        printTitle();
        askOption();
        if(!exitRequested)
        {
            IO.println();
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
        int choice = pickOption("Choose an option: ", 4);
        IO.println();
        switch(choice)
        {
            case 0 -> history.append(length.handleRequest());
            case 1 -> history.append(weight.handleRequest());
            case 2 -> history.append(time.handleRequest());
            case 3 -> exitRequested = true;
        }



    }

    private void printOptionsList()
    {
        IO.println("1. Length Converter");
        IO.println("2. Weight Converter");
        IO.println("3. Time Converter");
        IO.println("4. Exit");
    }

    private void askContinue()
    {
        while(true)
        {
            String continueAnswer = IO.readln("Continue? (yes/ no): ");
            switch (continueAnswer.toLowerCase())
            {
                case "yes", "y" ->
                {
                    exitRequested = false;
                    IO.println();
                    return;
                }
                case "no", "n" ->
                {
                    exitRequested = true;
                    return;
                }
                default -> IO.println("Invalid input");
            }
        }
    }

    public void printHistory()
    {
        IO.println("=== Conversion History ===");
        IO.print(history);
        IO.println(thickLine);

        IO.println("Goodbye!");
    }

    public boolean isExitRequested() {
        return exitRequested;
    }

    public static int pickOption(String prompt, int numberOfOptions)
    {
        while(true)
        {
            int input = inputInt(prompt);
            if(input > 0 && input <= numberOfOptions)
            {
                return input-1;
            }
            IO.println(String.format("Invalid input. Please enter a number between 1 and %d. ", numberOfOptions));
        }
    }

    public static int inputInt(String prompt)
    {
        while(true)
        {
            try{
                return Integer.parseInt(IO.readln(prompt));
            } catch (NumberFormatException e) {
                IO.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static double inputDouble(String prompt)
    {
        while(true)
        {
            try{
                return Double.parseDouble(IO.readln(prompt));
            } catch (NumberFormatException e) {
                IO.println("Invalid input. Please enter a number.");
            }
        }
    }




}
