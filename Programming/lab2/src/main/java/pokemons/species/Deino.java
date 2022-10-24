package pokemons.species;

import pokemons.attack.PhysicalMove.*;
import pokemons.attack.StatusMove.*;
import ru.ifmo.se.pokemon.*;

public class Deino extends Pokemon {
    public  Deino(){
        super("Deino",1);
    }
    public Deino(String name,int lvl){
        super(name,lvl);
        setType(Type.DARK,Type.DRAGON);
        setStats(52,65,50,45,50,38);
        setMove(new Headbutt(),new ScaryFace());
    }
}
