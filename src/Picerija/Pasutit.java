package Picerija;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Pasutit extends JFrame implements ActionListener{

		JButton Poga;
		JLabel DariKoSaku;
		JTextArea Vards,TypingPlace;
		//String ;
		 String str="";
		 
 Pasutit(){
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setTitle("Picērija!");
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		
	    Poga = new JButton("Pasūtīt");
			Poga.setBounds(300,500,200,50);
			Poga.setFont(new Font("Arial",Font.BOLD, 18));
			Poga.setForeground(Color.black);
		

   

			 TypingPlace = new JTextArea();
			    TypingPlace.setBounds(100, 400, 600, 50);
			    TypingPlace.setFont(new Font("Arial", Font.PLAIN, 14));
			    TypingPlace.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			    
			    this.add(TypingPlace);
			    
			

			Poga.addActionListener(this);

		
		
		this.add(Poga);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 str = TypingPlace.getText();
        System.out.println("Typed text: " + str);
		if(e.getSource()==Poga) {
			 this.dispose();
			
			
			
			
				}
		}
		
	}
	
	
	

