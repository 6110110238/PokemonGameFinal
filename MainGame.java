import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGame extends JFrame {

    public MainGame(Trainer trainer){
        super("Pokemon Game");

        Container c = getContentPane();   
        JLabel background = new JLabel(new ImageIcon("Image/BG11.jpg"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JButton exit = new JButton(new ImageIcon("Image/exit.png"));    
        exit.setBounds(1441, 0, 95, 50);
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        background.add(exit);

        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int n = JOptionPane.showConfirmDialog(null, "Do you want to exit game?","Exit game!", JOptionPane.YES_NO_OPTION);
                if(n==0){
                    setVisible(false);
                }
            }      
        }); 

        //Profile
        JLabel profile = new JLabel();
        profile.setBounds(0, 150, 1536, 250);
        profile.setLayout(new FlowLayout());

        JLabel character = new JLabel(trainer.getImg());

        JLabel empty = new JLabel();
        empty.setPreferredSize(new Dimension(50, 200));

        JLabel profileText = new JLabel();
        profileText.setPreferredSize(new Dimension(300, 230));
        profileText.setLayout(new BoxLayout(profileText, BoxLayout.Y_AXIS));

        JLabel intro1 = new JLabel("        Porfile");
        intro1.setFont(new Font("Mighty Brush", Font.BOLD, 35));
        intro1.setForeground(Color.blue);
        JLabel trainerName = new JLabel("   Name: " + trainer.getName());
        trainerName.setFont(new Font("Ebrima", Font.BOLD, 24));
        trainerName.setForeground(Color.WHITE);

        JButton level = new JButton();
        level.setOpaque(false);
        level.setContentAreaFilled(false);
        level.setBorderPainted(false);
        level.setLayout(new BoxLayout(level, BoxLayout.X_AXIS));
        JLabel lv = new JLabel(new ImageIcon("Image/lv.png"));
        level.add(lv);
        JLabel trainerLevel = new JLabel("  " + trainer.getLevel() + "    ");
        trainerLevel.setFont(new Font("Ebrima", Font.BOLD, 24));
        trainerLevel.setForeground(Color.GREEN);
        level.add(trainerLevel);
        JLabel exp = new JLabel(new ImageIcon("Image/exp.png"));
        level.add(exp);
        JLabel trainerExp = new JLabel("  " + trainer.getExp() + "/" + trainer.getMaxExp());
        trainerExp.setFont(new Font("Ebrima", Font.BOLD, 24));
        trainerExp.setForeground(Color.YELLOW);
        level.add(trainerExp);
  
        JButton pokemon = new JButton();
        pokemon.setOpaque(false);
        pokemon.setContentAreaFilled(false);
        pokemon.setBorderPainted(false);
        JLabel sumPokemonPic = new JLabel(new ImageIcon("Image/pokeballSS.png"));
        JLabel sumPokemon = new JLabel("  " + trainer.sumBag());
        sumPokemon.setFont(new Font("Ebrima", Font.BOLD, 24));
        sumPokemon.setForeground(Color.WHITE);
        
        pokemon.setLayout(new BoxLayout(pokemon, BoxLayout.X_AXIS));
        pokemon.add(sumPokemonPic);
        pokemon.add(sumPokemon);
        pokemon.setToolTipText("Sum of your Pokemon.");
        JButton coin = new JButton();
        coin.setOpaque(false);
        coin.setContentAreaFilled(false);
        coin.setBorderPainted(false);
        JLabel sumCoinPic = new JLabel(new ImageIcon("Image/coinSS.png"));
        JLabel sumCoin = new JLabel("  " + trainer.getCoin());
        sumCoin.setFont(new Font("Ebrima", Font.BOLD, 24));
        sumCoin.setForeground(Color.WHITE);

        coin.setLayout(new BoxLayout(coin, BoxLayout.X_AXIS));
        coin.add(sumCoinPic);
        coin.add(sumCoin);
        coin.setToolTipText("Your Coin.");


        profileText.add(intro1);
        profileText.add(trainerName);
        profileText.add(level);
        profileText.add(pokemon);
        profileText.add(coin);
        profile.add(character); 
        profile.add(empty);
        profile.add(profileText);  
        
        background.add(profile);

        JLabel profileSlot = new JLabel(new ImageIcon("Image/slot7.png"));
        profileSlot.setBounds(0, 145, 1536, 250);
        background.add(profileSlot);

        //Menu....
        JButton pokemonBag = new JButton(new ImageIcon("Image/yourpokemonS.png"));
        pokemonBag.setOpaque(false);
        pokemonBag.setContentAreaFilled(false);
        pokemonBag.setBorderPainted(false);
        JButton feedPokemon = new JButton(new ImageIcon("Image/myitemS.png"));
        feedPokemon.setOpaque(false);
        feedPokemon.setContentAreaFilled(false);
        feedPokemon.setBorderPainted(false);
        JButton catchPokemon = new JButton(new ImageIcon("Image/catchpokemonS.png"));
        catchPokemon.setOpaque(false);
        catchPokemon.setContentAreaFilled(false);
        catchPokemon.setBorderPainted(false);
        JButton battlePokemon = new JButton(new ImageIcon("Image/pokemonbattleS.png"));
        battlePokemon.setOpaque(false);
        battlePokemon.setContentAreaFilled(false);
        battlePokemon.setBorderPainted(false);
        JButton transferPokemon = new JButton(new ImageIcon("Image/transferpokemonS.png"));
        transferPokemon.setOpaque(false);
        transferPokemon.setContentAreaFilled(false);
        transferPokemon.setBorderPainted(false);
        JButton itemShop = new JButton(new ImageIcon("Image/itemshopS.png"));
        itemShop.setOpaque(false);
        itemShop.setContentAreaFilled(false);
        itemShop.setBorderPainted(false);
        JButton credit = new JButton(new ImageIcon("Image/creditS.png"));
        credit.setOpaque(false);
        credit.setContentAreaFilled(false);
        credit.setBorderPainted(false);

        JLabel menu = new JLabel();
        menu.setBounds(0, 500, 1536, 350);
        menu.setLayout(new FlowLayout()); 

        pokemonBag.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PokemonInBag pb = new PokemonInBag(trainer,0,5,1);
                setVisible(false);
            }
        });

        feedPokemon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MyItem mt = new MyItem(trainer);
                setVisible(false);
            }
        });

        catchPokemon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CatchPokemon cp = new CatchPokemon(trainer);
                setVisible(false);
            }      
        });

        battlePokemon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                enemyRandom er = new enemyRandom(trainer);
                setVisible(false);
            }  
        }); 

        transferPokemon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                TransferPokemon tf = new TransferPokemon(trainer,0,3,1);
                setVisible(false);
            }      
        });

        itemShop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ItemShop is = new ItemShop(trainer);
                setVisible(false);
            }      
        });

        credit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Credit is = new Credit(trainer);
                setVisible(false);
            }      
        });

        menu.add(pokemonBag);
        menu.add(feedPokemon);
        menu.add(catchPokemon);
        menu.add(battlePokemon);
        menu.add(transferPokemon);
        menu.add(itemShop);
        menu.add(credit);

        background.add(menu);     
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}