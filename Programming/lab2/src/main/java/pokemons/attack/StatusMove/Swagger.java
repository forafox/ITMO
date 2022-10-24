package pokemons.attack.StatusMove;

import ru.ifmo.se.pokemon.*;


//Swagger confuses the target and raises its Attack by two stages.
public class Swagger extends StatusMove {
    public Swagger(){
        super(Type.NORMAL,0,85);
    }
    @Override
    protected String describe() {
        return "Using Swagger";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.addEffect(new Effect().stat(Stat.ATTACK, +2).turns(-1));
    }

}
