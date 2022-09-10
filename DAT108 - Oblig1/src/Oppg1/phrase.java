package Oppg1;

public class phrase {

	private String phrase ="Hallo verden";
	private boolean meldingLest = true;
	
	public String getPhrase() {
		meldingLest = true;
		return phrase;
	}
	
	public void setPhrase(String phrase) {
		meldingLest = false;
		this.phrase = phrase;
	}
	
	public boolean erMeldingLest() {
		return meldingLest;
	}
	
	public boolean stoppMelding() {
		return getPhrase().compareTo("quit") == 0;
	}
}
