package task.buildings;

import task.object.Furniture;
import task.object.Joyful;
import task.persons.Babes;
import task.persons.Character;
import task.persons.Place;

import java.util.ArrayList;

public abstract class Building implements HouseSweet {
    private String name;

    ArrayList<Character> invitedPerson = new ArrayList<>();
    ArrayList<Furniture> conditionList = new ArrayList<>();
    public Building(){
        this.name="Здание";
    }
    public Building(String name){
        this.name=name;
    }

    public void addPersonForInvited(Character ... characterList){
        for(Character person: characterList) {
            invitedPerson.add(person);
        }
    }
    public String getInvitedPerson(){ //Получение списка  гостей
        var result = new StringBuilder();
        for(Character person : invitedPerson)
            result.append(person.getName()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "Нет приглашенных гостей";
    }

    public void addConditionalList(Furniture ... furnitureList){//Добавление предметов в обстановку в доме
        for(Furniture x: furnitureList) {
            conditionList.add(x);
        }
    }
    public String getConditionalList(){ //Получение списка обстановки в доме
        var result = new StringBuilder();
        for(Furniture x : conditionList)
            result.append(x.getName()).append(", ");
        if((""+result).length()>2)return String.format(result.substring(0,result.length() - 2));
        else return "В доме ничего нет";
    }
    public String checkClear(){
        return conditionList.size()>2 ? " плохо и грязно " : " хорошо и чисто ";
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String getPhrase(){
        return "Этот -"+getName()+" такой хороший!";
    }
}
