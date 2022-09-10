package Oppg3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class main {

	public static void main(String[] args) { 
		 
		final String[] kokker = {"Anne", "Erik", "Knut"}; 
		final String[] servitorer = {"Mia", "Per"}; 
		 
		skrivUtHeader(kokker, servitorer);

		BlockingQueue<Integer> brett = new ArrayBlockingQueue<>(4);
   
		for (String navn : kokker) { 
			new Kokk(brett, navn).start(); 
		} 
		
		for (String navn : servitorer) { 
			new Servitor(brett, navn).start(); 
		}
	}

	private static void skrivUtHeader(String[] kokker, String[] servitorer) {
		
		String kokk = "", servitor = "";
		
		for (int i = 0; i < kokker.length; i++) 
		{
			kokk += kokker[i].toString() + ", ";
		}
		
		for (int i = 0; i < servitorer.length; i++) 
		{
			servitor += servitorer[i].toString() + ", ";
		}
		
		System.out.println("I denne simuleringen har vi \n\t3 kokker [" + kokk + "] \n\t2 Servitører ["
							+ servitor + "] \n\tKapasiteten til brettet er 4 hamburgere \nVi starter ... \n");
	}
}
