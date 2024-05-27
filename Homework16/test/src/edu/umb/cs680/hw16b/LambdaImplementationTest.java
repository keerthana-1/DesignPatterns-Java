package edu.umb.cs680.hw16b;

import edu.umb.cs680.hw16a.StockQuoteObservable;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LambdaImplementationTest {
    @Test
    public void LambdaImplementation() {

        Map<String,Double> m= new HashMap<String,Double>();
        m.put("key1",20.0);

        StockQuoteObservable s = new StockQuoteObservable();
        s.addObserver(((sender, event) -> System.out.println(event.getTicker() + " " + event.getQuote())));
        s.changeQuote("key1", 20d);
        s.changeQuote("key2", 30d);
        assertTrue(s.getMapValues().containsKey("key1"));

        Map<String,Double> m1= new HashMap<String,Double>();
        m1.put("key3",20.0);

        s.addObserver(((sender1, event1) -> System.out.println(event1.getTicker() + " " + event1.getQuote())));
        s.changeQuote("key3", 20d);
        assertTrue(s.getMapValues().containsKey("key3"));
    }

}