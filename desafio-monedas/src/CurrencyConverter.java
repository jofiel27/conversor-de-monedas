public class CurrencyConverter {
    private final String URL = "https://v6.exchangerate-api.com/v6/";
    private final String clave = "68b0f65f77d5eef60c0946e7";

    private final String moneda_arg = "ARS";
    private final String moneda_brazil = "BRL";
    private final String moneda_dolar = "USD";
    private final String moneda_euro = "EUR";

    private final ApiClient apiClient = new ApiClient();

    public void convertir(int opcion, int monto) {
        String URL_Final = null;

        switch (opcion) {
            case 1 -> URL_Final = URL + clave + "/pair/" + moneda_dolar + "/" + moneda_arg + "/" + monto;
            case 2 -> URL_Final = URL + clave + "/pair/" + moneda_arg + "/" + moneda_dolar + "/" + monto;
            case 3 -> URL_Final = URL + clave + "/pair/" + moneda_dolar + "/" + moneda_brazil + "/" + monto;
            case 4 -> URL_Final = URL + clave + "/pair/" + moneda_brazil + "/" + moneda_dolar + "/" + monto;
            case 5 -> URL_Final = URL + clave + "/pair/" + moneda_dolar + "/" + moneda_euro + "/" + monto;
            case 6 -> URL_Final = URL + clave + "/pair/" + moneda_euro + "/" + moneda_dolar + "/" + monto;
        }

        if (URL_Final != null) {
            double resultado = apiClient.obtenerConversion(URL_Final);
            System.out.println("Resultado: " + resultado);
        }
    }
}
