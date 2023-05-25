package Picerija;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class PicaVeidosana implements ActionListener{
	 JFrame frame = new JFrame();
	
	
	 JButton Klatiene = new JButton();
	 JButton Pasutit = new JButton();
	 PicaVeidosana(){
	  //Poga Pasūtīt
		 
		 Pasutit.setBounds(0,0,310,585);
		 Pasutit.setFocusable(false);
		 Pasutit.addActionListener(this);
		 	frame.add(Pasutit);
		 	ImageIcon icon = new ImageIcon("PasutitPizz.png");
	        Image img = icon.getImage().getScaledInstance(Pasutit.getWidth(), Pasutit.getHeight(), Image.SCALE_SMOOTH);
	        Pasutit.setIcon(new ImageIcon(img));
	//Poga Klātienē
		 	Klatiene.setBounds(310,0,310,585);
		 	Klatiene.setFocusable(false);
		 	Klatiene.addActionListener(this);
			 	frame.add(Klatiene);
			 	ImageIcon icon2 = new ImageIcon("KlatieneSnanemt.png");
		        Image img2 = icon2.getImage().getScaledInstance(Klatiene.getWidth(), Klatiene.getHeight(), Image.SCALE_SMOOTH);
		        Klatiene.setIcon(new ImageIcon(img2));
		        
	
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(620,620);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  frame.setLocationRelativeTo(null);
	 }
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==Klatiene) {
			 frame.dispose();
			 Klatiene PicaKlatiene = new Klatiene();
		 }
		 if(e.getSource()==Pasutit){
			 frame.dispose();
			 PasutitPicu PicaAtalinati = new PasutitPicu();
		 }
	 }
}
