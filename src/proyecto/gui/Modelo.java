package proyecto.gui;

import proyecto.codigo.APIConverMoneda;
import proyecto.codigo.Pares;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Modelo {
    Pares celciusKelvin = new Pares("De Celcius a Kelvin", 273.15, "°C", "°K");
    Pares celciusFahrenheit = new Pares("De Celcius a Fahrenheit", 32, "°C", "°F");
    Pares kelvinCelcius = new Pares("De Kelvin a Celcius", 273.15, "°K", "°C");
    Pares kelvinFahrenheit = new Pares("De Kelvin a Fahrenheit", 273.15, "°K", "°F");
    Pares fahrenheitCelcius = new Pares("De Fahrenheit a Celcius",32, "°F", "°C");
    Pares fahrenheitKelvin = new Pares("De Fahrenheit a Kelvin", 32, "°F", "°K");

    List<Pares> paresMedidas = new ArrayList<>(Arrays.asList(celciusKelvin,celciusFahrenheit,kelvinCelcius,kelvinFahrenheit,
            fahrenheitCelcius,fahrenheitKelvin));

    public String ConvertirTemperatura(String opcionElegida, double cantidad){
        String resultado = "";

        for (Pares paresMedida : paresMedidas) {
            if (Objects.equals(paresMedida.getNombre(), opcionElegida) && Objects.equals(paresMedida.getNombre(), "De Celcius a Kelvin")) {
                double celciusKelvin = cantidad + paresMedida.getCambioMedida();
                BigDecimal dosDecimalesCK = new BigDecimal(celciusKelvin).setScale(2, RoundingMode.HALF_UP);
                resultado = cantidad + " " + paresMedida.getPasarDe() + " son " + dosDecimalesCK + " " +paresMedida.getPasarPara();
            } else if (Objects.equals(paresMedida.getNombre(), opcionElegida) && Objects.equals(paresMedida.getNombre(), "De Celcius a Fahrenheit")) {
                double celciusFahrenheit = (cantidad * 9 / 5) + paresMedida.getCambioMedida();
                BigDecimal dosDecimalesCF = new BigDecimal(celciusFahrenheit).setScale(2, RoundingMode.HALF_UP);
                resultado = cantidad + " " + paresMedida.getPasarDe() + " son " + dosDecimalesCF + " " +paresMedida.getPasarPara();
            } else if (Objects.equals(paresMedida.getNombre(), opcionElegida) && Objects.equals(paresMedida.getNombre(), "De Kelvin a Celcius")) {
                double kelvinCelcius = cantidad - paresMedida.getCambioMedida();
                BigDecimal dosDecimalesKC = new BigDecimal(kelvinCelcius).setScale(2, RoundingMode.HALF_UP);
                resultado = cantidad + " " + paresMedida.getPasarDe() + " son " + dosDecimalesKC + " " +paresMedida.getPasarPara();
            } else if (Objects.equals(paresMedida.getNombre(), opcionElegida) && Objects.equals(paresMedida.getNombre(), "De Kelvin a Fahrenheit")) {
                double kelvinFahrenheit = (cantidad - paresMedida.getCambioMedida()) * 9/5 + 32;
                BigDecimal dosDecimalesKF = new BigDecimal(kelvinFahrenheit).setScale(2, RoundingMode.HALF_UP);
                resultado = cantidad + " " + paresMedida.getPasarDe() + " son " + dosDecimalesKF + " " +paresMedida.getPasarPara();
            } else if (Objects.equals(paresMedida.getNombre(), opcionElegida) && Objects.equals(paresMedida.getNombre(), "De Fahrenheit a Celcius")) {
                double fahrenheitCelcius = (cantidad - paresMedida.getCambioMedida()) * 5/9;
                BigDecimal dosDecimalesFC = new BigDecimal(fahrenheitCelcius).setScale(2, RoundingMode.HALF_UP);
                resultado = cantidad + " " + paresMedida.getPasarDe() + " son " + dosDecimalesFC + " " +paresMedida.getPasarPara();
            } else if (Objects.equals(paresMedida.getNombre(), opcionElegida) && Objects.equals(paresMedida.getNombre(), "De Fahrenheit a Kelvin")) {
                double fahrenheitKelvin = (cantidad - paresMedida.getCambioMedida()) * 5/9 + 273.15;
                BigDecimal dosDecimalesFK = new BigDecimal(fahrenheitKelvin).setScale(2, RoundingMode.HALF_UP);
                resultado = cantidad + " " + paresMedida.getPasarDe() + " son " + dosDecimalesFK + " " +paresMedida.getPasarPara();
            }
        }
        return resultado;
    }

    Pares solDolar = new Pares("De Soles a Dólares", "PEN", "USD");
    Pares dolarSol = new Pares("De Dólares a Soles", "USD", "PEN");
    Pares solEuro = new Pares("De Soles a Euros", "PEN", "EUR");
    Pares euroSol = new Pares("De Euros a Soles", "EUR", "PEN");
    Pares solLibra = new Pares("De Soles a Libras", "PEN", "GBP");
    Pares libraSol = new Pares("De Libras a Soles", "GBP", "PEN");
    Pares solYen = new Pares("De Soles a Yenes", "PEN", "JPY");
    Pares yenSol = new Pares("De Yenes a Soles", "JPY", "PEN");
    Pares solDCanadiense = new Pares("De Soles a Dólares Canadienses", "PEN", "CAD");
    Pares dCanadienseSol = new Pares("De Dólares Canadienses a Soles", "CAD", "PEN");
    Pares solPesoChileno = new Pares("De Soles a Pesos Chilenos", "PEN", "CLP");
    Pares pesoChilenoSol = new Pares("De Pesos Chilenos a Soles", "CLP", "PEN");

    List<Pares> paresMonedas = new ArrayList<>(Arrays.asList(solDolar,dolarSol,solEuro,euroSol,solLibra,libraSol,
            solYen,yenSol,solDCanadiense,dCanadienseSol,solPesoChileno,pesoChilenoSol));

    public String ConvertirMoneda(String opcionElegida, String cantidadIngresada){
        String[] datosAPI = new String[4];
        String pasarDe = "", pasarPara = "";

        for (Pares par : paresMonedas){
            if (Objects.equals(opcionElegida, par.getNombre())){
                pasarDe = par.getPasarDe();
                pasarPara = par.getPasarPara();
            }
        }
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatearFechaActual = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String fechaFormateada = fechaActual.format(formatearFechaActual);

        datosAPI[0] = fechaFormateada;
        datosAPI[1] = cantidadIngresada;
        datosAPI[2] = pasarDe;
        datosAPI[3] = pasarPara;

        APIConverMoneda resultadoAPI = new APIConverMoneda();
        double usarAPI = resultadoAPI.get(datosAPI[0],datosAPI[1],datosAPI[2],datosAPI[3]);
        BigDecimal formatoDosDecimales = new BigDecimal(usarAPI).setScale(2, RoundingMode.HALF_UP);
        double valorDosDecimales = formatoDosDecimales.doubleValue();
        return cantidadIngresada + " " + pasarDe + " son " +valorDosDecimales + " " + pasarPara;
    }
}
