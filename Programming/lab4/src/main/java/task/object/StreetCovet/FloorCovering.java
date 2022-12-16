package task.object.StreetCovet;

public abstract class FloorCovering {
    private String name;
    public FloorCovering(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
}
