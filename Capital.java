public class Capital extends Dato
{
    public void setValue(double value)
    {
        if(value>=0 && value<1.e+8)
            this.value=value;
        else
            correcto=false;
    }

    public double getValue()
    {
        return value;
    }

    public boolean isCorrect()
    {
        return correcto;
    }
}

