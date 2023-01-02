package task.city;

import task.persons.Znayka;

public class FlowerCity extends City{
    private static FlowerCity INSTANCEFCITY;
    private FlowerCity() {
        super("Цветочный город");
    }
    public static FlowerCity getInstance() {
        if (INSTANCEFCITY == null) {
            INSTANCEFCITY = new FlowerCity();
        }
        return INSTANCEFCITY;
    }
}
