package Oppg3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Kokk extends Thread{
    private String navn;
    private static int burgerNr;
    private BlockingQueue<Integer> brett;

    public Kokk (BlockingQueue<Integer> brett,String navn) {
    	this.navn = navn;
        this.brett=brett;
    }

    @Override
    public void run() {

    	while (true) {
    		Random random =  new Random();
	        int tid =random.nextInt(4)+2;
	        try {
	            sleep(tid*1000);
	        } catch (InterruptedException e) {
	        }
	        burgerNr+=1;
            try {
            	brett.put(burgerNr);
            	System.out.println(navn +" (Kokk) legger på hamburger ◖" + burgerNr + "◗. brett: "+ brett.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}