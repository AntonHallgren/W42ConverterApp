public class GradeConverter implements SubProgram
{

    @Override
    public String handleRequest() {
        return "";
    }

    @Override
    public String extendedName() {
        return "Grade Converter";
    }

    private int askForScore()
    {
        while(true)
        {
            double input = UserInterface.inputDouble("Enter score: ");
            if(input <= 100 && input >= 0)
            {
                return (int) Math.round(input);
            }
            IO.println("Invalid input. Please enter a number between 0 and 100");
        }
    }
}
