package Picerija;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
;


public class PasutitPicu extends JFrame implements ActionListener {
	static File darbvirsma= FileSystemView.getFileSystemView().getHomeDirectory();
	static String atrasanasVieta = darbvirsma.getAbsolutePath();
	
	 
		static void Fails(String str, JTextArea Vards) {


		
			try {
			    File mape = new File(atrasanasVieta+"\\"+"Pasūtītās_Picas");
			    if(!mape.exists()) {
			        mape.mkdir();
			    }

			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
			    String FileNos = Vards.getText()+"_Pasūtījums_"+dateFormat.format(new Date())+".txt";
			    
			   
			    TimerTask createFileTask = new TimerTask() {
			        @Override
			        public void run() {
			            try {
			            	
			                FileWriter fw = new FileWriter(new File(mape, FileNos), true);
			                PrintWriter pw = new PrintWriter(fw);
			                pw.println(str);
			                pw.close();
			                JOptionPane.showMessageDialog(null, "Jūsu Pasūtījums ir Pievests! "+fw);
						        
			                
			                
			                
						        JOptionPane.showMessageDialog(null, "Pasūtījums Saņemts.");
			                
			            } catch(Exception e) {
			                e.printStackTrace();
			            }
			        }
			    };
			    Timer Laiks = new Timer();
			    Laiks.schedule(createFileTask, 10000); 

			} catch(Exception e) {
			    JOptionPane.showMessageDialog(null, "Radās kļūda veidojot mapi", "Kļūda", JOptionPane.ERROR_MESSAGE);
			}


		}
	
		 
	JLabel Picerija;
	JCheckBox Izmers1, Izmers2, Izmers3, 
	Pepperoni, Tomati, Siers, Gurki, Senes, Zivs, Chili, Ananas, Vista, Teja, Cola, Sula, Sprite, kafija;
	
