package edu.umb.cs680.hw16a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeDObserverTest {
    @Test
    public void ThreeDObserverTest(){
        StockQuoteObservable sQO = new StockQuoteObservable();
        ThreeDObserver threeDObserver = new ThreeDObserver();
        sQO.addObserver(threeDObserver);
        sQO.changeQuote("_3D", 20.0);
        sQO.changeQuote("_3D", 50.0);

    }

}