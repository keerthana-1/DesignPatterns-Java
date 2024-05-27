import edu.umb.cs680.hw16a.StockQuoteObservable;

public class Main {
    public static void main(String[] args) {

        StockQuoteObservable s=new StockQuoteObservable();
        s.addObserver(((sender, event) -> System.out.println(event.getTicker()+" "+event.getQuote())));
        s.changeQuote("key1",20d);
        s.changeQuote("key2",30d);

        s.addObserver(((sender1, event1) -> System.out.println(event1.getTicker()+" "+event1.getQuote())));
        s.changeQuote("key3",40d);
    }
}