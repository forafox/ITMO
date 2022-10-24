package pokemons.species;
import pokemons.attack.SpecialMove.*;
import pokemons.attack.StatusMove.*;
import ru.ifmo.se.pokemon.*;
public class ShayminLand extends Pokemon{
    public  ShayminLand(){
        super("ShayminLand",1);
    }
    public ShayminLand(String name, int lvl){
        super(name,lvl);
        setType(Type.GRASS);
        setStats(100,100,100,100,100,100);
        setMove(new DoubleTeam(),new Swagger(),new Growth(),new Psychic() );
    }
}
