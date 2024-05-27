package edu.umb.cs680.hw16a;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LineChartObserverTest {
    @Test
    public void LineChartObserverTest() {
        Map<String,Double> m= new HashMap<String,Double>();
        m.put("LineChart",30.0);
        m.put("LineChart",50.0);

        StockQuoteObservable sQO = new StockQuoteObservable();
        LineChartObserver lineChartObserver = new LineChartObserver();
        sQO.addObserver(lineChartObserver);
        sQO.changeQuote("LineChart", 30.0);
        sQO.changeQuote("LineChart", 50.0);
        assertTrue(sQO.getMapValues().containsKey("LineChart"));
    }
}