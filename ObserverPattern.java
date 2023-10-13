package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Subject interface defines the methods for registering, unregistering, and notifying observers
interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// DeliveryData class implements the Subject interface
class DeliveryData implements Subject {
    private List<Observer> observers;
    private String location;

    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation() {
        return "YPlace";
    }
}

// Observer interface defines the method for updating observers
interface Observer {
    void update(String location);
}

// Seller class implements the Observer interface for sellers
class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// User class implements the Observer interface for users
class User implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// DeliveryWarehouseCenter class implements the Observer interface for warehouse centers
class DeliveryWarehouseCenter implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        topic.locationChanged();

        // Unregister an observer (DeliveryWarehouseCenter)
        topic.unregister(obj3);

        System.out.println();
        topic.locationChanged();
    }
}
