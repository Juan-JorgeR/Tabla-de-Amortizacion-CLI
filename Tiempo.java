public class Tiempo extends Dato
{
    public void setValue(double value)
    {
        if(value>0 && value<30)
        {
            this.value=value;
            correcto=true;
        }
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