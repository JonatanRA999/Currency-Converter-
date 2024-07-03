package Calculos;

import Models.Conversion;
import Models.ConversionAPI;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Calculos
{
    private String json;


    public ConversionAPI BusquedaDeConversion(String monedaBase , String monedaFinal , double valorAconvertir){

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/49d66aedba4681bd5afdcccd/pair/"+monedaBase+"/"+monedaFinal+"/"+valorAconvertir))
                    .build();
            HttpResponse<String> response = client.send(request , HttpResponse.BodyHandlers.ofString());

             this.json = response.body();

        }catch (Exception e)
        {
            System.out.println("Mensaje : "+ e.getMessage());
        }

        Gson gson = new Gson();
        return gson.fromJson(json , ConversionAPI.class);
    }
}
