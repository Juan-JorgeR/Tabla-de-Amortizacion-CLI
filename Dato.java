public abstract class Dato
{
    double value=0.0;
    boolean correcto=true;

    protected abstract void setValue(double value);

    protected abstract double getValue();

    protected abstract boolean isCorrect();
}