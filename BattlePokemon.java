import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BattlePokemon extends JFrame {
    String pResult = "";
    ImageIcon s0 = new ImageIcon("Image/attack.png");
    ImageIcon s1 = new ImageIcon("Image/skill1.png");
    ImageIcon s2 = new ImageIcon("Image/skill2.png");
    ImageIcon s3 = new ImageIcon("Image/skill3.png");

    public BattlePokemon(Trainer trainer, Pokemon myPokemon, Pokemon enemy, ImageIcon img){
        super("Pokemon Battle");
        
        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/gym.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JLabel intro = new JLabel("Battle Pokemon");
        JButton home = new JButton(new ImageIcon("Image/go_back.png"));
        home.setBounds(1441, 0, 95, 50);
        background.add(home);

        home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainGame h = new MainGame(trainer);
                setVisible(false);
            }      
        }); 

        JLabel enemyPics = new JLabel(img);
        enemyPics.setBounds(1236, 100, 200, 200);
        background.add(enemyPics);

        JLabel trainerPics = new JLabel(trainer.getImg());
        trainerPics.setBounds(100, 100, 200, 200);
        background.add(trainerPics);

        JLabel enemyPokemon = new JLabel();
        enemyPokemon.setLayout(new FlowLayout()); 
        enemyPokemon.setBounds(861, 525, 450, 150);

        JLabel enemyStatus = new JLabel("Enemy Pokemon: " + enemy.getName() + "   HP: " + enemy.getHp() + "/" + enemy.getMaxHp());
        enemyStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
        enemyStatus.setForeground(Color.PINK);
        JLabel enemyPic = new JLabel(enemy.getImg());

        enemyPokemon.add(enemyStatus);
        enemyPokemon.add(enemyPic);
        background.add(enemyPokemon);

        JLabel mPokemon = new JLabel();
        mPokemon.setLayout(new FlowLayout()); 
        mPokemon.setBounds(200, 525, 500, 150);

        JLabel myStatus = new JLabel("My Pokemon: " + myPokemon.getName() + "   HP: " + myPokemon.getHp() + "/" + myPokemon.getMaxHp() + "   MP: " + myPokemon.getMp() + "/" + myPokemon.getMaxMp());
        myStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
        myStatus.setForeground(Color.CYAN);
        JLabel myPic = new JLabel(myPokemon.getImg());

        mPokemon.add(myStatus);
        mPokemon.add(myPic);
        background.add(mPokemon);

        JLabel selectAttack = new JLabel();
        selectAttack.setLayout(new FlowLayout());
        selectAttack.setBounds(0, 700, 1536, 200);

        if(myPokemon.getMp() < myPokemon.getSkill3())
            s3 = new ImageIcon("Image/skill3R.png");
        if(myPokemon.getMp() < myPokemon.getSkill2())
            s2 = new ImageIcon("Image/skill2R.png");
        if(myPokemon.getMp() < myPokemon.getSkill1())
            s1 = new ImageIcon("Image/skill1R.png");
        if(myPokemon.getMp() < myPokemon.getSkill0())
            s0 = new ImageIcon("Image/attackR.png");

        JButton skill0 = new JButton(s0);
        skill0.setPreferredSize(new Dimension(200, 200));
        skill0.setToolTipText("Use MP: " + myPokemon.getSkill0());     
        JButton skill1 = new JButton(s1);
        skill1.setPreferredSize(new Dimension(200, 200));
        skill1.setToolTipText("Use MP: " + myPokemon.getSkill1());     
        JButton skill2 = new JButton(s2);
        skill2.setPreferredSize(new Dimension(200, 200));
        skill2.setToolTipText("Use MP: " + myPokemon.getSkill2());     
        JButton skill3 = new JButton(s3);
        skill3.setPreferredSize(new Dimension(200, 200));
        skill3.setToolTipText("Use MP: " + myPokemon.getSkill3());     

        selectAttack.add(skill0);
        selectAttack.add(skill1);
        selectAttack.add(skill2);
        selectAttack.add(skill3);

            if(enemy.getHp() == 0){
                myPokemon.ExpUp(50);
                trainer.ExpUp(50);
                trainer.CoinUp(500);
                JLabel win = new JLabel(new ImageIcon("Image/youwin.png"));
                win.setBounds(0, 0, 1536, 500);
                background.add(win);
                ImageIcon winP = new ImageIcon("Image/win.png");
                JOptionPane.showMessageDialog(null, "Your reward\n" + "Coin: 500\n" + trainer.getName() + " EXP(+50)\n" + myPokemon.getName() + " EXP(+50)\n", "You win!", JOptionPane.INFORMATION_MESSAGE,winP);               
            }
            else if(myPokemon.getHp() == 0){
                myPokemon.ExpUp(25);
                trainer.ExpUp(25);
                trainer.CoinUp(250);
                JLabel lose = new JLabel(new ImageIcon("Image/youlose.png"));
                lose.setBounds(0, 0, 1536, 500);
                background.add(lose);
                ImageIcon loseP = new ImageIcon("Image/lose.png");
                JOptionPane.showMessageDialog(null, "Your reward\n" + "Coin: 250\n" + trainer.getName() + " EXP(+25)\n" + myPokemon.getName() + " EXP(+25)\n", "You lose!", JOptionPane.INFORMATION_MESSAGE,loseP);               
            }
            else{
                JLabel vs = new JLabel(new ImageIcon("Image/vs.gif"));
                vs.setLayout(new FlowLayout()); 
                vs.setBounds(0, 150, 1536, 200);
                background.add(vs);
                background.add(selectAttack);
            }

        int enemyNum = (int)(Math.random()*4);

        skill0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(myPokemon.getMp() < myPokemon.getSkill0()){
                    JOptionPane.showMessageDialog(null, "Your MP is not enough please use Potion.");
                }
                else{
                    myPokemon.attack(enemy,0);
                    pResult += "Enemy Pokemon: " + enemy.getName() + " get damage " + myPokemon.getSkill0() + ".\n";
                    if(enemy.getHp() > 0){
                        enemy.attack(myPokemon,enemyNum); 
                        pResult += "My Pokemon: " + myPokemon.getName() + " get damage " + myPokemon.enemyDamage(enemy,enemyNum) + ".";
                    }   
                    ImageIcon damageP = new ImageIcon("Image/damage.png");
                    JOptionPane.showMessageDialog(null, pResult, "Damage", JOptionPane.PLAIN_MESSAGE,damageP);
                    BattlePokemon bt = new BattlePokemon(trainer, myPokemon, enemy, img);
                    setVisible(false); 
                }
                
            }      
        });

        skill1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(myPokemon.getMp() < myPokemon.getSkill1()){
                    JOptionPane.showMessageDialog(null, "Your MP is not enough please use Potion.");
                }
                else{
                    myPokemon.attack(enemy,1);
                    pResult += "Enemy Pokemon: " + enemy.getName() + " get damage " + myPokemon.getSkill1() +".\n";
                    if(enemy.getHp() > 0){
                        enemy.attack(myPokemon,enemyNum);    
                        pResult += "My Pokemon: " + myPokemon.getName() + " get damage " + myPokemon.enemyDamage(enemy,enemyNum) + ".";
                    }                    
                    ImageIcon damageP = new ImageIcon("Image/damage.png");
                    JOptionPane.showMessageDialog(null, pResult, "Damage", JOptionPane.PLAIN_MESSAGE,damageP);
                    BattlePokemon bt = new BattlePokemon(trainer, myPokemon, enemy, img);
                    setVisible(false);
                }
            }      
        });

        skill2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(myPokemon.getMp() < myPokemon.getSkill2()){
                    JOptionPane.showMessageDialog(null, "Your MP is not enough please use Potion.");
                }
                else{
                    myPokemon.attack(enemy,2);
                    pResult += "Enemy Pokemon: " + enemy.getName() + " get damage " + myPokemon.getSkill2() +".\n";
                    if(enemy.getHp() > 0){
                        enemy.attack(myPokemon,enemyNum); 
                        pResult += "My Pokemon: " + myPokemon.getName() + " get damage " + myPokemon.enemyDamage(enemy,enemyNum) + ".";
                    }   
                    ImageIcon damageP = new ImageIcon("Image/damage.png");
                    JOptionPane.showMessageDialog(null, pResult, "Damage", JOptionPane.PLAIN_MESSAGE,damageP);
                    BattlePokemon bt = new BattlePokemon(trainer, myPokemon, enemy, img);
                    setVisible(false);
                }
            }      
        });

        skill3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(myPokemon.getMp() < myPokemon.getSkill3()){
                    JOptionPane.showMessageDialog(null, "Your MP is not enough please use Potion.");
                }
                else{
                    myPokemon.attack(enemy,3);
                    pResult += "Enemy Pokemon: " + enemy.getName() + " get damage " + myPokemon.getSkill3() +".\n";
                    if(enemy.getHp() > 0){
                        enemy.attack(myPokemon,enemyNum);  
                        pResult += "My Pokemon: " + myPokemon.getName() + " get damage " + myPokemon.enemyDamage(enemy,enemyNum) + ".";
                    }   
                    ImageIcon damageP = new ImageIcon("Image/damage.png");
                    JOptionPane.showMessageDialog(null, pResult, "Damage", JOptionPane.PLAIN_MESSAGE,damageP);
                    BattlePokemon bt = new BattlePokemon(trainer, myPokemon, enemy, img);
                    setVisible(false);
                }
            }      
        });   

        UIManager.put("ToolTip.background", Color.black);
        UIManager.put("ToolTip.foreground", Color.white);
        UIManager.put("ToolTip.font", new Font("SansSerif", Font.BOLD, 24));

        JButton potion = new JButton(new ImageIcon("Image/potion.png"));
        potion.setBounds(1336, 664, 200, 200);
        potion.setOpaque(false);
        potion.setContentAreaFilled(false);
        potion.setBorderPainted(false);
        JLabel numPotion = new JLabel("X" + trainer.getPotion());
        numPotion.setFont(new Font("Tahoma", Font.BOLD, 18));
        numPotion.setForeground(Color.YELLOW);
        potion.add(numPotion);

        potion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            if(myPokemon.getMp() == myPokemon.getMaxMp()){
                JOptionPane.showMessageDialog(null, "Your Pokemon has already full MP!", "Already Full MP!", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(trainer.getPotion() > 0){
                trainer.usePotion();
                myPokemon.getPotion();
                ImageIcon potionP = new ImageIcon("Image/potionS.png");
                JOptionPane.showMessageDialog(null, "My Pokemon: " + myPokemon.getName() + " have full MP.", "Use Potion", JOptionPane.INFORMATION_MESSAGE,potionP);
                BattlePokemon bt = new BattlePokemon(trainer, myPokemon, enemy, img);
                setVisible(false);
            }
            else{
                ImageIcon buy = new ImageIcon("Image/buy.png");
                int n = JOptionPane.showConfirmDialog(null, "Your Potion is empty , Do you want to buy more?", "Potion is empty", JOptionPane.YES_NO_OPTION);
                if(n == 0){
                    if(trainer.getCoin() >= 200){
                    trainer.CoinDown(200);
                    trainer.buyPotion();
                    ImageIcon buyS = new ImageIcon("Image/buysussess.png");
                    JOptionPane.showMessageDialog(null, "Buy Potion Success.", "Buy Potion", JOptionPane.INFORMATION_MESSAGE,buyS);
                    BattlePokemon bt = new BattlePokemon(trainer, myPokemon, enemy, img);
                    setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            }      
        });

        background.add(potion);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}