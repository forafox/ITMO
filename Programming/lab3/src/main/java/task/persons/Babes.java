package task.persons;
public final class Babes extends Character{

    public BabesArrayWrapper group;
    public Babes(){super("Малышка");}
    public Babes(String name,String gender){
        super(name,gender);
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
