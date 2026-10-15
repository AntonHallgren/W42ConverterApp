public class UnitConverter
{
    public final Unit in;
    public final Unit out;
    private final double mult;


    public UnitConverter(Unit in, Unit out, double mult) {
        this.in = in;
        this.out = out;
        this.mult = mult;
    }

    public double convert(double value)
    {
        return value * mult;
    }

    public String getName()
    {
        return in.fullName + " to " + out.fullName;
    }


}
