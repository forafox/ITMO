package pokemons.species;

import ru.ifmo.se.pokemon.*;
import pokemons.attack.PhysicalMove.*;
public class Hydreigon extends Pokemon{
    public  Hydreigon(){
        super("Hydreigon",1);
    }
    public Hydreigon(String name,int lvl){
        super(name,lvl);
        setStats(92,105,90,125,90,98);
        addMove(new Bite());
    }
}
