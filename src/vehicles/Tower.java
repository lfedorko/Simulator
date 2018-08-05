package vehicles;

import vehicles.Flyable;
import java.io.IOException;
import java.util.ArrayList;

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (!this.observers.contains(flyable)) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        if (this.observers.contains(flyable)) {
            observers.remove(flyable);
        }
    }

    protected void conditionsChanged() throws IOException {
        int size = observers.size();
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
            if (size > observers.size()) {
                i--;
                size--;
            }
        }

    }

    public int getObserversSize() {
        return observers.size();
    }
}