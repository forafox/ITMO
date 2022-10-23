package pokemons.attack.StatusMove;

import ru.ifmo.se.pokemon.*;
//Scary Face lowers the target's Speed by two stages.
public class ScaryFace extends StatusMove {
    public ScaryFace(){
        super(Type.NORMAL,0,100);
    }
    @Override
    protected String describe() {
        return "Использует ScaryFace";
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.addEffect(new Effect().stat(Stat.SPEED, -2).turns(-1));
    }
}
