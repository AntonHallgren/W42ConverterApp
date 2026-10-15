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
        IO.println(String.format("Result: %.2f %s = %.2f %s", in, selected.in.shortName, result, selected.out.shortName));
    }


    public static UnitType Length()
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



}
