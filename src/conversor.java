import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class conversor {

    private static final String API_KEY = "0a78069e81e0b9f84f1f5b3a";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private static final String[] MONEDAS = {
            "ARS", "BRL", "COP", "EUR", "GBP", "JPY"
    };

    private static final String[] NOMBRES_MONEDAS = {
            "Peso Argentino", "Real Brasilero", "Peso Colombiano",
            "Euro", "Libra Esterlina", "Yen Japonés"
    };

    public static void main(String[] args) {
        int opcion = 0;


        Scanner teclado = new Scanner(System.in);
        while (opcion != MONEDAS.length * 2 + 1) {
            mostrarMenu();
            System.out.print("Elija una opción: ");
            opcion = teclado.nextInt();

            if (opcion == MONEDAS.length * 2 + 1) {
                System.out.println("Gracias por utilizar la aplicación...");
                break;
            }

            if (opcion < 1 || opcion > MONEDAS.length * 2) {
                System.out.println("Opción no válida. Intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double valor = teclado.nextDouble();

            try {
                if (opcion % 2 == 1) {
                    convertirMoneda("USD", MONEDAS[(opcion - 1) / 2], valor);
                } else {
                    convertirMoneda(MONEDAS[(opcion - 1) / 2], "USD", valor);
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }
        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("========================================");
        for (int i = 0; i < MONEDAS.length; i++) {
            System.out.printf("%2d) Dólar --> %s\n", i * 2 + 1, NOMBRES_MONEDAS[i]);
            System.out.printf("%2d) %s --> Dólar\n", i * 2 + 2, NOMBRES_MONEDAS[i]);
        }
        System.out.printf("%2d) Salir\n", MONEDAS.length * 2 + 1);
        System.out.println("========================================");
    }

    public static void convertirMoneda(String moneda, String a, double valor) throws IOException, InterruptedException {
        String url = API_URL + moneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        MonedaUtil monedaUtil = new MonedaUtil();
        double tasa = monedaUtil.obtenerTasaConversion(response.body(), a);
        if (tasa == 0) {
            System.out.println("No se pudo obtener la tasa de conversión.");
        } else {
            double resultado = valor * tasa;
            System.out.printf("El monto %.2f (%s) equivale a --> %.2f (%s)\n\n", valor, moneda, resultado, a);
        }
    }
}
