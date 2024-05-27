package edu.umb.cs680.hw16a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableObserverTest {

    @Test
    public void TableObserverTest(){
        StockQuoteObservable sQO = new StockQuoteObservable();
        TableObserver table = new TableObserver();
        sQO.addObserver(table);
        sQO.changeQuote("Table", 10.0);
        sQO.changeQuote("Table", 20.0);
    }

}