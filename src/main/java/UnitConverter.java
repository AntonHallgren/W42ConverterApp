public class UnitConverter
{
    public final Unit in;
    public final Unit out;
    private final double mult;
    private final double add;

    public UnitConverter(Unit in, Unit out, double mult) {
        this(in, out, mult, 0);
    }

    public UnitConverter(Unit in, Unit out, double mult, double add) {
        this.in = in;
        this.out = out;
        this.mult = mult;
        this.add = add;
    }

    public UnitConverter invert()
    {
        return new UnitConverter(out, in, 1.0/mult, -add/mult);
    }

    public double convert(double value)
    {
        return value * mult + add;
    }

    public String getName()
    {
        return in.fullName + " to " + out.fullName;
    }


}
