import javax.swing.ImageIcon;

public abstract class Pokemon {
    protected String name;
    protected String SuperName;
    protected int hp;
    protected int maxHp;
    protected int exp;
    protected int maxExp;
    protected int mp;
    protected int maxMp;

    public Pokemon(String name){
        this.name = name;
        this.hp = 0;
        this.exp = 0;
    }

    public Pokemon(String SuperName, String name, int minHp, int maxHp, int maxMp, int maxExp){
        this.SuperName = SuperName;
        this.name = name;
        this.hp = randomInt(minHp, maxHp);
        this.maxHp = this.hp;
        this.maxMp = maxMp;
        mp = maxMp;
        this.maxExp = maxExp;
    }

    public void SetPokemon(String SuperName, String name, int hp, int maxHp, int maxMp, int maxExp){
        this.SuperName = SuperName;
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        mp = maxMp;
        this.maxExp = maxExp;
        this.exp = 0;
    }

    public String getSuperName(){
        return SuperName;
    }

    public String getName(){
        return name;
    }

    public void editName(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public int getMp(){
        return mp;
    }

    public int getMaxMp(){
        return maxMp;
    }

    public int getExp(){
        if(exp >= maxExp)
            return maxExp;
        else
            return exp;
    }

    public int getMaxExp(){
        return maxExp;
    }

    public void ExpUp(int xp){
        exp += xp;
    }

    public void getFeed(){
        this.hp = this.maxHp;
    }

    public void getPotion(){
        this.mp = this.maxMp;
    }

    public void damage(int value){
        int currentHP = hp - value;
        if(currentHP >= 0){
            this.hp = currentHP;
        }
        else{
            this.hp = 0;
        }
    }

    public void useMp(int value){
        int currentMP = mp - value;
        if(currentMP >= 0){
            this.mp = currentMP;
        }
        else{
            this.mp = 0;
        }
    }

    public int enemyDamage(Pokemon enemy, int num){
        int Edamage = 0;
        if(num == 0){
            Edamage = enemy.getSkill0();
        }
        else if(num == 1){
            Edamage = enemy.getSkill1();
        }
        else if(num == 2){
            Edamage = enemy.getSkill2();
        }
        else if(num == 3){
            Edamage = enemy.getSkill3();
        }
        return Edamage;
    }

    private int randomInt(int min, int max) {
        int randNum = 0;
        randNum = (int) (Math.random() * ((max - min) + 1)) + min;
        return randNum;
    }

    public abstract void attack(Pokemon enemy, int skill);

    public abstract ImageIcon getImg();

    public abstract void setImg(ImageIcon newImg);

    public abstract int getSkill0();

    public abstract int getSkill1();

    public abstract int getSkill2();

    public abstract int getSkill3();

    public abstract void setSkill(int newSkill0,int newSkill1,int newSkill2,int newSkill3);
}