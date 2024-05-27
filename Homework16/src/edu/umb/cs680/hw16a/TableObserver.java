package edu.umb.cs680.hw16a;

public class TableObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println(event.getTicker());
        System.out.println(event.getQuote());
    }
}
