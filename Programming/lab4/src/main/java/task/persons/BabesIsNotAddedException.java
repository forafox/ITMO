package task.persons;

public class BabesIsNotAddedException extends Exception{

    public String getMessage(){
        return "Ошибка! Эту малышку невозможно добавить";
    }
}
