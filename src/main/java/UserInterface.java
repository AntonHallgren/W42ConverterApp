import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInterface {

    private static final String thickLine = "=============================";
    private static final String title = "\tLEXICON CONVERTER APP";

    private static final DateTimeFormatter dateTimeFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");

    private int numberOfConversions = 0;
    private boolean exitRequested = false;


    private final UnitType[] subPrograms = {
            UnitType.length(),
            UnitType.weight(),
            UnitType.time(),
            UnitType.temperature()
    };

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
        int choice = pickOption("Choose an option: ", subPrograms.length+1);
        IO.println();
        if(choice < subPrograms.length)
        {
            numberOfConversions++;
            history.append(numberOfConversions);
            history.append(". ");
            history.append(subPrograms[choice].handleRequest());
            history.append("\t at ");
            placeTimeStamp();
            history.append("\n");
        }
        else {
            exitRequested = true;
        }
    }

    private void printOptionsList()
    {
        for(int i = 0; i < subPrograms.length; i++)
        {
            IO.println(String.format("%d. %s", i+1, subPrograms[i].extendedName()));
        }
        IO.println(String.format("%d. Exit", subPrograms.length+1));
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
        IO.println("Total conversions: " + numberOfConversions);
        IO.println("Goodbye!");
    }

    private void placeTimeStamp()
    {
        LocalDateTime time = LocalDateTime.now();
        String timeString = time.format(dateTimeFormater);
        IO.println("Converted at " + timeString);
        history.append(timeString);
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
