package exchanger;

public class NbpExchangeRateResult {
    private NbpExchangeRateSeries series;
    private int responseCode;
    private String errorMessage;

    public NbpExchangeRateSeries getSeries() {
        return series;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public NbpExchangeRateResult(NbpExchangeRateSeries series, int responseCode, String errorMessage) {
        this.series = series;
        this.responseCode = responseCode;
        this.errorMessage = errorMessage;
    }
}
