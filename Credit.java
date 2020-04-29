import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Credit extends JFrame {

    public Credit(Trainer trainer){
        super("Credit");

        Container c = getContentPane();
        JButton background = new JButton(new ImageIcon("Image/credit.png"));
        background.setBounds(0, 0, 1536, 864);
        background.setOpaque(false);
        background.setContentAreaFilled(false);
        background.setBorderPainted(false);
        c.add(background);

        background.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainGame h = new MainGame(trainer);
                setVisible(false);
            }      
        }); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}