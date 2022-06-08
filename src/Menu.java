import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
	JLabel label;
	JLabel label2;
	ActionListener e;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	Menu() {
	label = new JLabel();
	label2 = new JLabel();
	
	panel1 = new JPanel();
	panel2 = new JPanel();
	panel3 = new JPanel();
	jb4 = new JButton("Exit");
	panel3.add(jb4);
	this.add(panel3);
	panel3.setVisible(false);
	panel3.setBounds(0,0,300,300);

	label.setHorizontalTextPosition(JLabel.CENTER);
	label.setVerticalTextPosition(JLabel.TOP);
	label.setIcon(new ImageIcon("D:\\MainMenu\\src\\vOff.png"));
	
	Dimension a = new Dimension(100, 30);
	
	jb1 = new JButton("Start");
    jb2 = new JButton("Help");
    jb3 = new JButton("Exit");
    
    jb1.setPreferredSize(a);
    jb2.setPreferredSize(a);
    jb3.setPreferredSize(a);
    
    jb1.addActionListener(this);
    jb2.addActionListener(this);
    jb3.addActionListener(this);
    jb4.addActionListener(this);
    
    panel1.setLayout(new GridLayout(3, 1, 0, 10));
    
    panel1.setBounds(490, 210, 300, 300);
    panel1.add(jb1);
    panel1.add(jb2);
    panel1.add(jb3);
    
	
    
    panel2.add(label);
    panel2.setBounds(0,620,100,100);
    
    
   
    
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1280, 720);
	this.setLayout(null);
	this.setVisible(true);
	this.setResizable(false);
	// this.add(panel2);
    this.add(panel1);
    this.add(panel2);
	
	
}

	public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jb3) {
			this.dispose();
		}	else if (e.getSource() == jb2) {
			panel3.setVisible(true);
		} else if (e.getSource() == jb1){
			System.out.println("a");
		}
			else if(e.getSource() == jb4) {
				panel3.setVisible(false);
			}
		}
		
	}	



	
	

	



