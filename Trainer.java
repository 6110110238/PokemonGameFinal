import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import java.util.*;

public class Trainer {
    private ArrayList<Pokemon> bag;
    private String name;
    private int level = 1;
    private int exp = 0;
    private int maxExp = 100;
    private int coin = 1000;
    private ImageIcon img = new ImageIcon("Image/trainer1.jpg");
    private int berry = 5;
    private int potion = 5;
    private int pokeball = 10;
    private int greatball = 5;
    private int ultraball = 3;
    private int masterball = 1;

    public Trainer(String name){
        bag = new ArrayList<Pokemon>();
        bag.add(new Pikachu("Pikachu"));

        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return level;
    }

    public int getExp(){
        return exp;
    }

    public int getMaxExp(){
        return maxExp;
    }

    public int getCoin(){
        return coin;
    }

    public void CoinUp(int value){
        coin += value;
    }

    public void CoinDown(int value){
        coin -= value;
    }

    public void ExpUp(int exp){
        this.exp += exp;
        if(this.exp >= maxExp){
            level++;
            this.exp -= maxExp;
            maxExp += 100;
        }
    }

    public void setImg(ImageIcon newImg){
        img = newImg;
    }

    public ImageIcon getImg(){
        return img;
    }

    public int sumBag(){
        return bag.size();
    }

    public int getBerry(){
        return berry;
    }

    public void useBerry(){
        --berry;
    }

    public void buyBerry(){
        ++berry;
    }

    public int getPotion(){
        return potion;
    }

    public void usePotion(){
        --potion;
    }

    public void buyPotion(){
        ++potion;
    }

    public int getPokeball(){
        return pokeball;
    }

    public void usePokeball(){
        --pokeball;
    }

    public void buyPokeball(){
        ++pokeball;
    }

    public int getGreatball(){
        return greatball;
    }

    public void useGreatball(){
        --greatball;
    }

    public void buyGreatball(){
        ++greatball;
    }

    public int getUltraball(){
        return ultraball;
    }

    public void useUltraball(){
        --ultraball;
    }

    public void buyUltraball(){
        ++ultraball;
    }

    public int getMasterball(){
        return masterball;
    }

    public void useMasterball(){
        --masterball;
    }

    public void buyMasterball(){
        ++masterball;
    }

    public ArrayList<Pokemon> getBag(){
        return bag;
    }

    public void addBag(Pokemon enemy){
        bag.add(enemy);
    }
}