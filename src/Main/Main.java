package Main;

import Calculos.Calculos;
import Models.Conversion;
import Models.HistorialDeConversion;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        var input = new Scanner(System.in);
        var solicitud  = new Calculos();
        var historialDeConversion = new HistorialDeConversion();
        var redFlag= 0;

        while (redFlag != 2)
        {
            System.out.println("""
                    --NOMECLATURA--
                    ARS - Peso argentino   
                                    
                    BOB - Boliviano boliviano  
                                    
                    BRL - Real brasileño
                                    
                    CLP - Peso chileno
                                    
                    COP - Peso colombiano
                                    
                    USD - Dólar estadounidense""");
            System.out.println("""
                    -------------POSIBLES CONVERSIONES--------
                    USD ---> ARS  
                    ARS ---> USD
                    COP ---> USD
                    CLP ---> USD 
                                    
                    nota : puede realizar las combinaciones que desee con la nomeclatura
                    """);
            input.nextLine();
            System.out.print("Moneda Base: ");
            String monedaBase = input.nextLine().toUpperCase();
            System.out.print("Moneda Final: ");
            String monedaFinal = input.nextLine().toUpperCase();
            System.out.println("Valor a convertir : ");
            double valor = input.nextDouble();


            Conversion conversion = new Conversion(solicitud.BusquedaDeConversion(monedaBase, monedaFinal, valor));

            System.out.println("El valor de Convercion : " + conversion.getValorDeConversion());
            System.out.println("Resultado de Conversion : " + conversion.getResultadoDeConversion());

            historialDeConversion.AgregarAlHistorial(monedaBase + " --> " + monedaFinal + " |> Conversion $" + conversion.getResultadoDeConversion() + " "+monedaFinal);
            System.out.println("""
                    Seguir convirtiendo ? :
                    1.continuar
                    2.salir""");
            redFlag = input.nextInt();
        }
        System.out.println("--HISTORIAL DE CONVERSION--");
        historialDeConversion.getHistorial().forEach(System.out::println);
    }
}
