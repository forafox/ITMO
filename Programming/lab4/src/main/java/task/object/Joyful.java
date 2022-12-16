package task.object;

import task.persons.Character;

public interface Joyful{//Нужен для того, чтобы был список веселья, у которого можно вызвать имя
    void makeHappy(Character x);

    String getName();
}
