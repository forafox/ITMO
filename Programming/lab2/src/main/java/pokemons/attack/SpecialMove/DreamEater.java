package pokemons.attack.SpecialMove;

import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

//Dream Eater deals damage only on sleeping
// foes and the user will recover 50% of the HP drained.

public class DreamEater extends SpecialMove {
    private double number=0;
    public DreamEater(){
        super(Type.PSYCHIC,100,100);
    }
    @Override
    protected String describe() {
        return "Using Dream Eater";
    }
    @Override
    protected void	applySelfEffects(Pokemon pokemon){
        number=pokemon.getHP();
        number=number*0.5;
        pokemon.addEffect(new Effect().stat(Stat.HP,+(int)number).turns(-1));
    }
}
