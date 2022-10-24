package pokemons.attack.PhysicalMove;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.*;
//Bite deals damage and has a 30% chance of causing the
// target to flinch (if the target has not yet moved).
public class Bite extends PhysicalMove {
    private final double flinchAccuracy=0.3;
    public Bite(){
        super(Type.DARK,60,100);
    }
    @Override
    protected String describe() {
        return "Using Bite";
    }
    @Override
    protected void	applyOppEffects(Pokemon pokemon){
        Status S=pokemon.getCondition();
        if(S==Status.SLEEP){
            if (Math.random() < flinchAccuracy) {
                Effect.flinch(pokemon);
            }
        }
    }
}
