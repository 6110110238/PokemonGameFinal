import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartGame extends JFrame {

    public StartGame(){
        super("Pokemon Game");

        Container c = getContentPane();   
        JLabel background = new JLabel(new ImageIcon("Image/BG.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JLabel icon = new JLabel(new ImageIcon("Image/logo.png"));
        icon.setBounds(0, 210, 1536, 442);
        background.add(icon);

        JButton start = new JButton();
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setBounds(0, 0, 1536, 864);
        start.setLayout(new FlowLayout());
        background.add(start);

        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = (String)JOptionPane.showInputDialog(null, "Trainer Name?", "Enter your Name.", JOptionPane.PLAIN_MESSAGE);

                if((name != null) && (name.length() > 0)){
                    Trainer t = new Trainer(name);
                    ChangeImg cm = new ChangeImg(t);
                    setVisible(false);
                }
                
            }      
        });   
        
        JLabel getStart = new JLabel("Start Game!");
        getStart.setFont(new Font("Ebrima", Font.BOLD, 24));
        getStart.setBounds(700, 752, 200, 50);
        background.add(getStart);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}