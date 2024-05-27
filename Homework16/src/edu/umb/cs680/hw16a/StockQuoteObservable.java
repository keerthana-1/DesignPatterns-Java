package edu.umb.cs680.hw16a;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable<StockEvent>
{
    Map<String,Double> m= new HashMap<String,Double>();
    public void changeQuote(String t, Double q) {

        m.put(t,q);
        notifyObservers(new StockEvent(t,q));
    }

    public Map<String,Double> getMapValues(){
        return m;
    }
}
