import java.util.*;

public class PokemonRandomizer {

    public static ArrayList<Pokemon> getPokemons(int num){
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        if(num < 1){
            return pokemons;
        }

        int pokemonNumber = (int)(Math.random()*num) + 1;
        
        for(int i=0 ; i<pokemonNumber ; ++i){
            int type = (int)(Math.random() * 9);
            if(type == 0)
                pokemons.add(new Pikachu("Wild Pikachu"));
            else if(type == 1)
                pokemons.add(new Kabigon("Wild Kabigon"));
            else if(type == 2)
                pokemons.add(new Psyduck("Wild Psyduck"));
            else if(type == 3)
                pokemons.add(new Bulbasaur("Wild Bulbasaur"));   
            else if(type == 4)
                pokemons.add(new Charmander("Wild Charmander"));   
            else if(type == 6)
                pokemons.add(new Squirtle("Wild Squirtle")); 
            else if(type == 7)
                pokemons.add(new Magikarp("Wild Magikarp")); 
            else if(type == 8)
                pokemons.add(new Eevee("Wild Eevee"));
        }
        return pokemons;
    }
}