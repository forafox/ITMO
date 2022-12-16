package task.persons;

import java.util.ArrayList;

public enum Place {
    STREET("Улица"),
    FONTAIN("Фонтан"),
    DANDELION_THICKETS("Заросли одуванчиков"),
    REED_WATER_SUPPLY("Тростниковый водопровод"),
    BRIDGE("Мост через реку");
    private String name;
    ArrayList<String> objectOnPlace = new ArrayList<>();
    ArrayList<String> deviceDescription = new ArrayList<>();
    Place(String name){
        this.name=name;
    }

    public void addObjectOnPlace(String x){
        if (!objectOnPlace.contains(x)) objectOnPlace.add(x);
    }
    public String getObjectOnPlace(){
        var result = new StringBuilder();
        for(var placeElementName : objectOnPlace)
            result.append(placeElementName).append(", ");
        if((""+result).length()>2) return String.format("На "+getName()+" есть "+result.substring(0,result.length() - 2));
        else return "На месте "+getName()+" ничего нет";
    }

    public void addDeviceDescription(String x){
        if (!deviceDescription.contains(x)) deviceDescription.add(x);
    }
    public String getDeviceDescription(){
        var result = new StringBuilder();
        for(var placeElementName : deviceDescription)
            result.append(placeElementName).append(", ");
        if((""+result).length()>2) return String.format("Инструкции для "+getName()+"\n"+result.substring(0,result.length() - 2));
        else return " Инструкций для "+getName()+" нет ";
    }
    public String getName(){return this.name;}
}
