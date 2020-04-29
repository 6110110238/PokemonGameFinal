import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectBall extends JFrame {
    ImageIcon ball1 = new ImageIcon("Image/gotcha1.png");
    ImageIcon ball2 = new ImageIcon("Image/gotcha2.png");
    ImageIcon ball3 = new ImageIcon("Image/gotcha3.png");
    ImageIcon ball4 = new ImageIcon("Image/gotcha4.png");

    public SelectBall(Trainer trainer,Pokemon enemy,boolean catched,ImageIcon ball) {

        Container c = getContentPane();
        JLabel background = new JLabel(new ImageIcon("Image/BG9.png"));
        background.setBounds(0, 0, 1536, 864);
        c.add(background);

        JButton home = new JButton(new ImageIcon("Image/go_back.png"));    
        home.setBounds(1441, 0, 95, 50);
        background.add(home);

        home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainGame h = new MainGame(trainer);
                setVisible(false);
            }      
        });

        JLabel enemyP = new JLabel(); 
        enemyP.setBounds(518, 432, 500, 150);
        enemyP.setLayout(new FlowLayout()); 
        JLabel enemyPic = new JLabel(enemy.getImg());
        JLabel enemyStatus = new JLabel("Name: " + enemy.getName() + "   HP: " + enemy.getHp() + "/" + enemy.getMaxHp() + "   MP: " + enemy.getMp() + "/" + enemy.getMaxMp());
        enemyStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
        enemyStatus.setForeground(Color.ORANGE);
        enemyP.add(enemyStatus);
        enemyP.add(enemyPic);

        JLabel pokeball = new JLabel();
        pokeball.setBounds(0, 600, 1536, 200);
        pokeball.setLayout(new FlowLayout()); 

        JButton pokeball1 = new JButton(new ImageIcon("Image/pokeball.png"));
        pokeball1.setPreferredSize(new Dimension(200, 200));
        pokeball1.setOpaque(false);
        pokeball1.setContentAreaFilled(false);
        pokeball1.setBorderPainted(false);
        JLabel numBall1 = new JLabel("X" + trainer.getPokeball());
        numBall1.setFont(new Font("Tahoma", Font.BOLD, 18));
        numBall1.setForeground(Color.YELLOW);
        pokeball1.add(numBall1);

        JButton pokeball2 = new JButton(new ImageIcon("Image/greatball.png"));
        pokeball2.setPreferredSize(new Dimension(200, 200));
        pokeball2.setOpaque(false);
        pokeball2.setContentAreaFilled(false);
        pokeball2.setBorderPainted(false);
        JLabel numBall2 = new JLabel("X" + trainer.getGreatball());
        numBall2.setFont(new Font("Tahoma", Font.BOLD, 18));
        numBall2.setForeground(Color.YELLOW);
        pokeball2.add(numBall2);

        JButton pokeball3 = new JButton(new ImageIcon("Image/ultraball.png"));
        pokeball3.setPreferredSize(new Dimension(200, 200));
        pokeball3.setOpaque(false);
        pokeball3.setContentAreaFilled(false);
        pokeball3.setBorderPainted(false);
        JLabel numBall3 = new JLabel("X" + trainer.getUltraball());
        numBall3.setFont(new Font("Tahoma", Font.BOLD, 18));
        numBall3.setForeground(Color.YELLOW);
        pokeball3.add(numBall3);

        JButton pokeball4 = new JButton(new ImageIcon("Image/masterball.png"));
        pokeball4.setPreferredSize(new Dimension(200, 200));
        pokeball4.setOpaque(false);
        pokeball4.setContentAreaFilled(false);
        pokeball4.setBorderPainted(false);
        JLabel numBall4 = new JLabel("X" + trainer.getMasterball());
        numBall4.setFont(new Font("Tahoma", Font.BOLD, 18));
        numBall4.setForeground(Color.YELLOW);
        pokeball4.add(numBall4);

        pokeball.add(pokeball1);
        pokeball.add(pokeball2);
        pokeball.add(pokeball3);
        pokeball.add(pokeball4);

        if(catched){
            JButton gotcha = new JButton(ball);
            gotcha.setOpaque(false);
            gotcha.setContentAreaFilled(false);
            gotcha.setBorderPainted(false);
            gotcha.setBounds(568, 232, 400, 400);
            background.add(gotcha);

            gotcha.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    PokemonInBag pb = new PokemonInBag(trainer,0,5,1);
                    setVisible(false);
                }      
            });
        }
        else{
            background.add(enemyP);
            background.add(pokeball);
        }            

        ImageIcon icon = new ImageIcon("Image/pokeball.gif");
        ImageIcon fail = new ImageIcon("Image/fail.png");

        pokeball1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            
            if(trainer.getPokeball() > 0){
                trainer.usePokeball();
                int num = (int)(Math.random()*3);
                if(num == 0){
                    JOptionPane.showMessageDialog(null, "Catch pokemon Fail!!", "Fail!", JOptionPane.ERROR_MESSAGE,fail);
                    SelectBall sb = new SelectBall(trainer,enemy,false,null);
                    setVisible(false);
                }
                else if(num == 1){
                    JOptionPane.showMessageDialog(null, "You catch: " + enemy.getName() + "\nTrainer EXP: +50", "Good!", JOptionPane.INFORMATION_MESSAGE,icon);
                    trainer.addBag(enemy);
                    trainer.ExpUp(50);
                    SelectBall sb = new SelectBall(trainer,enemy,true,ball1);
                    setVisible(false);
                }
                else if(num == 2){
                    JOptionPane.showMessageDialog(null, "Catch pokemon Fail!!", "Fail!", JOptionPane.ERROR_MESSAGE,fail);
                    SelectBall sb = new SelectBall(trainer,enemy,false,null);
                    setVisible(false);
                }
            }
            else{                
                int n = JOptionPane.showConfirmDialog(null, "Your Pokeball is empty , Do you want to buy more?", "Pokeball is empty", JOptionPane.YES_NO_OPTION);
                if(n == 0){
                    if(trainer.getCoin() >= 300){
                            trainer.CoinDown(300);
                            trainer.buyPokeball();
                            ImageIcon buyS = new ImageIcon("Image/buysussess.png");
                            JOptionPane.showMessageDialog(null, "Buy Pokeball Success.", "Buy Pokeball", JOptionPane.INFORMATION_MESSAGE,buyS);
                            SelectBall sb = new SelectBall(trainer,enemy,false,null);
                            setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        }      
        });
        
        pokeball2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            if(trainer.getGreatball() > 0){            
                trainer.useGreatball();
                int num = (int)(Math.random()*2);
                if(num == 0){
                    JOptionPane.showMessageDialog(null, "Catch pokemon Fail!!", "Fail!", JOptionPane.ERROR_MESSAGE,fail);
                    SelectBall sb = new SelectBall(trainer,enemy,false,null);
                    setVisible(false);
                }
                else if(num == 1){
                    JOptionPane.showMessageDialog(null, "You catch: " + enemy.getName() + "\nTrainer EXP: +50", "Great!", JOptionPane.INFORMATION_MESSAGE,icon);
                    trainer.addBag(enemy);
                    trainer.ExpUp(50);
                    SelectBall sb = new SelectBall(trainer,enemy,true,ball2);
                    setVisible(false);
                }
            } 
            else{                
                int n = JOptionPane.showConfirmDialog(null, "Your Greatball is empty , Do you want to buy more?", "Greatball is empty", JOptionPane.YES_NO_OPTION);
                if(n == 0){
                    if(trainer.getCoin() >= 400){
                            trainer.CoinDown(400);
                            trainer.buyGreatball();
                            ImageIcon buyS = new ImageIcon("Image/buysussess.png");
                            JOptionPane.showMessageDialog(null, "Buy Greatball Success.", "Buy Greatball", JOptionPane.INFORMATION_MESSAGE,buyS);
                            SelectBall sb = new SelectBall(trainer,enemy,false,null);
                            setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        });

        pokeball3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            if(trainer.getUltraball() > 0){        
                trainer.useUltraball();
                int num = (int)(Math.random()*3);
                if(num == 0){
                    JOptionPane.showMessageDialog(null, "Catch pokemon Fail!!", "Fail!", JOptionPane.ERROR_MESSAGE,fail);
                    SelectBall sb = new SelectBall(trainer,enemy,false,null);
                    setVisible(false);
                }
                else if(num == 1){
                    JOptionPane.showMessageDialog(null, "You catch: " + enemy.getName() + "\nTrainer EXP: +50", "Perfect!", JOptionPane.INFORMATION_MESSAGE,icon);
                    trainer.addBag(enemy);
                    trainer.ExpUp(50);
                    SelectBall sb = new SelectBall(trainer,enemy,true,ball3);
                    setVisible(false);
                }
                else if(num == 2){
                    JOptionPane.showMessageDialog(null, "You catch: " + enemy.getName() + "\nTrainer EXP: +50", "Perfect!", JOptionPane.INFORMATION_MESSAGE,icon);
                    trainer.addBag(enemy);
                    trainer.ExpUp(50);
                    SelectBall sb = new SelectBall(trainer,enemy,true,ball3);
                    setVisible(false);
                }
            }
            else{                
                int n = JOptionPane.showConfirmDialog(null, "Your Ultraball is empty , Do you want to buy more?", "Ultraball is empty", JOptionPane.YES_NO_OPTION);
                if(n == 0){
                    if(trainer.getCoin() >= 500){
                            trainer.CoinDown(500);
                            trainer.buyUltraball();
                            ImageIcon buyS = new ImageIcon("Image/buysussess.png");
                            JOptionPane.showMessageDialog(null, "Buy Ultraball Success.", "Buy Ultraball", JOptionPane.INFORMATION_MESSAGE,buyS);
                            SelectBall sb = new SelectBall(trainer,enemy,false,null);
                            setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            }      
        });

        pokeball4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            if(trainer.getMasterball() > 0){        
            
                trainer.useMasterball();
                JOptionPane.showMessageDialog(null, "You catch: " + enemy.getName() + "\nTrainer EXP: +50", "Excellent!", JOptionPane.INFORMATION_MESSAGE,icon);
                trainer.addBag(enemy);
                trainer.ExpUp(50);
                SelectBall sb = new SelectBall(trainer,enemy,true,ball4);
                setVisible(false);
            } 
            else{                
                int n = JOptionPane.showConfirmDialog(null, "Your Masterball is empty , Do you want to buy more?", "Masterball is empty", JOptionPane.YES_NO_OPTION);
                if(n == 0){
                    if(trainer.getCoin() >= 600){
                            trainer.CoinDown(600);
                            trainer.buyMasterball();
                            ImageIcon buyS = new ImageIcon("Image/buysussess.png");
                            JOptionPane.showMessageDialog(null, "Buy Masterball Success.", "Buy Masterball", JOptionPane.INFORMATION_MESSAGE,buyS);
                            SelectBall sb = new SelectBall(trainer,enemy,false,null);
                            setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You don't have enough Coin.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
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