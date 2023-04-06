package proyecto.codigo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APIConverMoneda {
    public double get(String fecha, String cantidadIngresada, String pasarDe, String pasarPara){
        double resultadoMostrar = 0;

        try {
            URL url = new URL("https://api.apilayer.com/exchangerates_data/convert?to="+pasarPara+"&from="+pasarDe+"&amount="+cantidadIngresada+"&apikey=vkzA7NHi00wKVtacBhD7KojJ8KHLlC4P");
            HttpURLConnection conexionAPI = (HttpURLConnection) url.openConnection();
            conexionAPI.setRequestMethod("GET");
            conexionAPI.setRequestProperty("apikey", "vkzA7NHi00wKVtacBhD7KojJ8KHLlC4P");

            if (conexionAPI.getResponseCode()==200){
                List<String> informacionString = new ArrayList<>();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()){
                    informacionString.add(scanner.nextLine());
                }
                scanner.close();

                String respuestaAPI = informacionString.get(12);
                respuestaAPI = respuestaAPI.replaceAll("\"result\": ","");
                resultadoMostrar = Double.parseDouble(respuestaAPI);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resultadoMostrar;
    }
}
