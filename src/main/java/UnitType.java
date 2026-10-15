public class UnitType implements SubProgram
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

    public String handleRequest()
    {
        IO.println("--- " + extendedName() + " ---");
        IO.println("Convert:");
        for(int i = 0; i < converters.length; i++)
        {
            IO.println((i+1) + ". " + converters[i].getName());
        }
        int choice = UserInterface.pickOption("Your choice: ", converters.length);
        UnitConverter selected = converters[choice];
        double in = selected.in.enterValue(type);
        double result = selected.convert(in);
        String resultString = String.format("%s = %s", selected.in.writeValue(in), selected.out.writeValue(result));
        IO.println("Result " + resultString);
        return resultString;
    }

    @Override
    public String extendedName()
    {
        return name + " Converter";
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

    public static UnitType temperature()
    {
        String name = "Temperature";
        Unit[] units = {
                new Unit("C", "Celsius", true, -273.15),
                new Unit("F", "Fahrenheit", true, -459.67),
                new Unit("K", "Kelvin")
        };
        UnitConverter[] unitConverters = {
                new UnitConverter(units[0], units[1], 9.0/5.0, 32),
                null,
                new UnitConverter(units[0], units[2], 1, 273.15),
                null
        };
        unitConverters[1] = unitConverters[0].invert();
        unitConverters[3] = unitConverters[2].invert();
        return new UnitType(name, unitConverters);
    }

    public static UnitType currency()
    {
        String name = "Currency";
        Unit[] units = {
                new Unit("SEK", "SEK"),
                new Unit("EUR", "EUR"),
                new Unit("USD", "USD")
        };
        UnitConverter[] converters = {
                new UnitConverter(units[0], units[1], 1.0/10.87),
                new UnitConverter(units[0], units[2], 1.0/11.32)
        };
        return new UnitType(name, "amount", converters);
    }
}
