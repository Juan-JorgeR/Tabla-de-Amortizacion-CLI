import java.util.ArrayList;

public class TablaDeAmortizacion extends Tabla
{
    int fila=0;
    int columna=0;

    public TablaDeAmortizacion()
    {
        values=new Object[1440][5];
        name=this.toString();
    }

    public void addColumn(String column)
    {    
        columns.add(column);
    }
    public void addValue(Object value)
    {
        values[fila][columna]=value;
        columna++;
        if(columna>=columns.size())
        {
            fila++;
            columna=0;
        }
    }

    public ArrayList<String> getColumns()
    {
        return columns;
    }
    public Object[][] getValue()
    {
        return values;
    }
}