import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangeImg extends JFrame {

    public ChangeImg(Trainer trainer){
        super("Choose Trainer");

        ImageIcon img1 = new ImageIcon("Image/trainer1.jpg");
        ImageIcon img2 = new ImageIcon("Image/trainer2.jpg");

        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/BG.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JLabel select = new JLabel();
        select.setLayout(new FlowLayout());
        select.setBounds(0, 207, 1536, 250);

        JButton trainer1 = new JButton(img1);
        trainer1.setOpaque(false);
        trainer1.setContentAreaFilled(false);
        trainer1.setBorderPainted(false);
        JButton trainer2 = new JButton(img2);
        trainer2.setOpaque(false);
        trainer2.setContentAreaFilled(false);
        trainer2.setBorderPainted(false);

        select.add(trainer1);
        select.add(trainer2);
        background.add(select);

        JLabel getStart = new JLabel("Select Trainer!");
        getStart.setFont(new Font("Ebrima", Font.BOLD, 24));
        getStart.setBounds(700, 152, 200, 50);
        background.add(getStart);

        trainer1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                trainer.setImg(img1);
                MainGame mg = new MainGame(trainer);
                setVisible(false);
            }      
        });

        trainer2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                trainer.setImg(img2);
                MainGame mg = new MainGame(trainer);
                setVisible(false);
            }      
        }); 

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true); 
    }
}