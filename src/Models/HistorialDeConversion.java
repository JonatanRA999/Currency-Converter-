package Models;

import java.util.ArrayList;
import java.util.List;

public class HistorialDeConversion
{
    private List<String> historial ;

    public HistorialDeConversion ()
    {
        historial = new ArrayList<>();
    }

    public List<String> getHistorial()
    {
        return historial;
    }

    public void AgregarAlHistorial(String nuevo)
    {
        this.historial.add(nuevo);
    }
}
