package task.persons;

public class BabesNullExeption extends NullPointerException{
    public String getMessage(){
        return "Ошибка! Ссылка на эту малышку null!";
    }
}
