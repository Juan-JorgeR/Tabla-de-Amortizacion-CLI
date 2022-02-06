import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    static TablaDeAmortizacion tabla;
    static Capital capital;
    static Tasa tasa;
    static Tiempo tiempo;
    static Periodo periodo;
    static Scanner scan=new Scanner(System.in);
    static final int SEMANAL=1;
    static final int QUINCENAL=2;
    static final int MENSUAL=3;
    static final int BIMENSUAL=4;
    static final int TRIMESTRAL=5;
    static final int CUATRIMESTRAL=6;
    static final int SEMESTRAL=7;
    static final int ANUAL=8;

    private static void inicializarTabla()
    {
        tabla=new TablaDeAmortizacion();

        tabla.addColumn("Periodo");
        tabla.addColumn("Intereses");
        tabla.addColumn("Amortizacion del capital");
        tabla.addColumn("Cuota");
        tabla.addColumn("Capital pendiente");
    }

    private static void displayInterfaz()
    {
        System.out.printf("\n\t\t--Tabla de amortizacion--\n\n");
        inputCapital();
        System.out.println();
        inputTasa();
        System.out.println();
        inputPeriodo();
        System.out.println();
        inputTiempo();
    }

    private static void inputCapital()
    {
        capital=new Capital();
        do
        {
            System.out.printf(">>> Entre Capital: ");
            capital.setValue(scan.nextDouble());
        }while(!capital.isCorrect());
    }

    private static void inputTasa()
    {
        tasa=new Tasa();
        do
        {
            System.out.printf(">>> Entre Tasa: ");
            tasa.setValue(scan.nextDouble());
        }while(!tasa.isCorrect());
    }

    private static void inputPeriodo()
    {
        boolean isCorrecto=false;
        periodo=new Periodo();
        System.out.printf(">> Entre periodo: \n\n");
        System.out.printf("\t1) semanal\n");
        System.out.printf("\t2) quincenal\n");
        System.out.printf("\t3) mensual\n");
        System.out.printf("\t4) bimensual\n");
        System.out.printf("\t5) trimestral\n");
        System.out.printf("\t6) cuatrimestral\n");
        System.out.printf("\t7) semestral\n");
        System.out.printf("\t8) anual\n");
        
        System.out.printf("Opcion: ");
        while(!isCorrecto)
        {
            switch(scan.nextInt())
            {
                case SEMANAL:
                    periodo.setValue(0.25);
                    isCorrecto=true;
                    break;
                case QUINCENAL:
                    periodo.setValue(0.5);
                    isCorrecto=true;
                    break;
                case MENSUAL:
                    periodo.setValue(1);
                    isCorrecto=true;
                    break;
                case BIMENSUAL:
                    periodo.setValue(2);
                    isCorrecto=true;
                    break;
                case TRIMESTRAL:
                    periodo.setValue(3);
                    isCorrecto=true;
                    break;
                case CUATRIMESTRAL:
                    periodo.setValue(4);
                    isCorrecto=true;
                    break;
                case SEMESTRAL:
                    periodo.setValue(6);
                    isCorrecto=true;
                    break;
                case ANUAL:
                    periodo.setValue(1);
                    isCorrecto=true;
                    break;
                default:
                    System.out.printf("opcion fuera de rango");
            }
        }
        

    }

    private static void inputTiempo()
    {
        tiempo=new Tiempo();
        do
        {
            System.out.printf(">>> Entre Tiempo: ");
            tiempo.setValue(scan.nextDouble());
        }while(!tiempo.isCorrect());
    }

    private static void amortizar()
    {
        Object[][] values=tabla.getValue();
        double capitalInicial=capital.getValue();
        double amortizacionCapital=capitalInicial/(tiempo.getValue()*periodo.getValue());
        int npagos=(int)(tiempo.getValue()*periodo.getValue());
        double interes,cuota,capitalPendiente;

        for(int fila=0;fila<=npagos;fila++)
        {
            if(fila==0)
            {
                for(int columna=0;columna<5;columna++)
                {

                    if(columna==0)
                    {
                        values[fila][columna]=fila;
                    }
                    else if(columna==1)
                    {   
                        values[fila][columna]=null;                    
                    }
                    else if(columna==2)
                    {
                        values[fila][columna]=null;
                    }
                    else if(columna==3)
                    {
                        values[fila][columna]=null;
                    }
                    else if(columna==4)
                    {
                        values[fila][columna]=capital.getValue();
                    }

                }
            }
            else
            {
                interes=capital.getValue()*tasa.getValue();
                cuota=interes+amortizacionCapital;
                capitalPendiente=capital.getValue()-amortizacionCapital;
                capital.setValue(capitalPendiente);

                for(int columna=0;columna<5;columna++)
                {

                    if(columna==0)
                    {
                        values[fila][columna]=fila;
                    }
                    else if(columna==1)
                    {
                        values[fila][columna]=interes;                    
                    }
                    else if(columna==2)
                    {
                        values[fila][columna]=amortizacionCapital;
                    }
                    else if(columna==3)
                    {
                        values[fila][columna]=cuota;
                    }
                    else if(columna==4)
                    {
                        values[fila][columna]=capitalPendiente;
                    }

                }
            }
            
        }
    }

    private static void displayTabla()
    {
        amortizar();
        ArrayList<String> columns=tabla.getColumns();
        Object[][] values=tabla.getValue();

        System.out.printf("\n|%10s|%10s|%25s|%10s|%20s|\n\n",columns.get(0),columns.get(1),columns.get(2),columns.get(3),columns.get(4));

        for(int fila=0;values[fila][0]!=null;fila++)
        {
            for(int columna=0;columna<5;columna++)
            {
                if(columna==0)
                    System.out.printf("%11s",values[fila][columna]);
                else if(columna==1)
                    System.out.printf("%11s",values[fila][columna]);
                else if(columna==2)
                    System.out.printf("%26s",values[fila][columna]);
                else if(columna==3)
                    System.out.printf("%11s",values[fila][columna]);
                else
                    System.out.printf("%21s",values[fila][columna]);
            }
            System.out.printf("\n\n");
        }
    }

    public static void main(String[] args)
    {
        inicializarTabla();
        displayInterfaz();
        displayTabla();
    }
}