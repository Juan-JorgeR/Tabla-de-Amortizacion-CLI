public class Periodo extends Dato
{
    public void setValue(double value)
    {
        this.value=value;
    }

    public double getValue()
    {
        return 12/value;
    }

    public boolean isCorrect()
    {
        return true;
    }
}