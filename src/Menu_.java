import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;


public class Menu_ extends JFrame implements ActionListener {
    private JPanel panel1, panel2, panel3, panel4, panel5;
    private JButton start, help, exitGame, back, settingButton, volumnUP, volumnDOWN;
    private JLabel background, volNum, volNumInit;
    private Icon setting, plus, minus;
    private JSlider BGmusic;
    private Integer vol4;
    private boolean onScreen = true;
    private boolean offScreen = false;
    Sound backgroundMusic;
    Sound rock;
    

    public Menu_() {
        super("Mandarin Square Capturing");

        panel1 = new JPanel();
        panel1.setBounds(350, 250, 300, 200);
        panel1.setOpaque(false);

        start = new JButton("Start");     
        start.setPreferredSize(new Dimension(300, 60));  
        start.setContentAreaFilled(false);
        start.addActionListener(this);

        help = new JButton("Help");   
        help.setPreferredSize(new Dimension(300, 60));    
        help.setContentAreaFilled(false);
        help.addActionListener(this);

        exitGame = new JButton("Exit");     
        exitGame.setPreferredSize(new Dimension(300, 60));  
        exitGame.setContentAreaFilled(false);
        exitGame.addActionListener(this);
 
        panel1.add(start);
        panel1.add(help);
        panel1.add(exitGame);

        // ----------------------------------------------------------------------------------
        // help 
        panel2 = new JPanel();
        panel2.setBounds(100, 100, 800, 600);
        panel2.setBackground(Color.black); // add rule
        panel2.setVisible(false);
        
        // -----------------------------------------------------------------------------------
        back = new JButton("Exit");     
        back.setPreferredSize(new Dimension(80, 60));  
        back.addActionListener(this);

        panel3 = new JPanel();
        panel3.setBounds(0, 0, 80, 70);
        panel3.setOpaque(false);
        panel3.setVisible(false);
        panel3.add(back);

        // -----------------------------------------------------------------------------------
        // setting
        setting = new ImageIcon(new javax.swing.ImageIcon("D:\\OanQuan-main\\OanQuan-main\\src\\setting.png").
                      getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
              
        settingButton = new JButton(setting);
        settingButton.setPreferredSize(new Dimension(80, 60));  
        settingButton.addActionListener(this);
        settingButton.setOpaque(false);
        settingButton.setContentAreaFilled(false);
        settingButton.setBorderPainted(false);
        settingButton.setFocusPainted(false);

        panel4 = new JPanel();
        panel4.setBounds(900, 0, 80, 70);
        panel4.setOpaque(false);
        panel4.add(settingButton);
        
        // ------------------------------------------------------------------------------------
        // control volumn of background music
        plus = new ImageIcon(new javax.swing.ImageIcon("D:\\OanQuan-main\\OanQuan-main\\src\\plus.png").
                    getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        volumnUP = new JButton(plus);     
        volumnUP.setPreferredSize(new Dimension(50, 60)); 
        volumnUP.addActionListener(this);
        volumnUP.setContentAreaFilled(false);
        volumnUP.setBorderPainted(false);
        volumnUP.setFocusPainted(false);

        minus = new ImageIcon(new javax.swing.ImageIcon("D:\\OanQuan-main\\OanQuan-main\\src\\minus.png").
                    getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        volumnDOWN = new JButton(minus);     
        volumnDOWN.setPreferredSize(new Dimension(50, 60));  
        volumnDOWN.addActionListener(this);
        volumnDOWN.setContentAreaFilled(false);
        volumnDOWN.setBorderPainted(false);
        volumnDOWN.setFocusPainted(false);
        
        
        panel5 = new JPanel();
        panel5.setBounds(100, 200, 500, 100);
        panel5.setOpaque(false);
        panel5.setVisible(false);
        panel5.add(volumnUP);
        panel5.add(volumnDOWN);
        
        volNum = new JLabel();
        volNum.setText("25");
        
        BGmusic = new JSlider(-40, 6);
        BGmusic.setOpaque(true);
        BGmusic.setBackground(Color.BLACK);
        BGmusic.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                backgroundMusic.curentVolumn = BGmusic.getValue();
                if (backgroundMusic.curentVolumn == -40) {
                    backgroundMusic.curentVolumn = -80;
                }
                backgroundMusic.fc.setValue(backgroundMusic.curentVolumn);
                int vol = BGmusic.getValue();
                float vol2 = (float)vol;
                float vol3 = (vol2 + 40) / 46 * 50;
                vol4 = Math.round(vol3);
               
                volNum.setText(vol4.toString());
            }
        });
        
        panel5.add(BGmusic);
        panel5.add(volNum);
     
        
    
        // ---------------------------------------------------------------------------------------
        background = new JLabel();
        background.setIcon(new ImageIcon("D:\\OanQuan-main\\OanQuan-main\\src\\gameBG.jpg"));    

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);

        this.add(background);
        this.setVisible(true); 

        File f = new File("D:\\OanQuan-main\\OanQuan-main\\src\\bgmusic.wav");
        this.playBackgroundMusic(f);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            panel1.setVisible(false);
            panel3.setVisible(true);
            panel4.setVisible(false);
        } else if (e.getSource() == exitGame) {
            this.dispose();
        } else if (e.getSource() == help) {
            panel1.setVisible(false);
            panel2.setVisible(true);
            panel3.setVisible(true);
            panel4.setVisible(false);
        } else if (e.getSource() == back) {
            panel1.setVisible(true);
            panel2.setVisible(false);
            panel3.setVisible(false);
            panel4.setVisible(true);
            panel5.setVisible(false);
        } else if (e.getSource() == settingButton) {
            panel1.setVisible(false);
            panel3.setVisible(true);
            panel4.setVisible(false);
            panel5.setVisible(true);
        } else if (e.getSource() == volumnUP) {
            backgroundMusic.volumnUp();
            BGmusic.setValue(BGmusic.getValue() + 1);
            vol4 = vol4 + 1;
            if (vol4 > 50) {
            	vol4 = 50;
            }
            volNum.setText(vol4.toString());
            
        } else if (e.getSource() == volumnDOWN) {
            backgroundMusic.volumnDown();
            BGmusic.setValue(BGmusic.getValue() - 1);
            vol4 = vol4 - 1;
            if (vol4 < 0) {
            	vol4 = 0;
            }
            volNum.setText(vol4.toString());
        }
    }


    public void playBackgroundMusic(File url) {
        backgroundMusic = new Sound();
        backgroundMusic.playSound(url);
    }
        

    public static void main(String[] args) {
        new Menu_();   
    }
}