	JButton Order;
	DecimalFormat f=new DecimalFormat("#.##");
	String str="---Rolland Big Round Pizzas---\n\nPicas izmērs: ";
	JTextArea Pasutitajs;
	double amount =0;
	
	
	 JFrame info; 
    JButton EdienKartesPoga, pog2;
     JTextArea Vards,Numurs, Dzivo, tip;
     JLabel VardaIevade, NumuruIeavade, DzivesVieta, Raksts, Paldies, Paldies2, tip2;
	
	
     PasutitPicu(){
	
		
		
		
		info = new JFrame("Sūtītāja Info");
        info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color Crasa = new Color(253, 235, 208);
        info.setSize(620, 440);
        info.setLayout(null);
       
        info.setResizable(false);
        info.setLocationRelativeTo(null);
        info.setVisible(true);
        EdienKartesPoga=new JButton();
        EdienKartesPoga.setBounds(410, 220, 200, 200);
        EdienKartesPoga.addActionListener(this);
        EdienKartesPoga.setFocusable(false);
        EdienKartesPoga.addActionListener(e -> switchWindow(info, this));
        EdienKartesPoga.setBackground(Crasa);
        info.add(EdienKartesPoga);
  
        Numurs = new JTextArea();
        Numurs.setBounds(250, 120, 250, 30);
        Numurs.setFont(new Font("Arial", Font.PLAIN, 24));
        Numurs.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Vards = new JTextArea();
        Vards.setBounds(250, 70, 250, 30);
        Vards.setFont(new Font("Arial", Font.PLAIN, 24));
        Vards.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Dzivo = new JTextArea();
        Dzivo.setBounds(250, 170, 250, 30);
        Dzivo.setFont(new Font("Arial", Font.PLAIN, 24));
        Dzivo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        tip = new JTextArea("0");
        tip.setBounds(310, 360, 50, 30);
        tip.setFont(new Font("Arial", Font.PLAIN, 24));
        tip.setBorder(BorderFactory.createLineBorder(Color.BLACK));
   info.add(tip);

        
        ImageIcon icon2 = new ImageIcon("PicasLog.png");
        Image img2 = icon2.getImage().getScaledInstance(EdienKartesPoga.getWidth(), EdienKartesPoga.getHeight(), Image.SCALE_SMOOTH);
        EdienKartesPoga.setIcon(new ImageIcon(img2));
        
        VardaIevade = new JLabel("Jūsu Vārds");
        VardaIevade.setBounds(20,70,200,30);
        VardaIevade.setFont(new Font("Arial",Font.BOLD,22));
        VardaIevade.setBackground(Crasa);
        VardaIevade.setOpaque(true);
        VardaIevade.setBorder(new EmptyBorder(0,10,0,0));
        
        NumuruIeavade = new JLabel("Jūsu Numurs");
        NumuruIeavade.setBounds(20,120,200,30);
        NumuruIeavade.setFont(new Font("Arial",Font.BOLD,22));
        NumuruIeavade.setBackground(Crasa);
        NumuruIeavade.setOpaque(true);
        NumuruIeavade.setBorder(new EmptyBorder(0,10,0,0));
   
        DzivesVieta = new JLabel("Dzīves Vieta");
        DzivesVieta.setBounds(20,170,200,30);
        DzivesVieta.setFont(new Font("Arial",Font.BOLD,22));
        DzivesVieta.setBackground(Crasa);
        DzivesVieta.setOpaque(true);
        DzivesVieta.setBorder(new EmptyBorder(0,10,0,0));
  
        tip2 = new JLabel("Dzeram Nauda(Nav Obligāti):");
        tip2.setBounds(20,360,280,30);
        tip2.setFont(new Font("Arial",Font.BOLD,18));
        tip2.setBackground(Crasa);
        tip2.setOpaque(true);
        tip2.setBorder(new EmptyBorder(0,10,0,0));
        info.add(tip2);
        Raksts = new JLabel("                    Rolland Big Round Pizzas Order ");
        Raksts.setBounds(0,0,620,30);
        Raksts.setFont(new Font("Arial",Font.BOLD,22));
        Raksts.setBackground(Crasa);
        Raksts.setOpaque(true);
        Raksts.setBorder(new EmptyBorder(0,10,0,0));
        
        Paldies = new JLabel("   Paldies Ka Pasūtat no");
        Paldies.setBounds(50,270,300,30);
        Paldies.setFont(new Font("Arial",Font.BOLD,22));
        Paldies.setBackground(Crasa);
        Paldies.setOpaque(true);
        Paldies.setBorder(new EmptyBorder(0,10,0,0));
        
        Paldies2 = new JLabel("Rolland Big Round Pizzas");
        Paldies2.setBounds(50,300,300,30);
        Paldies2.setFont(new Font("Arial",Font.BOLD,22));
        Paldies2.setBackground(Crasa);
        Paldies2.setOpaque(true);
        Paldies2.setBorder(new EmptyBorder(0,10,0,0));
        
        info.add(Paldies2);
        info.add(Paldies);
        info.add(Raksts);
        
        info.add(NumuruIeavade);
        info.add(VardaIevade);
        info.add(DzivesVieta);
	    info.add(Numurs);
	    info.add(Dzivo);
	   
	    info.add(Vards);
	    info.add(EdienKartesPoga);
	 

		

		
	  //EdienKartesLogs
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(595,832);
	    this.setTitle("Picērija!");
	    this.setLocationRelativeTo(null);
	    this.setLayout(null);
	    this.setVisible(false);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("RolanduPicasEdienKarte.png").getImage().getScaledInstance(595, 832, Image.SCALE_SMOOTH));
	    JLabel background = new JLabel(imageIcon);
	  
	    background.setBounds(0, 0, this.getWidth(), this.getHeight());

	    
		
		 
		Picerija = new JLabel("");
		
		Picerija.setOpaque(true);
		
		
		Izmers1 = new JCheckBox("");
		Izmers1.setBounds(290,237,100,20);
		Izmers2 = new JCheckBox("");
		Izmers2.setBounds(290,267,100,20);
		Izmers3 = new JCheckBox("");
		Izmers3.setBounds(290,298,100,20);
		//Picas sastāvdaļas
		Pepperoni = new JCheckBox();
		Pepperoni.setBounds(290,375,100,20);
		Tomati = new JCheckBox();
		Tomati.setBounds(290,405,100,20);
		Siers = new JCheckBox();
		Siers.setBounds(290,437,100,20);
		Gurki = new JCheckBox();
		Gurki.setBounds(290,467,100,20);
		Senes = new JCheckBox();
		Senes.setBounds(290,497,100,20);
		Zivs = new JCheckBox("");
		Zivs.setBounds(290,529,100,20);
		Chili = new JCheckBox("");
		Chili.setBounds(290,559,100,20);
		Ananas = new JCheckBox("");
		Ananas.setBounds(290,589,100,20);
		Vista = new JCheckBox("");
		Vista.setBounds(290,618,100,20);
		
