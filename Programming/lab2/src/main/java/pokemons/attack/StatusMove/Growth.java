package pokemons.attack.StatusMove;

import ru.ifmo.se.pokemon.*;
//Growth raises the user's Attack and Special Attack by one stage each
//During harsh sunlight it raises each stat by two stages.
public class Growth extends StatusMove {
    public Growth(){
        super(Type.NORMAL,0,0);
    }
    @Override
    protected String describe() {
        return "Using Growth";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.addEffect(new Effect().stat(Stat.SPECIAL_ATTACK, +1).stat(Stat.ATTACK, +1).turns(-1));
    }
}