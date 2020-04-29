import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class enemyRandom extends JFrame {
    Pokemon EnemyPokemons;
    Pokemon pokemons;

    public enemyRandom(Trainer trainer){
        super("Random Enemy");

        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/gym.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JLabel intro = new JLabel(new ImageIcon("Image/pokemonbattle.png")); 
        intro.setBounds(0, 0, 1536, 200);
        intro.setLayout(new FlowLayout()); 
        background.add(intro);

        JButton home = new JButton(new ImageIcon("Image/go_back.png"));    
        home.setBounds(1441, 0, 95, 50);
        background.add(home);

        home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainGame mg = new MainGame(trainer);
                setVisible(false);
            }      
        }); 

        ImageIcon EnemyTrainer = EnemyRandomizer.getEnemyTrainer();         

        JLabel enemyPics = new JLabel(EnemyTrainer);
        enemyPics.setBounds(1100, 200, 200, 200);
        background.add(enemyPics);

        Pokemon enemy = EnemyRandomizer.getEnemyPokemon(EnemyPokemons);

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

        JLabel select = new JLabel();
        select.setBounds(0, 500, 1536, 256);
        select.setLayout(new FlowLayout()); 

        JButton ok = new JButton(new ImageIcon("Image/ok.png"));
        ok.setPreferredSize(new Dimension(256, 256));
        ok.setOpaque(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        select.add(ok);

        JButton random = new JButton(new ImageIcon("Image/random.png"));
        random.setPreferredSize(new Dimension(256, 256));
        random.setOpaque(false);
        random.setContentAreaFilled(false);
        random.setBorderPainted(false);
        select.add(random);

        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SelectPokemon sp = new SelectPokemon(trainer,EnemyTrainer,enemy,0);
                setVisible(false);
            }      
        }); 

        random.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                enemyRandom er = new enemyRandom(trainer);
                setVisible(false);
            }      
        });     
        
        background.add(select);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}