		Teja = new JCheckBox("");
		Teja.setBounds(2,450,100,20);
		Cola = new JCheckBox("");
		Cola.setBounds(2,480,100,20);
		Sula = new JCheckBox("");
		Sula.setBounds(2,512,100,20);
		Sprite = new JCheckBox("");
		Sprite.setBounds(2,545,100,20);
		kafija = new JCheckBox("");
		kafija.setBounds(2,575,100,20);
		
		
		
		Order = new JButton("Pasūtīt");
		Order.setBounds(330,720,200,50);
		Order.setFont(new Font("Arial",Font.BOLD, 18));
		Order.setForeground(Color.black);
		Izmers1.setOpaque(false);
		Izmers2.setOpaque(false);
		Izmers3.setOpaque(false);
		Pepperoni.setOpaque(false);
		Tomati.setOpaque(false);
		Siers.setOpaque(false);
		Gurki.setOpaque(false);
		Senes.setOpaque(false);
		Zivs.setOpaque(false);
		Chili.setOpaque(false);
		Ananas.setOpaque(false);
		Vista.setOpaque(false);
		
		Teja.setOpaque(false);
		Cola.setOpaque(false);
		Sula.setOpaque(false);
		Sprite.setOpaque(false);
		kafija.setOpaque(false);
		
		Order.addActionListener(this);
		Izmers3.addActionListener(this);
		Izmers2.addActionListener(this);
		Izmers1.addActionListener(this);
		//Picas Sastāvdaļas
		Pepperoni.addActionListener(this);
		Tomati.addActionListener(this);
		Siers.addActionListener(this);
		Gurki.addActionListener(this);
		Senes.addActionListener(this);
		Zivs.addActionListener(this);
		Chili.addActionListener(this);
		Ananas.addActionListener(this);
		Vista.addActionListener(this);
		
		Teja.addActionListener(this);
		Cola.addActionListener(this);
		Sula.addActionListener(this);
		Sprite.addActionListener(this);
		kafija.addActionListener(this);
		
		this.add(Picerija);
		this.add(Izmers1);
		this.add(Izmers2);
		this.add(Izmers3);
		this.add(Order);
	
		this.add(Pepperoni);
		this.add(Tomati);
		this.add(Siers);
		this.add(Gurki);
		this.add(Senes);
		this.add(Zivs);
		
		this.add(Teja);
		this.add(Cola);
		this.add(Sula);
		this.add(Sprite);
		this.add(kafija);
		
		this.add(Chili);
		this.add(Ananas);
		this.add(Vista);
		this.add(background);
	

