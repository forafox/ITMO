package task.persons;
import task.object.*;
public enum Work {
    FRUIT_GROWING("Выращивание фруктов"),
    VEGETABLES_GROWING("Выращивание овощей");
    private String name;
    Work(String name){
        this.name=name;
    }
    public String getNameWork(){return this.name;}
}
