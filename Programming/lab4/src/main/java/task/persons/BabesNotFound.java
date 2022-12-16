package task.persons;

public class BabesNotFound extends Exception{

    public String getMessage(){
        return "Ошибка! В этом списке нет такой малышки";
    }
}
