package pokemons.species;

import pokemons.attack.PhysicalMove.*;

public class Zweilous extends Deino{
    public Zweilous(String name,int lvl){
        super(name,lvl);
        setStats(72,85,70,65,70,58);
        addMove(new DoubleHit());
    }
}
