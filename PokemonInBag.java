import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PokemonInBag extends JFrame {
    Pokemon Epokemon;
    int num = 0;
    int nMin;
    int nMax;
    int page;
    int nPage;

    public PokemonInBag(Trainer trainer, int min, int max, int pages){
        super("Pokemon in bag");

        this.page = pages;

        Container c = getContentPane(); 
        JLabel background = new JLabel(new ImageIcon("Image/BG7.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JLabel intro = new JLabel(new ImageIcon("Image/yourpokemon.png")); 
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
        money.setBounds(0, 0, 200, 110);
        money.setLayout(new FlowLayout()); 
        JLabel coin = new JLabel(new ImageIcon("Image/coinS.png"));
        JLabel myCoin = new JLabel(":" + trainer.getCoin());
        myCoin.setFont(new Font("Tahoma", Font.BOLD, 30));
        myCoin.setForeground(Color.YELLOW);
        money.add(coin);
        money.add(myCoin);
        background.add(money);

        JLabel pokemonLeft = new JLabel();
        pokemonLeft.setBounds(0, 200, 768, 564);
        pokemonLeft.setLayout(new FlowLayout());

        JLabel pokemonRight = new JLabel();
        pokemonRight.setBounds(768, 200, 768, 564);
        pokemonRight.setLayout(new FlowLayout());
        
    for(Pokemon p: trainer.getBag()){

        if(trainer.getBag().indexOf(p) >= min && trainer.getBag().indexOf(p) <= max){
            num++;
            JLabel pokemons = new JLabel(new ImageIcon("Image/slot.png"));
            pokemons.setPreferredSize(new Dimension(600, 175));
            pokemons.setLayout(new FlowLayout());
            JLabel pokemonImage = new JLabel(p.getImg());
            JLabel status = new JLabel("Name: " + p.getName() + "   HP: " + p.getHp() + "/" + p.getMaxHp() + "   MP: " + p.getMp() + "/" + p.getMaxMp() + "   EXP: " + p.getExp() + "/" + p.getMaxExp());
            status.setFont(new Font("Tahoma", Font.BOLD, 18));
            status.setForeground(Color.WHITE);
            JLabel pMenu = new JLabel();
            pMenu.setLayout(new FlowLayout());
            JButton Edit = new JButton("Edit Name");
            Edit.setFont(new Font("Tahoma", Font.BOLD, 15));
            Edit.setBackground(Color.WHITE);
            JButton feed = new JButton("To Feed");
            feed.setFont(new Font("Tahoma", Font.BOLD, 15));
            feed.setBackground(Color.GREEN);
            JButton potion = new JButton("Use Potion");
            potion.setFont(new Font("Tahoma", Font.BOLD, 15));
            potion.setForeground(Color.white);
            potion.setBackground(Color.MAGENTA);
            JButton pk = new JButton("Evolve");
            pk.setFont(new Font("Tahoma", Font.BOLD, 15));
            pk.setBackground(Color.ORANGE);

            pokemons.add(pokemonImage);
            pokemons.add(status);
            pokemons.add(Edit);

            if(p.getHp() < p.getMaxHp()){
                pokemons.add(feed);
            }

            if(p.getMp() < p.getMaxMp()){
                pokemons.add(potion);
            }

            if(p.getExp() >= p.getMaxExp()){
                pokemons.add(pk);
            }

            if(num%2 == 1){
                pokemonLeft.add(pokemons);
            }
            else if(num%2 == 0){
                pokemonRight.add(pokemons);
            }            

            Edit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String name = (String)JOptionPane.showInputDialog(null, "Enter New Pokemon Name: ", "Edit Name", JOptionPane.PLAIN_MESSAGE, null, null, p.getName());
                    if(name != null && name.length() >0){
                        p.editName(name);
                        PokemonInBag ev = new PokemonInBag(trainer,min,max,page);
                        setVisible(false);
                    }
                }      
            }); 

            feed.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(trainer.getBerry() > 0){
                        p.getFeed();
                        trainer.useBerry();
                        PokemonInBag ev = new PokemonInBag(trainer,min,max,page);
                        setVisible(false);
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
                                PokemonInBag ev = new PokemonInBag(trainer,min,max,page);
                                setVisible(false);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }      
            }); 

            potion.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(trainer.getPotion() > 0){
                        p.getPotion();
                        trainer.usePotion();
                        PokemonInBag ev = new PokemonInBag(trainer,min,max,page);
                        setVisible(false);
                    }
                    else{
                        ImageIcon buy = new ImageIcon("Image/buy.png");
                        int n = JOptionPane.showConfirmDialog(null, "Your Potion is empty , Do you want to buy more?", "Potion is empty", JOptionPane.YES_NO_OPTION);
                        if(n == 0){
                            trainer.CoinDown(200);
                            trainer.buyPotion();
                            ImageIcon buyS = new ImageIcon("Image/buysussess.png");
                            JOptionPane.showMessageDialog(null, "Buy Potion Success.", "Buy Potion", JOptionPane.INFORMATION_MESSAGE,buyS);
                            PokemonInBag ev = new PokemonInBag(trainer,min,max,page);
                            setVisible(false);
                        }
                    }
                }      
            }); 

            pk.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    PokemonEvolution.getEvolution(p,Epokemon);
                    PokemonInBag ev = new PokemonInBag(trainer,min,max,page);
                    setVisible(false);
                }      
            });
        }
    }

        background.add(pokemonLeft);
        background.add(pokemonRight);

        JButton BerryP = new JButton(new ImageIcon("Image/berryS.png"));
        BerryP.setBounds(1336, 764, 100, 100);
        BerryP.setOpaque(false);
        BerryP.setContentAreaFilled(false);
        BerryP.setBorderPainted(false);
        JLabel numBerry = new JLabel("X" + trainer.getBerry());
        numBerry.setFont(new Font("Tahoma", Font.BOLD, 18));
        numBerry.setForeground(Color.YELLOW);
        BerryP.add(numBerry);
        background.add(BerryP);

        JButton potionP = new JButton(new ImageIcon("Image/potionS.png"));
        potionP.setBounds(1436, 764, 100, 100);
        potionP.setOpaque(false);
        potionP.setContentAreaFilled(false);
        potionP.setBorderPainted(false);
        JLabel numPotion = new JLabel("X" + trainer.getPotion());
        numPotion.setFont(new Font("Tahoma", Font.BOLD, 18));
        numPotion.setForeground(Color.YELLOW);
        potionP.add(numPotion);
        background.add(potionP);


        JLabel selectB = new JLabel();
        selectB.setBounds(0, 755, 1536, 110);
        selectB.setLayout(new FlowLayout()); 

        if(trainer.sumBag() / 6 == 1 && trainer.sumBag() % 6 == 0)
            nPage = 1;
        else if(trainer.sumBag() / 6 > 1 && trainer.sumBag() % 6 == 0)
            nPage = (trainer.sumBag() / 6);
        else
            nPage = (trainer.sumBag() / 6) + 1;

        JLabel numPage = new JLabel("     " + page + "/" + nPage);
        numPage.setPreferredSize(new Dimension(150, 100));
        numPage.setLayout(new FlowLayout());
        numPage.setFont(new Font("Tahoma", Font.BOLD, 30));

        if(trainer.sumBag() > 6){
            this.nMax = max;
            this.nMin = min;
    
            JButton left = new JButton(new ImageIcon("Image/button_left.png"));
            left.setBorderPainted(false);
            left.setOpaque(false);
            left.setContentAreaFilled(false);
            left.setBorderPainted(false);
            selectB.add(left);
    
            left.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(min == 0 && max == 5){
                        if((trainer.sumBag() % 6) == 0){
                            nMin = trainer.sumBag() - 6;
                            nMax = nMin + 5;
                        }
                        else{
                            int m = trainer.sumBag() % 6;
                            nMin = trainer.sumBag() - m;
                            nMax = nMin + 5;
                        }     
                        page = nPage;               
                    }
                    else{
                        nMin -= 6;
                        nMax -= 6;
                        page--;
                    }
                    PokemonInBag pb = new PokemonInBag(trainer,nMin,nMax,page);
                    setVisible(false);
                }      
            });
    
            selectB.add(numPage);
    
            JButton right = new JButton(new ImageIcon("Image/button_right.png"));
            right.setBorderPainted(false);
            right.setOpaque(false);
            right.setContentAreaFilled(false);
            right.setBorderPainted(false);
            selectB.add(right); 
    
            right.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(num%6 != 0 || nMax == trainer.sumBag() - 1){
                        nMin = 0;
                        nMax = 5;
                        page = 1;
                    }
                    else{
                        nMin += 6;
                        nMax += 6;
                        page++;
                    }
                    PokemonInBag pb = new PokemonInBag(trainer,nMin,nMax,page);
                    setVisible(false);
                }      
            });
        }
        else{
            selectB.add(numPage);
        }
    
            background.add(selectB);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*

    public void Evolve(Pokemon pokemon){
        String pname = pokemon.getSuperName();
        if(pname == "Pikachu"){
            Epokemon = new Raichu("Raichu");
        }
        else if(pname == "Psyduck"){
            Epokemon = new Golduck("Golduck");
        }
        String newSuperName = Epokemon.getSuperName();
        String newName = Epokemon.getName();
        int newHp = Epokemon.getHp();
        int newMaxExp = Epokemon.getMaxExp();
        int newMaxHp = Epokemon.getMaxHp();
        int newMaxMp = Epokemon.getMaxMp();
        ImageIcon newImg = Epokemon.getImg();
        pokemon.SetPokemon(newSuperName, newName, newHp, newMaxHp, newMaxMp, newMaxExp);
        pokemon.setImg(newImg);
        pokemon.setSkill(Epokemon.getSkill0(),Epokemon.getSkill1(),Epokemon.getSkill2(),Epokemon.getSkill3());
    } */
}