import java.util.ArrayList;

public abstract class Tabla 
{
    ArrayList<String> columns=new ArrayList<String>();
    String name=this.toString();
    Object[][] values;

    protected abstract void addColumn(String column);
    protected abstract void addValue(Object value);
    protected abstract ArrayList<String> getColumns();
    protected abstract Object[][] getValue();

}