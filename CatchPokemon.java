import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CatchPokemon extends JFrame {

    public CatchPokemon(Trainer trainer){
        super("Catch Pokemon");

        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/BG9.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JButton home = new JButton(new ImageIcon("Image/go_back.png"));    
        home.setBounds(1441, 0, 95, 50);
        background.add(home);

        home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainGame h = new MainGame(trainer);
                setVisible(false);
            }      
        });

        JLabel intro = new JLabel("Pokemon around you..!");
        intro.setLayout(new FlowLayout()); 
        intro.setFont(new Font("Tahoma", Font.BOLD, 30));
        intro.setForeground(Color.YELLOW);
        intro.setBounds(593, 350, 350, 100);

        background.add(intro);  


        ArrayList<Pokemon> pokemons = PokemonRandomizer.getPokemons(5);

        JLabel enemy = new JLabel();
        enemy.setBounds(0, 650, 1536, 200);
        enemy.setLayout(new FlowLayout()); 
        for(Pokemon p: pokemons){
            JLabel status = new JLabel("Name: " + p.getName() + "   HP: " + p.getHp());
            status.setFont(new Font("Tahoma", Font.BOLD, 18));
            JLabel pic = new JLabel(p.getImg());
            JButton enemyName = new JButton();
            enemyName.setPreferredSize(new Dimension(300, 150));
            enemyName.setLayout(new FlowLayout());
            enemyName.setOpaque(false);
            enemyName.setContentAreaFilled(false);
            enemyName.setBorderPainted(false);

            enemyName.add(status);
            enemyName.add(pic);            

            enemy.add(enemyName);

            enemyName.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    SelectBall sb = new SelectBall(trainer , p, false, null);
                    setVisible(false);
                }      
            });
        }
        background.add(enemy);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}