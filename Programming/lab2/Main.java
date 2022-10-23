import pokemons.species.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {
    public static void main(String[] args){
        Battle b= new Battle();
        Pokemon p1 = new Deino("Cat",50);
        Pokemon p2 = new Deino("Dog",50);
        Pokemon p3 = new Deino("Bird",50);
        Pokemon p4 = new Deino("Fish",50);
        Pokemon p5 = new Deino("Duck",50);
        Pokemon p6 = new Deino("Lion",50);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
