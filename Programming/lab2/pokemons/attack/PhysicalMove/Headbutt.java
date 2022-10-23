package pokemons.attack.PhysicalMove;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

//Headbutt deals damage and has a 30% chance of causing the target to flinch (if the target has not yet moved).
public class Headbutt extends PhysicalMove {
    private double flinchAccuracy = 0.3;//Базовая вероятность

    public Headbutt() {
        super(Type.NORMAL, 70, 100);//Создаем объект
    }
    @Override //Вывод сообщения об атаке
    protected String describe() {
        return "Использует Headbutt";
    }
    @Override //Наложение эффекта, если повезет
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() < flinchAccuracy) {
            Effect.flinch(pokemon);
        }
    }
}

