package exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NbpExchangeRateDownloader {
    private static NbpExchangeRateDownloader instance;

    private NbpExchangeRateDownloader() {
    }

    public static NbpExchangeRateDownloader getInstance() {
        if(instance == null){
            instance = new NbpExchangeRateDownloader();
        }
        return instance;
    }

    public NbpExchangeRateResult check(String currencyCode) {
        int responseCode = 0;
        NbpExchangeRateSeries series = null;
        String responseMessage = "N/A";
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode+"/last/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));


            series = new ObjectMapper().readValue(br.readLine(), NbpExchangeRateSeries.class);

            responseCode = conn.getResponseCode();
            responseMessage = conn.getResponseMessage();


            conn.disconnect();

        } catch (IOException e) {
            System.out.println(e);
        }
        return new NbpExchangeRateResult(series, responseCode, responseMessage);
    }


}