		 Pasutitajs = new JTextArea();
		 Pasutitajs.setBounds(30,720,200,50);
		 Pasutitajs.setFont(new Font("Arial", Font.PLAIN, 14));
		 Pasutitajs.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 this.add(Pasutitajs);

		

	}
	
	 private void switchWindow(JFrame currentWindow, JFrame targetWindow) {
	      currentWindow.setVisible(false);
	      targetWindow.setVisible(true);
	    }
		
	 
	
	
	@Override
	public void actionPerformed(ActionEvent b) {
	
			if(b.getSource()==Order) {
			
				double DzeramNauda=0;
				     DzeramNauda = Double.parseDouble(tip.getText());
				  
				
				
				
				dispose();
				 
			        amount+=5+DzeramNauda;
				if(Izmers1.isSelected()) {
					
					str+="20cm";
				amount+=8.99;
					str+="\nPicas Sastāvdaļas:\n- - - - - - - -";
					if(Pepperoni.isSelected()) {
						amount+=0.15;
						str+="\nPepperoni";
					}
					if(Tomati.isSelected()) {
						amount+=0.10;
						str+="\nTomati";
					}
					if(Siers.isSelected()) {
						amount+=0.10;
						str+="\nSiers";
					}
					if(Gurki.isSelected()) {
						amount+=0.10;
						str+="\nGurķi";
					}
					if(Senes.isSelected()) {
						amount+=0.10;
						str+="\nSēnes";
					}
					if(Zivs.isSelected()) {
						amount+=0.15;
						str+="\nZivis";
					}
					if(Chili.isSelected()) {
						amount+=0.10;
						str+="\nČillī";
					}
					if(Ananas.isSelected()) {
						amount+=0.15;
						str+="\nAnanās";
					}
					if(Vista.isSelected()) {
						amount+=0.15;
						str+="\nVista";
					}
					str+="\n\nJūsu Dzēriens: ";
					if(Teja.isSelected()) {
						amount+=1.99;
						str+="\nAukstā Tēja";
					}
					if(Cola.isSelected()) {
						amount+=1.95;
						str+="\nCocaCola";
					}
					if(Sula.isSelected()) {
						amount+=1.49;
						str+="\nApelsīnu Sula";
					}
					if(Sprite.isSelected()) {
						amount+=1.99;
						str+="\nSprite";
					}
					if(kafija.isSelected()) {
						amount+=0.99;
						str+="\nKafija";
					}
					
			}
				
				
				if(Izmers2.isSelected()) {
					
					str+="40cm";
				amount+=12.99;
					str+="\nPicas Sastāvdaļas:";
					if(Pepperoni.isSelected()) {
						amount+=0.15;
						str+="\nPepperoni";
					}
					if(Tomati.isSelected()) {
						amount+=0.10;
						str+="\nTomati";
					}
					if(Siers.isSelected()) {
						amount+=0.10;
						str+="\nSiers";
					}
					if(Gurki.isSelected()) {
						amount+=0.10;
						str+="\nGurķi";
					}
					if(Senes.isSelected()) {
						amount+=0.10;
						str+="\nSēnes";
					}
					if(Zivs.isSelected()) {
						amount+=0.15;
						str+="\nZivis";
					}
					if(Chili.isSelected()) {
						amount+=0.10;
						str+="\nČillī";
					}
					if(Ananas.isSelected()) {
						amount+=0.15;
						str+="\nAnanās";
					}
					if(Vista.isSelected()) {
						amount+=0.15;
						str+="\nVista";
					}
					str+="\n\nJūsu Dzēriens:\n ";
					if(Teja.isSelected()) {
						amount+=1.99;
						str+="\nAukstā Tēja";
					}
					if(Cola.isSelected()) {
						amount+=1.95;
						str+="\nCocaCola";
					}
					if(Sula.isSelected()) {
						amount+=1.49;
						str+="\nApelsīnu Sula";
					}
					if(Sprite.isSelected()) {
						amount+=1.99;
						str+="\nSprite";
					}
					if(kafija.isSelected()) {
						amount+=0.99;
						str+="\nKafija";
					}
			}
				
				if(Izmers3.isSelected()) {
					
					str+="80cm";
				amount+=17.99;
					str+="\nPicas Sastāvdaļas:";
					if(Pepperoni.isSelected()) {
						amount+=0.15;
						str+="\nPepperoni";
					}
					if(Tomati.isSelected()) {
						amount+=0.10;
						str+="\nTomati";
					}
					if(Siers.isSelected()) {
						amount+=0.10;
						str+="\nSiers";
					}
					if(Gurki.isSelected()) {
						amount+=0.10;
						str+="\nGurķi";
					}
					if(Senes.isSelected()) {
						amount+=0.10;
						str+="\nSēnes";
					}
					if(Zivs.isSelected()) {
						amount+=0.15;
						str+="\nZivis";
					}
					if(Chili.isSelected()) {
						amount+=0.10;
						str+="\nČillī";
					}
					if(Ananas.isSelected()) {
						amount+=0.15;
						str+="\nAnanās";
					}
					if(Vista.isSelected()) {
						amount+=0.15;
						str+="\nVista";
					}
					str+="\n\nJūsu Dzēriens:\n ";
					if(Teja.isSelected()) {
						amount+=1.99;
						str+="\nAukstā Tēja";
					}
					if(Cola.isSelected()) {
						amount+=1.95;
						str+="\nCocaCola";
					}
					if(Sula.isSelected()) {
						amount+=1.49;
						str+="\nApelsīnu Sula";
					}
					if(Sprite.isSelected()) {
						amount+=1.99;
						str+="\nSprite";
					}
					if(kafija.isSelected()) {
						amount+=0.99;
						str+="\nKafija";
					}
				
				}
				
				str+="\n- - - - - - - -+\nTip:"+DzeramNauda+"\nKopā:"+f.format(amount);
				 str +="\n"+Pasutitajs.getText();
				 str+="\n\nPasūtītāja Vārds: "+Vards.getText()+"\nNr: "+Numurs.getText()+"\nAdrese: "+Dzivo.getText();
			JOptionPane.showMessageDialog(null, str);
			Fails(str, Vards);
			Piceroja ManPicerija = new Piceroja();
			}
	

		
	}
}
