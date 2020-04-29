import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedPokemon extends JFrame {

    public FeedPokemon(Trainer trainer){
        super("Feed Pokemon");

        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        int num = 0;
        for(Pokemon p: trainer.getBag()){
            JLabel status = new JLabel("Name: " + p.getName() + "   HP: " + p.getHp() + "/" + p.getMaxHp());
            JLabel pic = new JLabel(p.getImg());
            JButton pokemonName = new JButton();
            pokemonName.setPreferredSize(new Dimension(400, 150));

            if(p.getHp() < p.getMaxHp()){
                pokemonName.add(pic);
                pokemonName.add(status);
                pokemonName.setLayout(new FlowLayout());
                num++;

                c.add(pokemonName);
            }

            pokemonName.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(trainer.getBerry() <= 0){
                        JOptionPane.showMessageDialog(null, "Your Berry is empty.");
                    }
                    else{
                        trainer.useBerry();
                        p.getFeed();
                        setVisible(false);
                    }
                }      
            });
        }

        if(num == 0){
            JLabel noPokemon = new JLabel("No Pokemon Need Berry.");
            noPokemon.setFont(new Font("Tahoma", Font.BOLD, 24));
            noPokemon.setForeground(Color.RED);
            c.add(noPokemon);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}