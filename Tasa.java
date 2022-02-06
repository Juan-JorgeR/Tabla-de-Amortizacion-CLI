public class Tasa extends Dato
{
    public void setValue(double value)
    {
        if(value>=0 && value<100)
        {
            this.value=value;
            correcto=true;
        }

        else
            correcto=false;
    }

    public double getValue()
    {
        return value/100;
    }

    public boolean isCorrect()
    {
        return correcto;
    }
}