package edu.umb.cs680.hw16a;

public class StockEvent {

    public String ticker;
    public Double quote;

    public StockEvent(String ticker, Double quote){
        this.ticker=ticker;
        this.quote=quote;
    }

    public String getTicker(){
        return this.ticker;
    }

    public Double getQuote(){
        return this.quote;
    }
}
