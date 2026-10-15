public class Unit
{
    public final String shortName;
    public final String fullName;

    public final boolean useDecimals;

    //for now, 0 is the min for all relevant units. This may change with temperature, but it seems like everything will have a min value
    private final double minValue;

    public Unit(String shortName, String fullName) {
        this(shortName, fullName, true, 0);
    }

    public Unit(String shortName, String fullName, boolean useDecimals) {
        this(shortName, fullName, useDecimals, 0);
    }

    public Unit(String shortName, String fullName, boolean useDecimals, double minValue) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.useDecimals = useDecimals;
        this.minValue = minValue;
    }

    public String writeValue(double value)
    {
        return String.format(useDecimals ? "%.2f %s" : "%.0f %s", value, shortName);
    }

    public double enterValue(String type)
    {
        while(true)
        {
            double input = UserInterface.inputDouble(String.format("Enter %s in %s: ", type.toLowerCase(), fullName));
            if(input >= minValue)
            {
                return  input;
            }
            IO.println(String.format("Invalid input. %s cannot be less than %s", type, writeValue(minValue)));
        }
    }

}
