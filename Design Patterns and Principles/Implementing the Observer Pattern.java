import java.util.*;

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

interface Observer {
    void update(String stockName, double price);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("MobileApp: " + stockName + " updated to ₹" + price);
    }
}

class WebApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("WebApp: " + stockName + " updated to ₹" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        market.register(mobileApp);
        market.register(webApp);

        market.setStockPrice("TCS", 3560.75);
        market.setStockPrice("INFY", 1452.40);

        market.deregister(webApp);
        market.setStockPrice("WIPRO", 412.90);
    }
}