package task.object;
import task.persons.*;
import task.persons.Character;

public class Watermelon extends Berries implements Joyful{
    public Watermelon(){
        super("Арбуз");
    }

    @Override
    public void makeHappy(Character x) {
        x.changeInteres(1); //В будущем можно изменить на счастье
    }
}
