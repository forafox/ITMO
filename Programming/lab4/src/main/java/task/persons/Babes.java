package task.persons;

import task.buildings.Building;

public final class Babes extends Character{

    public BabesArrayWrapper group;
    public Babes(){super("Малышка");}
    public Babes(String name,String gender){
        super(name,gender);
    }
    private Building building;

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
    public void say(){
        System.out.println(getName()+" сказал :"+building.getPhrase());
    }

    public void setGroup(BabesArrayWrapper group){
        this.group=group;
    }
    public BabesArrayWrapper getGroup(){
        return this.group;
    }
    public void removeFromArray(BabesArrayWrapper group)throws BabesNotFound{
        try{
            group.removeBabes(this);
        }catch (BabesNotFound e){
            System.out.println(e.getMessage());
        }
    }

}
