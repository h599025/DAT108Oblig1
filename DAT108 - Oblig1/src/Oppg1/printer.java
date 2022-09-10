package Oppg1;

public class printer extends Thread {
	
	private phrase phrase;
	
	public printer(phrase phrase) {
		this.phrase = phrase;
	}
	
	public void run() {
		while(!phrase.stoppMelding()) {
			try {
				sleep(3000);
			} catch (InterruptedException e) {
			}
			
			if(!phrase.stoppMelding()) {
				System.out.println(phrase.getPhrase());
			}
		}
	}

}
