package Oppg1;

public class main {
	
	private phrase phrase;
	
	public static void main(String[] args) throws InterruptedException {
		
		phrase phrase = new phrase();
		
		Thread Thread1 = new MyThread(phrase);
		Thread Thread2 = new printer(phrase);
		
		Thread1.start();
		Thread2.start();
	}
}
