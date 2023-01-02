package task.object;
import task.persons.*;
public abstract class Berries {
    private String name;

    public Berries(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
         this.name=name;
    }
}
