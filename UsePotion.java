import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UsePotion extends JFrame {

    public UsePotion(Trainer trainer){
        super("Use Potion");

        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        int num = 0;
        for(Pokemon p: trainer.getBag()){
            JLabel status = new JLabel("Name: " + p.getName() + "   MP: " + p.getMp() + "/" + p.getMaxMp());
            JLabel pic = new JLabel(p.getImg());
            JButton pokemonName = new JButton();
            pokemonName.setPreferredSize(new Dimension(400, 150));

            if(p.getMp() < p.getMaxMp()){
                pokemonName.add(pic);
                pokemonName.add(status);
                pokemonName.setLayout(new FlowLayout());
                
                num++;

                c.add(pokemonName);
            }

            pokemonName.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(trainer.getBerry() <= 0){
                        JOptionPane.showMessageDialog(null, "Your Potion is empty.");
                    }
                    else{
                        trainer.usePotion();
                        p.getPotion();
                        setVisible(false);
                    }
                }      
            });
        }

        if(num == 0){
            JLabel noPokemon = new JLabel("No Pokemon Need Potion.");
            noPokemon.setFont(new Font("Tahoma", Font.BOLD, 24));
            noPokemon.setForeground(Color.RED);
            c.add(noPokemon);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}