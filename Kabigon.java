import javax.swing.ImageIcon;

public class Kabigon extends Pokemon {
    public static String SuperName = "Kabigon";
    private ImageIcon img = new ImageIcon("Image/kabigon.gif");
    private int AttackPoint = 10;
    private int Skill1 = 20;
    private int Skill2 = 30;
    private int Skill3 = 40;

    public Kabigon(String name){
        super(SuperName, name, 70, 100, 100, 100);
    }

    public void attack(Pokemon enemy, int skill) {
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        if(skill == 0){
            enemy.damage(AttackPoint);
            useMp(AttackPoint);
        }
        else if(skill == 1){
            enemy.damage(Skill1);
            useMp(Skill1);
        }            
        else if(skill == 2){
            enemy.damage(Skill2);
            useMp(Skill2);            
        }            
        else if(skill == 3){
            enemy.damage(Skill3);
            useMp(Skill3);            
        }
    }

    public ImageIcon getImg(){
        return img;
    }

    public void setImg(ImageIcon newImg){
        img = newImg;
    }

    public int getSkill0(){
        return AttackPoint;
    }

    public int getSkill1(){
        return Skill1;
    }

    public int getSkill2(){
        return Skill2;
    }

    public int getSkill3(){
        return Skill3;
    }

    public void setSkill(int newSkill0,int newSkill1,int newSkill2,int newSkill3){
        AttackPoint = newSkill0;
        Skill1 = newSkill1;
        Skill2 = newSkill2;
        Skill3 = newSkill3;
    }
}