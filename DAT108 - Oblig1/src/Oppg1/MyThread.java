package Oppg1;

import javax.swing.*;

public class MyThread extends Thread {
	
	private phrase phrase;
	
	public MyThread(phrase phrase) {
		this.phrase = phrase;
	}
	
	@Override
	public void run() {
		while(!phrase.stoppMelding()) {
			String tekst = JOptionPane.showInputDialog("Enter your message: ");
			synchronized(phrase) {
				while(!phrase.erMeldingLest()) {
					try {
						phrase.wait();
					} catch (InterruptedException e) {
					}
				}
				phrase.setPhrase(tekst);
				phrase.notifyAll();
			}
		}
	}
}
