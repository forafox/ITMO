package task.object;

import task.persons.Character;

public enum Device implements Joyful{
    WATERSUPPLY("Устройство водопровода"),
    FONTAIN("Устройство фонтана");

    private String name;
    Device(String name){
        this.name=name;
    }

    @Override
    public void makeHappy(Character x){
    }

    @Override
    public String getName() {
        return name;
    }
}
