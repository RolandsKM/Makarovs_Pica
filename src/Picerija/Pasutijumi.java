package Picerija;





import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Pasutijumi {
Pasutijumi(){
	
	
	
	
	String[] opcijas={"Pasūtīttie Pasūtījumi", "Klātienes Pasūtījumi", "Atpakaļ"};

	String izvele;

	do {

	izvele=(String) JOptionPane.showInputDialog(null, "Izvelies Pasūtījumu!", "Izvele", JOptionPane.QUESTION_MESSAGE, null, opcijas, opcijas[0]);

	switch(izvele) {

	case "Pasūtīttie Pasūtījumi":

		
		String DekstopMape = System.getProperty("user.home") + "\\Desktop\\"; //C:\Users\2PT-2\Desktop\Saņemtie_Pasūtījumi

		String Fails = DekstopMape + "Pasūtītās_Picas";

		

		File FailuVieta = new File(Fails);

		

		if (!FailuVieta.exists() || !FailuVieta.isDirectory()) {

		JOptionPane.showMessageDialog(null, "Nav Atrasts: " + Fails,

		"Error", JOptionPane.ERROR_MESSAGE);

		return;

		}

		

		File[] files = FailuVieta.listFiles();

		if (files.length == 0) {

		JOptionPane.showMessageDialog(null, "Nav Psutijumi: ",

		"Tukss", JOptionPane.ERROR_MESSAGE);

		return;

		}

		

		String[] fileNos = new String[files.length];

		for (int i = 0; i < files.length; i++) {

			fileNos[i] = files[i].getName();

		}

		String FailuVards = (String) JOptionPane.showInputDialog(null, "Izvelies Kuru Atvert",

		"Open File", JOptionPane.PLAIN_MESSAGE, null, fileNos, fileNos[0]);

		if (FailuVards == null) {

		return; 

		}

		

		for (File file : files) {

		if (file.getName().equals(FailuVards)) {

		try {

		FileReader reader = new FileReader(file);

		BufferedReader bufferedReader = new BufferedReader(reader);

		StringBuilder Saturs = new StringBuilder();

		String line;

		while ((line = bufferedReader.readLine()) != null) {

			Saturs.append(line);

			Saturs.append(System.lineSeparator());

		}

		bufferedReader.close();

		

		JOptionPane.showMessageDialog(null, Saturs.toString(),

		"Saturs: " + file.getName(), JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {

		

		JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),

		"File Read Error", JOptionPane.ERROR_MESSAGE);

		}

		break;

		}	
	}
	break;

	case "Klātienes Pasūtījumi":

		String desktopMape2 = System.getProperty("user.home") + "\\Desktop\\";//C:\Users\2PT-2\Desktop\Saņemtie_Pasūtījumi
		String AtrasanasMape2 = desktopMape2 + "Saņemtie_Pasūtījumi";					//"\\OneDrive\\Dators\\

		// Access the directory
		File Vieta2 = new File(AtrasanasMape2);

	
		if (!Vieta2.exists() || !Vieta2.isDirectory()) {
		    JOptionPane.showMessageDialog(null, "Error: " + AtrasanasMape2, 
		            "Directory Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}

		
		File[] files2 = Vieta2.listFiles();
		if (files2.length == 0) {
		    JOptionPane.showMessageDialog(null, "Mape ir tuksa: " + AtrasanasMape2, 
		            "Directory Error", JOptionPane.ERROR_MESSAGE);
		    return;
		}

		
		String[] fileNames2 = new String[files2.length];
		for (int i = 0; i < files2.length; i++) {
		    fileNames2[i] = files2[i].getName();
		}
		String selectedFileName2 = (String) JOptionPane.showInputDialog(null, "Izvelies Failu Kuru Atvert", 
		        "Atvert ", JOptionPane.PLAIN_MESSAGE, null, fileNames2, fileNames2[0]);
		if (selectedFileName2 == null) {
		    return; 
		}

		
		for (File file : files2) {
		    if (file.getName().equals(selectedFileName2)) {
		        try {
		            FileReader reader = new FileReader(file);
		            BufferedReader bufferedReader = new BufferedReader(reader);
		            
		            StringBuilder sastavs = new StringBuilder();
		            String line;
		            while ((line = bufferedReader.readLine()) != null) {
		            	sastavs.append(line);
		            	sastavs.append(System.lineSeparator());
		            }
		            bufferedReader.close();
		            
		          
		            JOptionPane.showMessageDialog(null, sastavs.toString(), 
		                    "File Saturs: " + file.getName(), JOptionPane.INFORMATION_MESSAGE);
		            
		        } catch (IOException e) {
		           
		            JOptionPane.showMessageDialog(null, "Kluda: " + e.getMessage(), 
		                    "File Error", JOptionPane.ERROR_MESSAGE);
		        }
		        break;
		    }
		}
		
	break;

	}

	}while(!izvele.equalsIgnoreCase("Atpakaļ")) ;
	
	
	
	
}
}

