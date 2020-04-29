import java.util.*;
import javax.swing.ImageIcon;

public class EnemyRandomizer {

    public static ImageIcon getEnemyTrainer(){
        ImageIcon img = new ImageIcon();

        int TrainerNumber = (int)(Math.random()*4);
        
        if(TrainerNumber == 0)
            img = new ImageIcon("Image/trainer3.png");
        else if(TrainerNumber == 1)
            img = new ImageIcon("Image/trainer4.png");
        else if(TrainerNumber == 2)
            img = new ImageIcon("Image/trainer5.png");
        else if(TrainerNumber == 3)
            img = new ImageIcon("Image/trainer6.png");
        
        return img;
    }

    public static Pokemon getEnemyPokemon(Pokemon pokemons) {
        int type = (int)(Math.random() * 20);

        if(type == 0)
            pokemons = new Pikachu("Pikachu");
        else if(type == 1)
            pokemons = new Kabigon("Kabigon");
        else if(type == 2)
            pokemons = new Psyduck("Psyduck");
        else if(type == 3)
            pokemons = new Raichu("Raichu");
        else if(type == 4)
            pokemons = new Golduck("Golduck");
        else if(type == 5)
            pokemons = new Bulbasaur("Bulbasaur");
        else if(type == 6)
            pokemons = new Ivysaur("Ivysaur");
        else if(type == 7)
            pokemons = new Venusaur("Venusaur");
        else if(type == 8)
            pokemons = new Charmander("Charmander");
        else if(type == 9)
            pokemons = new Charmeleon("Charmeleon");
        else if(type == 10)
            pokemons = new Charizard("Charizard");
        else if(type == 11)
            pokemons = new Squirtle("Squirtle");
        else if(type == 12)
            pokemons = new Wartortle("Wartortle");
        else if(type == 13)
            pokemons = new Blastoise("Blastoise");
        else if(type == 14)
            pokemons = new Magikarp("Magikarp");
        else if(type == 15)
            pokemons = new Gyarados("Gyarados");
        else if(type == 16)
            pokemons = new Eevee("Eevee");
        else if(type == 17)
            pokemons = new Vaporeon("Vaporeon");
        else if(type == 18)
            pokemons = new Jolteon("Jolteon");
        else if(type == 19)
            pokemons = new Flareon("Flareon");

        return pokemons; 
    } 

}