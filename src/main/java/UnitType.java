public class UnitType
{
    private final String name;
    private final Unit[] units;
    private final UnitConverter[] converters;

    private UnitType(String name, Unit[] units, UnitConverter[] converters) {
        this.name = name;
        this.units = units;
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
        int choice = Integer.parseInt(IO.readln("Your choice: ")) - 1;
        UnitConverter selected = converters[choice];
        double in = Double.parseDouble(IO.readln(String.format("Enter %s in %s: ", name, selected.in.fullName)));
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
        return new UnitType(name, units, unitConverters);
    }

    public static UnitType weight()
    {
        String name = "Weight";
        Unit[] units = {
                new Unit("kg", "Kilograms"),
                new Unit("g", "Grams"),
                new Unit("lb", "Pounds")};
        UnitConverter[] unitConverters = {
                new UnitConverter(units[0], units[1], 1000),
                new UnitConverter(units[0], units[2], 2.20462)
        };
        return new UnitType(name, units, unitConverters);
    }

    public static UnitType time()
    {
        String name = "Time";
        Unit[] units = {
                new Unit("h", "Hours", false),
                new Unit("min", "Minutes", false),
                new Unit("sec", "Seconds", false)};
        UnitConverter[] unitConverters = {
                new UnitConverter(units[0], units[1], 60),
                new UnitConverter(units[1], units[2], 60)
        };
        return new UnitType(name, units, unitConverters);
    }


}
