import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectPokemon extends JFrame {
    int n;

    public SelectPokemon(Trainer trainer,ImageIcon img,Pokemon enemy,int num){
        super("Select Your Pokemon");

        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/gym.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JButton home = new JButton(new ImageIcon("Image/go_back.png"));    
        home.setBounds(1441, 0, 95, 50);
        background.add(home);

        home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainGame mg = new MainGame(trainer);
                setVisible(false);
            }      
        }); 

        JLabel enemyPics = new JLabel(img);
        enemyPics.setBounds(1100, 200, 200, 200);
        background.add(enemyPics);

        JLabel enemyPic = new JLabel(enemy.getImg());
        JLabel enemyStatus = new JLabel();
        enemyStatus.setBounds(543, 200, 450, 150);
        enemyStatus.setLayout(new FlowLayout()); 
        JLabel enemyS = new JLabel("Enemy Pokemon: " + enemy.getName() + "   HP: " + enemy.getHp() + "/" + enemy.getMaxHp());
        enemyS.setFont(new Font("Tahoma", Font.BOLD, 20));
        enemyS.setForeground(Color.PINK);
        enemyStatus.add(enemyS);
        enemyStatus.add(enemyPic);
        
        background.add(enemyStatus);
        
        JLabel myPic = new JLabel(trainer.getImg());
        myPic.setBounds(236, 200, 200, 200);
        background.add(myPic);

        JLabel selectP = new JLabel();
        selectP.setBounds(0, 550, 1536, 150);
        selectP.setLayout(new FlowLayout());
        
        JButton left = new JButton(new ImageIcon("Image/button_left.png"));
        left.setBorderPainted(false);
        left.setBounds(600, 650, 100, 100);
        left.setOpaque(false);
        left.setContentAreaFilled(false);
        left.setBorderPainted(false);
        selectP.add(left);

        JButton select = new JButton(new ImageIcon("Image/slot2.png"));
        select.setPreferredSize(new Dimension(600, 150));
        select.setOpaque(false);
        select.setContentAreaFilled(false);
        select.setBorderPainted(false);
        JLabel pPic = new JLabel(trainer.getBag().get(num).getImg());
        JLabel pStatus = new JLabel("Name: " + trainer.getBag().get(num).getName() + "   HP: " + trainer.getBag().get(num).getHp() + "/" + trainer.getBag().get(num).getMaxHp() + "   MP: " + trainer.getBag().get(num).getMp() + "/" + trainer.getBag().get(num).getMaxMp());
        pStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
        pStatus.setForeground(Color.YELLOW);
        select.add(pPic);
        select.add(pStatus);
        select.setLayout(new FlowLayout()); 
        selectP.add(select);

        JButton right = new JButton(new ImageIcon("Image/button_right.png"));
        right.setBorderPainted(false);
        right.setBounds(1000, 650, 100, 100);
        right.setOpaque(false);
        right.setContentAreaFilled(false);
        right.setBorderPainted(false);
        selectP.add(right);

        n = num;
        left.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                n--;
                if(n < 0)
                    n = trainer.sumBag() - 1;
                    SelectPokemon er = new SelectPokemon(trainer,img,enemy,n);
                setVisible(false);
            }      
        }); 

        right.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                n++;
                if(n > trainer.sumBag() - 1)
                    n = 0;
                SelectPokemon er = new SelectPokemon(trainer,img,enemy,n);
                setVisible(false);
            }      
        }); 

        select.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(trainer.getBag().get(n).getHp() == trainer.getBag().get(n).getMaxHp()){
                    BattlePokemon bp = new BattlePokemon(trainer, trainer.getBag().get(n), enemy, img);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "My Pokemon: " + trainer.getBag().get(n).getName() + " have low HP.", "Feed you Pokemon!", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }      
        }); 

        background.add(selectP);        

        JLabel intro = new JLabel("Select Your Pokemon");
        intro.setLayout(new FlowLayout()); 
        intro.setFont(new Font("Tahoma", Font.BOLD, 30));
        intro.setForeground(Color.YELLOW);
        intro.setBounds(593, 450, 350, 100);

        background.add(intro);  
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}