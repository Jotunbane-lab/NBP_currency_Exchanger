package service;

import java.math.BigDecimal;

public class ExchangeResult {
    private BigDecimal result;
    private int responseCode;
    private String errorMessage;

    public BigDecimal getResult() {
        return result;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ExchangeResult(BigDecimal result, int responseCode, String errorMessage) {
        this.result = result;
        this.responseCode = responseCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ExchangeResult{" +
                "result=" + result +
                ", responseCode=" + responseCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
