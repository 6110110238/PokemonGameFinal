import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemShop extends JFrame {

    public ItemShop(Trainer trainer){
        super("My Item");

        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/BG10.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JLabel intro = new JLabel(new ImageIcon("Image/itemshop.png")); 
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
        myCoin.setForeground(Color.YELLOW);
        money.add(coin);
        money.add(myCoin);
        background.add(money);

        JLabel allItem = new JLabel();
        allItem.setBounds(0, 200, 1536, 864);
        allItem.setLayout(new FlowLayout()); 

        JLabel coin1 = new JLabel(new ImageIcon("Image/coinS.png"));
        JLabel coin2 = new JLabel(new ImageIcon("Image/coinS.png"));
        JLabel coin3 = new JLabel(new ImageIcon("Image/coinS.png"));
        JLabel coin4 = new JLabel(new ImageIcon("Image/coinS.png"));
        JLabel coin5 = new JLabel(new ImageIcon("Image/coinS.png"));
        JLabel coin6 = new JLabel(new ImageIcon("Image/coinS.png"));
        ImageIcon coinny = new ImageIcon("Image/coinS.png");

        //Berry
        JLabel BerryPic = new JLabel(new ImageIcon("Image/berry.png"));
        JLabel BerryPrice = new JLabel("   200");
        BerryPrice.setFont(new Font("Tahoma", Font.BOLD, 27));
        BerryPrice.setForeground(Color.YELLOW);

        JButton Berry = new JButton(new ImageIcon("Image/slot5.png"));
        Berry.setPreferredSize(new Dimension(600, 200));
        Berry.setToolTipText("Feed this to your Pokemon to have full HP.");     
        Berry.setOpaque(false);
        Berry.setContentAreaFilled(false);
        Berry.setBorderPainted(false);

        Berry.add(BerryPic);
        Berry.add(coin1);
        Berry.add(BerryPrice);
        Berry.setLayout(new BoxLayout(Berry, BoxLayout.X_AXIS));

        Berry.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(null, "Are you sure to buy this item?", null, JOptionPane.YES_NO_OPTION);
                if(n==0){
                    if(trainer.getCoin() >= 200){
                    trainer.buyBerry();
                    trainer.CoinDown(200);
                    JOptionPane.showMessageDialog(null, "Successful purchase!", null, JOptionPane.INFORMATION_MESSAGE, coinny);
                    ItemShop is = new ItemShop(trainer);
                    setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }      
        }); 

        allItem.add(Berry);

        //Potion
        JLabel PotionPic = new JLabel(new ImageIcon("Image/potion.png"));
        JLabel PotionPrice = new JLabel("   200");
        PotionPrice.setFont(new Font("Tahoma", Font.BOLD, 27));
        PotionPrice.setForeground(Color.YELLOW);

        JButton Potion = new JButton(new ImageIcon("Image/slot5.png"));
        Potion.setPreferredSize(new Dimension(600, 200));
        Potion.setToolTipText("Use this to your Pokemon to have full MP."); 
        Potion.setOpaque(false);
        Potion.setContentAreaFilled(false);
        Potion.setBorderPainted(false);

        Potion.add(PotionPic);
        Potion.add(coin2);
        Potion.add(PotionPrice);
        Potion.setLayout(new BoxLayout(Potion, BoxLayout.X_AXIS));

        Potion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(null, "Are you sure to buy this item?", null, JOptionPane.YES_NO_OPTION);
                if(n==0){
                    if(trainer.getCoin() >= 200){
                    trainer.buyPotion();
                    trainer.CoinDown(200);
                    JOptionPane.showMessageDialog(null, "Successful purchase!", null, JOptionPane.INFORMATION_MESSAGE, coinny);
                    ItemShop is = new ItemShop(trainer);
                    setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }      
        }); 

        allItem.add(Potion);

        //Pokeball
        JLabel PokeballPic = new JLabel(new ImageIcon("Image/pokeball.png"));
        JLabel PokeballPrice = new JLabel("   300");
        PokeballPrice.setFont(new Font("Tahoma", Font.BOLD, 27));
        PokeballPrice.setForeground(Color.YELLOW);

        JButton Pokeball = new JButton(new ImageIcon("Image/slot5.png"));
        Pokeball.setPreferredSize(new Dimension(600, 200));
        Pokeball.setToolTipText("Use this to catch Pokemon. (have a 1/3 chance)"); 
        Pokeball.setOpaque(false);
        Pokeball.setContentAreaFilled(false);
        Pokeball.setBorderPainted(false);

        Pokeball.add(PokeballPic);
        Pokeball.add(coin3);
        Pokeball.add(PokeballPrice);
        Pokeball.setLayout(new BoxLayout(Pokeball, BoxLayout.X_AXIS));

        Pokeball.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(null, "Are you sure to buy this item?", null, JOptionPane.YES_NO_OPTION);
                if(n==0){
                    if(trainer.getCoin() >= 300){
                    trainer.buyPokeball();
                    trainer.CoinDown(300);
                    JOptionPane.showMessageDialog(null, "Successful purchase!", null, JOptionPane.INFORMATION_MESSAGE, coinny);
                    ItemShop is = new ItemShop(trainer);
                    setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }      
        }); 

        allItem.add(Pokeball);

        //Greatball
        JLabel GreatballPic = new JLabel(new ImageIcon("Image/greatball.png"));
        JLabel GreatballPrice = new JLabel("   400");
        GreatballPrice.setFont(new Font("Tahoma", Font.BOLD, 27));
        GreatballPrice.setForeground(Color.YELLOW);

        JButton Greatball = new JButton(new ImageIcon("Image/slot5.png"));
        Greatball.setPreferredSize(new Dimension(600, 200));
        Greatball.setToolTipText("Use this to catch Pokemon. (have a 50% chance)"); 
        Greatball.setOpaque(false);
        Greatball.setContentAreaFilled(false);
        Greatball.setBorderPainted(false);

        Greatball.add(GreatballPic);
        Greatball.add(coin4);
        Greatball.add(GreatballPrice);
        Greatball.setLayout(new BoxLayout(Greatball, BoxLayout.X_AXIS));

        Greatball.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(null, "Are you sure to buy this item?", null, JOptionPane.YES_NO_OPTION);
                if(n==0){
                    if(trainer.getCoin() >= 400){
                    trainer.buyGreatball();
                    trainer.CoinDown(400);
                    JOptionPane.showMessageDialog(null, "Successful purchase!", null, JOptionPane.INFORMATION_MESSAGE, coinny);
                    ItemShop is = new ItemShop(trainer);
                    setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if(n==1){}
                
            }      
        }); 

        allItem.add(Greatball);

        //Ultraball
        JLabel UltraballPic = new JLabel(new ImageIcon("Image/ultraball.png"));
        JLabel UltraballPrice = new JLabel("   500");
        UltraballPrice.setFont(new Font("Tahoma", Font.BOLD, 27));
        UltraballPrice.setForeground(Color.YELLOW);

        JButton Ultraball = new JButton(new ImageIcon("Image/slot5.png"));
        Ultraball.setPreferredSize(new Dimension(600, 200));
        Ultraball.setToolTipText("Use this to catch Pokemon. (have a 2/3 chance)"); 
        Ultraball.setOpaque(false);
        Ultraball.setContentAreaFilled(false);
        Ultraball.setBorderPainted(false);

        Ultraball.add(UltraballPic);
        Ultraball.add(coin5);
        Ultraball.add(UltraballPrice);
        Ultraball.setLayout(new BoxLayout(Ultraball, BoxLayout.X_AXIS));

        Ultraball.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(null, "Are you sure to buy this item?", null, JOptionPane.YES_NO_OPTION);
                if(n==0){
                    if(trainer.getCoin() >= 500){
                    trainer.buyUltraball();
                    trainer.CoinDown(500);
                    JOptionPane.showMessageDialog(null, "Successful purchase!", null, JOptionPane.INFORMATION_MESSAGE, coinny);
                    ItemShop is = new ItemShop(trainer);
                    setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }      
        }); 

        allItem.add(Ultraball);

        //Masterball
        JLabel MasterballPic = new JLabel(new ImageIcon("Image/masterball.png"));
        JLabel MasterballPrice = new JLabel("   600");
        MasterballPrice.setFont(new Font("Tahoma", Font.BOLD, 27));
        MasterballPrice.setForeground(Color.YELLOW);

        JButton Masterball = new JButton(new ImageIcon("Image/slot5.png"));
        Masterball.setPreferredSize(new Dimension(600, 200));
        Masterball.setToolTipText("Use this to catch Pokemon. (have a 100% chance)"); 
        Masterball.setOpaque(false);
        Masterball.setContentAreaFilled(false);
        Masterball.setBorderPainted(false);

        Masterball.add(MasterballPic);
        Masterball.add(coin6);
        Masterball.add(MasterballPrice);
        Masterball.setLayout(new BoxLayout(Masterball, BoxLayout.X_AXIS));

        Masterball.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(null, "Are you sure to buy this item?", null, JOptionPane.YES_NO_OPTION);
                if(n==0){
                    if(trainer.getCoin() >= 600){
                    trainer.buyMasterball();
                    trainer.CoinDown(600);
                    JOptionPane.showMessageDialog(null, "Successful purchase!", null, JOptionPane.INFORMATION_MESSAGE, coinny);
                    ItemShop is = new ItemShop(trainer);
                    setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }  
                }
            }      
        }); 

        allItem.add(Masterball);

        UIManager.put("ToolTip.background", Color.black);
        UIManager.put("ToolTip.foreground", Color.yellow);
        UIManager.put("ToolTip.font", new Font("SansSerif", Font.BOLD, 24));

        background.add(allItem);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}