Este proyecto es una aplicación simple en Java que permite convertir entre varias monedas usando la API de ExchangeRate-API.

## Características

- Convierte entre Dólar Estadounidense (USD) y varias monedas internacionales.
- Utiliza la API de ExchangeRate-API para obtener las tasas de conversión en tiempo real.
- Interfaz de línea de comandos fácil de usar.

## Requisitos

- JDK 11 o superior
- IDE IntelliJ IDEA
- Una clave de API de ExchangeRate-API (puedes obtener una en [ExchangeRate-API](https://www.exchangerate-api.com/))

## Instalación

1. Clona este repositorio:
    ```sh
    git clone https://github.com/tu_usuario/currency-converter.git
    cd "carpeta destino"
    ```

2. Configura tu clave de API en el archivo `conversor.java`:
    ```java
    private static final String API_KEY = "TU_API_KEY";
    ```

3. Ejecuta el archivo jar

## Configuración

Asegúrate de tener configurada la variable de entorno `JAVA_HOME` apuntando al JDK que estás usando. Puedes verificarlo con:
echo $JAVA_HOME

## Uso

Al ejecutar el programa, verás un menú con varias opciones para convertir entre USD y otras monedas. Simplemente selecciona la opción deseada e ingresa el monto a convertir.

========================================
 1) Dólar --> Peso Argentino
 2) Peso Argentino --> Dólar
 3) Dólar --> Real Brasilero
 4) Real Brasilero --> Dólar
 5) Dólar --> Peso Colombiano
 6) Peso Colombiano --> Dólar
 7) Dólar --> Euro
 8) Euro --> Dólar
 9) Dólar --> Libra Esterlina
10) Libra Esterlina --> Dólar
11) Dólar --> Yen Japonés
12) Yen Japonés --> Dólar
13) Salir
========================================
Elija una opción: "numero"
========================================
  
Ingrese el monto a convertir: "monto"

## ejemplo de uso:


![image](https://github.com/user-attachments/assets/17516bab-9787-4e72-a434-a08591556f53)

API Usada
Este proyecto utiliza la API de ExchangeRate-API para obtener las tasas de conversión de monedas en tiempo real.

URL de la API: https://v6.exchangerate-api.com/v6/
Endpoint: /latest/{MONEDA}
Método: GET

Ejemplo de llamada a la API para obtener la tasa de conversión de USD:
https://v6.exchangerate-api.com/v6/TU_API_KEY/latest/USD
