import java.util.*;
import javax.swing.ImageIcon;

public class PokemonEvolution {

        public static void getEvolution(Pokemon pokemons,Pokemon Epokemon){
    
        String pname = pokemons.getSuperName();
        if(pname == "Pikachu"){
            Epokemon = new Raichu("Raichu");
        }
        else if(pname == "Psyduck"){
            Epokemon = new Golduck("Golduck");
        }
        else if(pname == "Bulbasaur"){
            Epokemon = new Ivysaur("Ivysaur");
        }
        else if(pname == "Ivysaur"){
            Epokemon = new Venusaur("Venusaur");
        }
        else if(pname == "Charmander"){
            Epokemon = new Charmeleon("Charmeleon");
        }
        else if(pname == "Charmeleon"){
            Epokemon = new Charizard("Charizard");
        }
        else if(pname == "Squirtle"){
            Epokemon = new Charmeleon("Wartortle");
        }
        else if(pname == "Wartortle"){
            Epokemon = new Blastoise("Blastoise");
        }
        else if(pname == "Magikarp"){
            Epokemon = new Gyarados("Gyarados");
        }
        else if(pname == "Eevee"){
            int type = (int)(Math.random() * 3);
            if(type == 0)
                Epokemon = new Vaporeon("Vaporeon");
            else if(type == 1)
                Epokemon = new Jolteon("Jolteon");
            else if(type == 2)
                Epokemon = new Flareon("Flareon");
        }

        String newSuperName = Epokemon.getSuperName();
        String newName = Epokemon.getName();
        int newHp = Epokemon.getHp();
        int newMaxExp = Epokemon.getMaxExp();
        int newMaxHp = Epokemon.getMaxHp();
        int newMaxMp = Epokemon.getMaxMp();
        ImageIcon newImg = Epokemon.getImg();
        pokemons.SetPokemon(newSuperName, newName, newHp, newMaxHp, newMaxMp, newMaxExp);
        pokemons.setImg(newImg);
        pokemons.setSkill(Epokemon.getSkill0(),Epokemon.getSkill1(),Epokemon.getSkill2(),Epokemon.getSkill3());

    }
}