package task.persons;
import task.object.*;
public class Solomka extends Character{
    private static Solomka INSTANCETWO;
    private Solomka() {
        super("Соломка");
    }
    public static Solomka getInstance() {
        if (INSTANCETWO == null) {
            INSTANCETWO = new Solomka();
        }
        return INSTANCETWO;
    }

}
