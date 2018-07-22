package weather;

import com.transport.Flyable;

import java.util.ArrayList;

/**
 * Created by lizavieta on 06.07.2018.
 */
public class Tower {

    public ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {

    }
    public void unregister(Flyable flyable) {

    }

    protected void conditionsChanged(){

    }
}
