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

break;

case "Klātienes Pasūtījumi":

break;

}

}while(!izvele.equalsIgnoreCase("Atpakaļ")) ;

}

}