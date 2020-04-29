import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransferPokemon extends JFrame {
    int num = 0; 
    int nMin;
    int nMax;
    int page;
    int nPage;
    int maxMp = 0;
    int coin = 0;
    int exp = 0;
    String name;

    public TransferPokemon(Trainer trainer, int min, int max, int pages){
        super("Transfer Pokemon");

        this.page = pages;

        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/BG5.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JLabel intro = new JLabel(new ImageIcon("Image/transferpokemon.png")); 
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
        JLabel coinS = new JLabel(new ImageIcon("Image/coinS.png"));
        JLabel myCoin = new JLabel(":" + trainer.getCoin());
        myCoin.setFont(new Font("Tahoma", Font.BOLD, 30));
        myCoin.setForeground(Color.YELLOW);
        money.add(coinS);
        money.add(myCoin);
        background.add(money);

        JLabel professor = new JLabel(new ImageIcon("Image/professor.png"));
        professor.setBounds(768, 0, 768, 864);
        background.add(professor);

        if(trainer.sumBag() / 4 == 1 && trainer.sumBag() % 4 == 0)
            nPage = 1;
        else if(trainer.sumBag() / 4 > 1 && trainer.sumBag() % 4 == 0)
            nPage = (trainer.sumBag() / 4);
        else
            nPage = (trainer.sumBag() / 4) + 1;

        JLabel numPage = new JLabel("     " + page + "/" + nPage);
        numPage.setPreferredSize(new Dimension(150, 100));
        numPage.setLayout(new FlowLayout());
        numPage.setFont(new Font("Tahoma", Font.BOLD, 30));

        JLabel select = new JLabel();
        select.setBounds(100, 200, 550, 564);
        select.setLayout(new FlowLayout());

    for(Pokemon p: trainer.getBag()){
        
        if(trainer.getBag().indexOf(p) >= min && trainer.getBag().indexOf(p) <= max){
            JLabel pic = new JLabel(p.getImg());
            JLabel status = new JLabel("Name: " + p.getName() + "   HP: " + p.getHp() + "/" + p.getMaxHp());
            status.setFont(new Font("Tahoma", Font.BOLD, 18));
            status.setForeground(Color.WHITE);
            JButton pokemon = new JButton(new ImageIcon("Image/slot6.png"));
            pokemon.setPreferredSize(new Dimension(500, 130));
            pokemon.setLayout(new FlowLayout());
            pokemon.setOpaque(false);
            pokemon.setContentAreaFilled(false);
            pokemon.setBorderPainted(false);
            pokemon.add(pic);
            pokemon.add(status);
            select.add(pokemon);
            num++;

            

            pokemon.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    name = p.getName();
                    maxMp = p.getMaxExp();
                    if(maxMp == 100){
                        coin = 250;
                        exp = 50;
                    }
                    else if(maxMp == 150){
                        coin = 500;
                        exp = 100;
                    }
                    else{
                        coin = 1000;
                        exp = 150;
                    }
                int n = JOptionPane.showConfirmDialog(null, "Are you sure to transfer " + name + "?", null, JOptionPane.YES_NO_OPTION);
                    if(n==0){
                        if(trainer.sumBag() > 1){
                            
                            trainer.getBag().remove(p);   
                            trainer.CoinUp(coin);
                            trainer.ExpUp(exp);                     
                            JOptionPane.showMessageDialog(null,"You receive\nCoin:" + coin + "\nEXP: " + exp, "Transfer success!", JOptionPane.INFORMATION_MESSAGE);
                            TransferPokemon tf = new TransferPokemon(trainer,min,max,page);
                            setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "This Pokemon is the last one.", "Transfer fail!", JOptionPane.ERROR_MESSAGE);
                        }
                    } 
                }      
            }); 
        }
    }

        background.add(select);  

        JLabel selectB = new JLabel();
        selectB.setBounds(120, 745, 500, 110);
        selectB.setLayout(new FlowLayout()); 


    if(trainer.sumBag() > 4){
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
                if(min == 0 && max == 3){
                    if((trainer.sumBag() % 4) == 0){
                        nMin = trainer.sumBag() - 4;
                        nMax = nMin + 3;
                    }
                    else{
                        int m = trainer.sumBag() % 4;
                        nMin = trainer.sumBag() - m;
                        nMax = nMin + 3;
                    }     
                    page = nPage;               
                }
                else{
                    nMin -= 4;
                    nMax -= 4;
                    page--;
                }
                TransferPokemon tf = new TransferPokemon(trainer,nMin,nMax,page);
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
                if(num%4 != 0 || nMax == trainer.sumBag() - 1){
                    nMin = 0;
                    nMax = 3;
                    page = 1;
                }
                else{
                    nMin += 4;
                    nMax += 4;
                    page++;
                }
                TransferPokemon tf = new TransferPokemon(trainer,nMin,nMax,page);
                setVisible(false);
            }      
        });
    }
    else{
        selectB.add(numPage);
    }

        background.add(selectB);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}