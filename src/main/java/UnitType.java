public class UnitType
{
    private final String name;
    private final String type;//This variable needs a better name
    //private final Unit[] units;
    private final UnitConverter[] converters;

    private UnitType(String name, UnitConverter[] converters) {
        this(name, name, converters);
    }

    private UnitType(String name, String type, UnitConverter[] converters) {
        this.name = name;
        this.type = type;
        //this.units = units;
        this.converters = converters;
    }

    public void handleRequest()
    {
        IO.println("--- " + name + " Converter ---");
        IO.println("Convert:");
        for(int i = 0; i < converters.length; i++)
        {
            IO.println((i+1) + ". " + converters[i].getName());
        }
        int choice = UserInterface.pickOption("Your choice: ", converters.length);
        UnitConverter selected = converters[choice];
        double in = selected.in.enterValue(type);
        double result = selected.convert(in);
        IO.println(String.format("Result: %s = %s", selected.in.writeValue(in), selected.out.writeValue(result)));
    }


    public static UnitType length()
    {
        String name = "Length";
        Unit[] units = {
                new Unit("cm", "centimeters"),
                new Unit("m", "meters"),
                new Unit("km", "kilometers")};
        UnitConverter[] unitConverters = {
                new UnitConverter(units[0], units[1], 0.01),
                new UnitConverter(units[1], units[2], 0.001)
                };
        return new UnitType(name, unitConverters);
    }

    public static UnitType weight()
    {
        String name = "Weight";
        Unit[] units = {
                new Unit("kg", "kilograms"),
                new Unit("g", "grams"),
                new Unit("lb", "pounds")};
        UnitConverter[] unitConverters = {
                new UnitConverter(units[0], units[1], 1000),
                new UnitConverter(units[0], units[2], 2.20462)
        };
        return new UnitType(name, unitConverters);
    }

    public static UnitType time()
    {
        String name = "Time";
        Unit[] units = {
                new Unit("h", "hours", false),
                new Unit("min", "minutes", false),
                new Unit("sec", "seconds", false)};
        UnitConverter[] unitConverters = {
                new UnitConverter(units[0], units[1], 60),
                new UnitConverter(units[1], units[2], 60)
        };
        return new UnitType(name, unitConverters);
    }


}
