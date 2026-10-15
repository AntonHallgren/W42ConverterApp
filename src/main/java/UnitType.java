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
