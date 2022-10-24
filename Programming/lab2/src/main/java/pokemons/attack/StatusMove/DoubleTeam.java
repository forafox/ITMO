package pokemons.attack.StatusMove;

import ru.ifmo.se.pokemon.*;
//Double Team raises the user's Evasiveness by one stage, thus making the user more difficult to hit.
public class DoubleTeam extends StatusMove {
   public DoubleTeam(){
       super(Type.NORMAL,0,0);
   }
    @Override
    protected String describe() {
        return "Using DoubleTeam";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.addEffect(new Effect().stat(Stat.EVASION, +2).turns(-1));
    }
}
