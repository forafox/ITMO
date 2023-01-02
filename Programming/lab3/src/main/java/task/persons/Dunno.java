package task.persons;

public class Dunno extends Character{
    private static Dunno INSTANCEDUNNO;
    private Dunno() {
        super("Незнайка");
    }
    public static Dunno getInstance() {
        if (INSTANCEDUNNO == null) {
            INSTANCEDUNNO = new Dunno();
        }
        return INSTANCEDUNNO;
    }

}
