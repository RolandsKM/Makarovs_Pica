package Picerija;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Piceroja implements ActionListener {
	
	 JButton Picerija = new JButton("Roland Picērija");
	 
	 JFrame frame = new JFrame();
	 Piceroja(){
		
		
		
		 

		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(620,620);
		    frame.setLayout(null);
		    frame.setResizable(false);
		    frame.setLocationRelativeTo(null);
		 
		    ImageIcon imageIcon = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(620, 600, Image.SCALE_SMOOTH));
		    JLabel background = new JLabel(imageIcon);
		  
		    background.setBounds(0, 0, frame.getWidth(), frame.getHeight());

		   
		    Color Crasa = new Color(253, 235, 208);
		    Picerija.setBounds(210, 490, 200, 40);
		    Picerija.addActionListener(this);
		    Picerija.setFocusable(false);
		    Picerija.setBackground(Crasa);
		    background.add(Picerija); 
		    
		    
		    
		    frame.add(background);

		    frame.setVisible(true);
	 
	  
	 }
	 

	@Override
	 public void actionPerformed(ActionEvent e) {
	  
	  if(e.getSource()==Picerija) {
	   frame.dispose();
	   PicaVeidosana manPicerija = new PicaVeidosana();
	  }
	}
	
	}

