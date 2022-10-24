package pokemons.attack.StatusMove;

import ru.ifmo.se.pokemon.*;
//Psychic deals damage and has a 10% chance of
//lowering the target's Special Defense by one stage.
public class Psychic extends StatusMove {
    private double loweringAccuracy = 0.1;

    public Psychic() {
        super(Type.PSYCHIC, 90, 100);
    }

    @Override
    protected String describe() {
        return "Using Psychic";
    }

    @Override//Наложение эффекта, если повезет
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() < loweringAccuracy) {
            new Effect().stat(Stat.SPECIAL_DEFENSE, -1).turns(-1);
        }
    }
}