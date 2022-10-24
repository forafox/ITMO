package pokemons.attack.PhysicalMove;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

//Double Hit deals damage and will strike twice (with 35 base power each time).
public class DoubleHit extends PhysicalMove {
    public DoubleHit(){
        super(Type.NORMAL,35,90,0,2);
    }
    @Override
    protected String describe() {
        return "Using DoubleHit";
    }
}
