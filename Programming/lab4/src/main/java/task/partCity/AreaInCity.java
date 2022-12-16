package task.partCity;

public abstract class AreaInCity {
    private String name;

    public AreaInCity(){
        this.name="Часть города";
    }
    public AreaInCity(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
