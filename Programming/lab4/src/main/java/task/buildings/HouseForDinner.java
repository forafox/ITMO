package task.buildings;

/**
 * @author Karabanov Andrey
 * @version 1.0
 * @date 09.12.2022 13:31
 */
public class HouseForDinner extends Building {
    public HouseForDinner(String name){
        super(name);
    }
    public HouseForDinner(){
        super();
    }
    @Override
    public String getPhrase(){
        return "Как же здесь вкусно!";
    }
}
