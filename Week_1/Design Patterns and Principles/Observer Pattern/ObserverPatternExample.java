import java.util.*;

interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

interface Observer {
    void update(String stockName, double price);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void setStock(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

class MobileApp implements Observer {
    private String appName;
    public MobileApp(String appName) {
        this.appName = appName;
    }
    @Override
    public void update(String stockName, double price) {
        System.out.println(appName + " received update: " + stockName + " is now $" + price);
    }
}

class WebApp implements Observer {
    private String appName;
    public WebApp(String appName) {
        this.appName = appName;
    }
    @Override
    public void update(String stockName, double price) {
        System.out.println(appName + " received update: " + stockName + " is now $" + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStock("AAPL", 150.0);
        stockMarket.setStock("GOOGL", 2800.0);

        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStock("MSFT", 300.0);
    }
}
