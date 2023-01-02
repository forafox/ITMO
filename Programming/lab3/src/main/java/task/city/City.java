package task.city;

import task.object.Joyful;
import task.persons.Character;
import task.persons.Place;

import java.util.ArrayList;

public abstract class City {

    ArrayList<String> sight = new ArrayList<>();
    private String name="";
    public City(){
        this.name="Город";
    }
    public City(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void addSight(Place... sightList){
        for (Place sightElement : sightList) {
            sight.add(sightElement.getName());
        }
    }

    public String getSight(){
        var result = new StringBuilder();
        for(var ElementName : sight)
            result.append(ElementName).append(", ");
        if((""+result).length()>2) return String.format("В городе "+getName()+" есть "+result.substring(0,result.length() - 2));
        else return "В городе "+getName()+" достопримечательностей нет";
    }

}
