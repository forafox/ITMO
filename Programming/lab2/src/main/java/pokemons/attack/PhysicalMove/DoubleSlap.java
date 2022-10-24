package pokemons.attack.PhysicalMove;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.*;
public class DoubleSlap extends PhysicalMove {
    public DoubleSlap(){
        super(Type.PSYCHIC,15,85);
    }

    @Override
    protected double calcRandomDamage(Pokemon p1, Pokemon p2) {
        double result = super.calcRandomDamage(p1, p2);
        int restore=0;
        while(restore<=5) {
            if ((this.power < 100 && Math.random() * 8 < 3) || (this.power < 125 && Math.random() * 8 < 1)) {
                this.power += 15;
                restore++;
                attack(p1, p2);
            }
            else {
                break;
            }
        }
        return result;
    }

    @Override
    protected String describe() {
        return "Using DoubleSlap";
    }

}
