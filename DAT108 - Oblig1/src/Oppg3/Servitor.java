package Oppg3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Servitor extends Thread {
	private BlockingQueue<Integer> brett;
    private String navn;
    private int nr;



    public Servitor (BlockingQueue<Integer> brett,String navn) {
        this.navn=navn;
        this.brett=brett;
    }

    public void run(){
    	
        while (true) {
            Random random =  new Random();
            int tid =random.nextInt(4);
            try {
                sleep((tid*1000)+2000);
            } catch (InterruptedException e) {
            }
            
        	try {
        		nr = brett.take();
        		System.out.println(navn + "(Servitør) tar av hamburger ◖" + nr + "◗. brett:" + brett.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
}
