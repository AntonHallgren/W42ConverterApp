public class Unit
{
    public final String shortName;
    public final String fullName;

    public final boolean useDecimals;

    public Unit(String shortName, String fullName) {
        this(shortName, fullName, true);
    }

    public Unit(String shortName, String fullName, boolean useDecimals) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.useDecimals = useDecimals;
    }

    public String writeValue(double value)
    {
        return String.format(useDecimals ? "%.2f %s" : "%.0f %s", value, shortName);
    }

}
