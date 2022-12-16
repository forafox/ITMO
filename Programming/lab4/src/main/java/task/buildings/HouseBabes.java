package task.buildings;

public class HouseBabes extends Building{
    public HouseBabes(){
        super();
    }
    public HouseBabes(String name){
        super(name);
    }

    @Override
    public String getPhrase(){
        return "Нам здесь так хорошо!";
    }
}
