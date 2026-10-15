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
        UnitConverter[] unitConverters = {};
        return new UnitType(name, units, unitConverters);
    }



}
