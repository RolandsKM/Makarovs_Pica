package Picerija;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Pasutijum{

//public static void main(String[] args) {

Pasutijum(){

String[] opcijas={"Pasūtīttie Pasūtījumi", "Klātienes Pasūtījumi", "Atpakaļ"};

String izvele;

do {

izvele=(String) JOptionPane.showInputDialog(null, "Izvelies Pasūtījumu!", "Izvele", JOptionPane.QUESTION_MESSAGE, null, opcijas, opcijas[0]);

switch(izvele) {

case "Pasūtīttie Pasūtījumi":

	
	String desktopPath = System.getProperty("user.home") + "\\Desktop\\"; //C:\Users\2PT-2\Desktop\Saņemtie_Pasūtījumi

	String Fails = desktopPath + "Pasūtītās_Picas";

	

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

	String FailuVards = (String) JOptionPane.showInputDialog(null, "Choose a file to open:",

	"Open File", JOptionPane.PLAIN_MESSAGE, null, fileNos, fileNos[0]);

	if (FailuVards == null) {

	return; 

	}

	

	for (File file : files) {

	if (file.getName().equals(FailuVards)) {

	try {

	FileReader reader = new FileReader(file);

	BufferedReader bufferedReader = new BufferedReader(reader);

	StringBuilder contentBuilder = new StringBuilder();

	String line;

	while ((line = bufferedReader.readLine()) != null) {

	contentBuilder.append(line);

	contentBuilder.append(System.lineSeparator());

	}

	bufferedReader.close();

	

	JOptionPane.showMessageDialog(null, contentBuilder.toString(),

	"File Contents: " + file.getName(), JOptionPane.INFORMATION_MESSAGE);

	} catch (IOException e) {

	

	JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(),

	"File Read Error", JOptionPane.ERROR_MESSAGE);

	}

	break;

	}	
}
break;

case "Klātienes Pasūtījumi":

break;

}

}while(!izvele.equalsIgnoreCase("Atpakaļ")) ;

}

}