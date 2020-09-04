package exchanger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NbpExchangeRateDownloader {
    public void check(String currencyCode) {
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");


            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
