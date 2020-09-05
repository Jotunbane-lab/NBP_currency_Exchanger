package service;

import java.math.BigDecimal;

public class ExchangeResult {
    private BigDecimal result;
    private int responseCode;
    private String responseMessage;

    public BigDecimal getResult() {
        return result;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public ExchangeResult(BigDecimal result, int responseCode, String responseMessage) {
        this.result = result;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "ExchangeResult{" +
                "result=" + result +
                ", responseCode=" + responseCode +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
