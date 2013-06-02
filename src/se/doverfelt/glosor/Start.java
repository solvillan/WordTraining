package se.doverfelt.glosor;

import javax.swing.JOptionPane;
import java.io.IOException;

public class Start {
	
	public Start() {
		
	}
	
	
	public static void main(String[] args) throws IOException  {
		
		String words = JOptionPane.showInputDialog("Write the words separeted by a semi-colon (;)");
		
		@SuppressWarnings("unused")
		Window window = new Window(words);
		
	}
	
//	private static void help() {
//		System.out.println("Write as many args you want, \nAs long as they are Even.");
//		System.out.println("Like this: <Eng> <Swe> <Eng> <Swe> ...");
//	}
}
