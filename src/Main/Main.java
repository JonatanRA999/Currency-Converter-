package Main;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/49d66aedba4681bd5afdcccd/latest/USD"))
                    .build();
            HttpResponse response = client.send(request , HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        }catch (Exception e)
        {
            System.out.println("Mensaje : "+ e.getMessage());
        }
    }
}
