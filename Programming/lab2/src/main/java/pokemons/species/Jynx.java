package pokemons.species;

import pokemons.attack.PhysicalMove.*;
public class Jynx extends Smoochum{
    public  Jynx(){
        super("Jynx",1);
    }
    public Jynx(String name,int lvl){
        super(name,lvl);
        setStats(65,50,35,115,95,95);
        addMove(new DoubleSlap());
    }
}