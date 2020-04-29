import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyItem extends JFrame {

    public MyItem(Trainer trainer){
        super("My Item");

        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/BG8.jpg"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JLabel intro = new JLabel(new ImageIcon("Image/myitem.png")); 
        intro.setBounds(0, 0, 1536, 200);
        intro.setLayout(new FlowLayout()); 
        background.add(intro);

        JButton home = new JButton(new ImageIcon("Image/go_back.png"));
        home.setBounds(1441, 0, 95, 50);
        background.add(home);

        home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainGame h = new MainGame(trainer);
                setVisible(false);
            }      
        }); 

        JLabel money = new JLabel();
        money.setBounds(0, 0, 200, 100);
        money.setLayout(new FlowLayout()); 
        JLabel coin = new JLabel(new ImageIcon("Image/coinS.png"));
        JLabel myCoin = new JLabel(":" + trainer.getCoin());
        myCoin.setFont(new Font("Tahoma", Font.BOLD, 30));
        money.add(coin);
        money.add(myCoin);
        background.add(money);

        JLabel allItem = new JLabel();
        allItem.setBounds(0, 200, 1536, 864);
        allItem.setLayout(new FlowLayout()); 

        //Berry
        JLabel BerryPic = new JLabel(new ImageIcon("Image/berry.png"));
        JLabel BerryHead = new JLabel("Berry(X" + trainer.getBerry() + ")");
        BerryHead.setFont(new Font("Tahoma", Font.BOLD, 30));
        JButton Berry = new JButton(new ImageIcon("Image/slot4.png"));
        Berry.setPreferredSize(new Dimension(600, 200));
        Berry.setToolTipText("Feed this to your Pokemon to have full HP.");     
        Berry.setOpaque(false);
        Berry.setContentAreaFilled(false);
        Berry.setBorderPainted(false);

        Berry.add(BerryPic);
        Berry.add(BerryHead);
        Berry.setLayout(new BoxLayout(Berry, BoxLayout.X_AXIS));

        Berry.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(trainer.getBerry() > 0){
                    FeedPokemon fp = new FeedPokemon(trainer);
                }
                else{
                    ImageIcon buy = new ImageIcon("Image/buy.png");
                    int n = JOptionPane.showConfirmDialog(null, "Your Berry is empty , Do you want to buy more?", "Berry is empty", JOptionPane.YES_NO_OPTION);
                    if(n == 0){
                        if(trainer.getCoin() >= 200){
                        trainer.CoinDown(200);
                        trainer.buyBerry();
                        ImageIcon buyS = new ImageIcon("Image/buysussess.png");
                        JOptionPane.showMessageDialog(null, "Buy Berry Success.", "Buy Berry", JOptionPane.INFORMATION_MESSAGE,buyS);
                        MyItem mi = new MyItem(trainer);
                        setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }      
        }); 

        allItem.add(Berry);

        //Potion
        JLabel PotionPic = new JLabel(new ImageIcon("Image/potion.png"));
        JLabel PotionHead = new JLabel("Potion(X" + trainer.getPotion() + ")");
        PotionHead.setFont(new Font("Tahoma", Font.BOLD, 30));
        JButton Potion = new JButton(new ImageIcon("Image/slot4.png"));
        Potion.setPreferredSize(new Dimension(600, 200));
        Potion.setToolTipText("Use this to your Pokemon to have full MP."); 
        Potion.setOpaque(false);
        Potion.setContentAreaFilled(false);
        Potion.setBorderPainted(false);

        Potion.add(PotionPic);
        Potion.add(PotionHead);
        Potion.setLayout(new BoxLayout(Potion, BoxLayout.X_AXIS));

        Potion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(trainer.getBerry() > 0){
                    UsePotion up = new UsePotion(trainer);
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
                        MyItem mi = new MyItem(trainer);
                        setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }      
        }); 

        allItem.add(Potion);

        //Pokeball
        JLabel PokeballPic = new JLabel(new ImageIcon("Image/pokeball.png"));
        JLabel PokeballHead = new JLabel("Pokeball(X" + trainer.getPokeball() + ")");
        PokeballHead.setFont(new Font("Tahoma", Font.BOLD, 30));
        JButton Pokeball = new JButton(new ImageIcon("Image/slot4.png"));
        Pokeball.setPreferredSize(new Dimension(600, 200));
        Pokeball.setToolTipText("Use this to catch Pokemon. (have a 1/3 chance)"); 
        Pokeball.setOpaque(false);
        Pokeball.setContentAreaFilled(false);
        Pokeball.setBorderPainted(false);

        Pokeball.add(PokeballPic);
        Pokeball.add(PokeballHead);
        Pokeball.setLayout(new BoxLayout(Pokeball, BoxLayout.X_AXIS));

        allItem.add(Pokeball);

        //Greatball
        JLabel GreatballPic = new JLabel(new ImageIcon("Image/greatball.png"));
        JLabel GreatballHead = new JLabel("Greatball(X" + trainer.getGreatball() + ")");
        GreatballHead.setFont(new Font("Tahoma", Font.BOLD, 30));        
        JButton Greatball = new JButton(new ImageIcon("Image/slot4.png"));
        Greatball.setPreferredSize(new Dimension(600, 200));
        Greatball.setToolTipText("Use this to catch Pokemon. (have a 50% chance)"); 
        Greatball.setOpaque(false);
        Greatball.setContentAreaFilled(false);
        Greatball.setBorderPainted(false);

        Greatball.add(GreatballPic);
        Greatball.add(GreatballHead);
        Greatball.setLayout(new BoxLayout(Greatball, BoxLayout.X_AXIS));

        allItem.add(Greatball);

        //Ultraball
        JLabel UltraballPic = new JLabel(new ImageIcon("Image/ultraball.png"));
        JLabel UltraballHead = new JLabel("Ultraball(X" + trainer.getUltraball() + ")");
        UltraballHead.setFont(new Font("Tahoma", Font.BOLD, 30));
        JButton Ultraball = new JButton(new ImageIcon("Image/slot4.png"));
        Ultraball.setPreferredSize(new Dimension(600, 200));
        Ultraball.setToolTipText("Use this to catch Pokemon. (have a 2/3 chance)"); 
        Ultraball.setOpaque(false);
        Ultraball.setContentAreaFilled(false);
        Ultraball.setBorderPainted(false);

        Ultraball.add(UltraballPic);
        Ultraball.add(UltraballHead);
        Ultraball.setLayout(new BoxLayout(Ultraball, BoxLayout.X_AXIS));

        allItem.add(Ultraball);

        //Masterball
        JLabel MasterballPic = new JLabel(new ImageIcon("Image/masterball.png"));
        JLabel MasterballHead = new JLabel("Masterball(X" + trainer.getMasterball() + ")");
        MasterballHead.setFont(new Font("Tahoma", Font.BOLD, 30));
        JButton Masterball = new JButton(new ImageIcon("Image/slot4.png"));
        Masterball.setPreferredSize(new Dimension(600, 200));
        Masterball.setToolTipText("Use this to catch Pokemon. (have a 100% chance)"); 
        Masterball.setOpaque(false);
        Masterball.setContentAreaFilled(false);
        Masterball.setBorderPainted(false);

        Masterball.add(MasterballPic);
        Masterball.add(MasterballHead);
        Masterball.setLayout(new BoxLayout(Masterball, BoxLayout.X_AXIS));

        UIManager.put("ToolTip.background", Color.white);
        UIManager.put("ToolTip.foreground", Color.green);
        UIManager.put("ToolTip.font", new Font("SansSerif", Font.BOLD, 24));

        allItem.add(Masterball);

        background.add(allItem);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}