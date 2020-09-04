package exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NbpExchangeRateDownloader {
    public NbpExchangeRateResult check(String currencyCode) {
        int responseCode = 0;
        NbpExchangeRateSeries series = null;
        String errorMessage = "N/A";
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));


            series = new ObjectMapper().readValue(br.readLine(), NbpExchangeRateSeries.class);

            responseCode = conn.getResponseCode();
            errorMessage = conn.getResponseMessage();


            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return (new NbpExchangeRateResult(series, responseCode, errorMessage));
    }


}
