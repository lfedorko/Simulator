package src.simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List<Flyable> it = new ArrayList<>(observers);
        for (Flyable flyable : it) {
            flyable.updateConditions();
        }
    }

    public int getObserversSize() {
        return observers.size();
    }
}