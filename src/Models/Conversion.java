package Models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Conversion
{
    private double valorDeConversion;
    private  double resultadoDeConversion;


    public Conversion(ConversionAPI conversionAPI)
    {
        this.valorDeConversion = Double.parseDouble(conversionAPI.conversion_rate());
        this.resultadoDeConversion =Double.parseDouble(conversionAPI.conversion_result());
    }


    public double getValorDeConversion() {
        return valorDeConversion;
    }

    public void setValorDeConversion(double valorDeConversion) {
        this.valorDeConversion = valorDeConversion;
    }

    public double getResultadoDeConversion() {
        return resultadoDeConversion;
    }

    public void setResultadoDeConversion(double resultadoDeConversion) {
        this.resultadoDeConversion = resultadoDeConversion;
    }
}
