package pokemons.attack.SpecialMove;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.*;
//????????//
//Powder Snow deals damage and has a 10% chance of freezing the target.
public class PowderSnow extends SpecialMove {
    private double FreezAccuracy=0.1;
    public PowderSnow(){
        super(Type.ICE,40,100);
    }
    @Override
    protected String describe() {
        return "Использует PowderSnow";
    }
    @Override//Наложение эффекта, если повезет
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() < FreezAccuracy) {
            new Effect().condition(Status.FREEZE).turns(-1);
        }
    }

}
