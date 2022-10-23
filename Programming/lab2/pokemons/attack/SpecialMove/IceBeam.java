package pokemons.attack.SpecialMove;

import ru.ifmo.se.pokemon.*;

//Ice Beam deals damage and has a 10% chance of freezing the target.
public class IceBeam extends SpecialMove {
    private double IceAccuracy= 0.1;
    public IceBeam(){
        super(Type.ICE,90,100);
    }
    @Override
    protected String describe() {
        return "Использует IceBeam";
    }

    @Override//Наложение эффекта, если повезет
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() < IceAccuracy) {
            new Effect().condition(Status.FREEZE).turns(-1);
        }
    }

}
