package pokemons.species;

import ru.ifmo.se.pokemon.*;
import pokemons.attack.SpecialMove.*;

public class Smoochum extends Pokemon{
    public  Smoochum(){
        super("Smoochum",1);
    }
    public Smoochum(String name,int lvl){
        super(name,lvl);
        setType(Type.ICE,Type.PSYCHIC);
        setStats(45,30,15,85,65,65);
        setMove(new IceBeam(),new DreamEater(),new PowderSnow());
    }
}
