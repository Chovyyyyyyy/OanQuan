import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.sound.sampled.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;


public class Menu_ extends JFrame implements ActionListener {
    private JPanel panel1, panel2, panel3, panel4;
    private JButton b1, b2, b3, b4, b5;
    private JLabel background;
    private Icon setting;
    ActionListener e;

    Menu_() {
        super("Mandarin Square Capturing");

        panel1 = new JPanel();
        panel1.setBounds(350, 250, 300, 200);
        panel1.setOpaque(false);

        b1 = new JButton("Start");     
        b1.setPreferredSize(new Dimension(300, 60));  
        // b1.setOpaque(false);
        b1.addActionListener(this);

        b2 = new JButton("Help");   
        b2.setPreferredSize(new Dimension(300, 60));    
        // b2.setOpaque(false);
        b2.addActionListener(this);

        b3 = new JButton("Exit");     
        b3.setPreferredSize(new Dimension(300, 60));  
        // b3.setOpaque(false);
        b3.addActionListener(this);
 
        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);

        // ----------------------------------------------------------------------------------
        // help 
        panel2 = new JPanel();
        panel2.setBounds(100, 100, 800, 600);
        panel2.setBackground(Color.black); // add rule
        panel2.setVisible(false);
        
        // -----------------------------------------------------------------------------------
        b4 = new JButton("Exit");     
        b4.setPreferredSize(new Dimension(80, 60));  
        b4.addActionListener(this);

        panel3 = new JPanel();
        panel3.setBounds(900, 0, 80, 70);
        panel3.setOpaque(false);
        panel3.setVisible(false);
        panel3.add(b4);

        // -----------------------------------------------------------------------------------
        // setting
        setting = new ImageIcon(new javax.swing.ImageIcon("E:\\Data_analysis\\project oop DSAI\\OanQuan\\src\\setting.png").
                      getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
              
        b5 = new JButton(setting);
        b5.setPreferredSize(new Dimension(80, 60));  
        b5.addActionListener(this);
        b5.setOpaque(false);
        b5.setContentAreaFilled(false);
        b5.setBorderPainted(false);

        panel4 = new JPanel();
        panel4.setBounds(900, 0, 80, 70);
        panel4.setOpaque(false);
        panel4.add(b5);

    
        // ---------------------------------------------------------------------------------------
        background = new JLabel();
        background.setIcon(new ImageIcon("E:\\Data_analysis\\project oop DSAI\\OanQuan\\src\\gameBG.jpg"));
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);

        this.add(background);
        this.setVisible(true); 

        File f = new File("E:\\Data_analysis\\project oop DSAI\\OanQuan\\src\\bgmusic.wav");
        this.playSound(f);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            panel1.setVisible(false);
            panel3.setVisible(true);
        } else if (e.getSource() == b3) {
            this.dispose();
        } else if (e.getSource() == b2) {
            panel1.setVisible(false);
            panel2.setVisible(true);
            panel3.setVisible(true);
        } else if (e.getSource() == b4) {
            panel1.setVisible(true);
            panel2.setVisible(false);
            panel3.setVisible(false);
        }
    }


    public void playSound(File url) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(url);
              clip.open(inputStream);
              clip.start(); 
              clip.loop(Clip.LOOP_CONTINUOUSLY);

            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
      }


    public static void main(String[] args) {
        new Menu_();   
    }
}
