package Oppg2;

import java.util.Random;

public class Servitor extends Thread {
    HamburgerBrett brett;
    private String navn;
    Hamburger burger;



    public Servitor (HamburgerBrett brett,String navn) {
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
            synchronized (brett){
                while(brett.erTom()) {
                    try {
                        System.out.println(navn+"(Servitør) ønsker å ta hamburger, men brett er tomt. Venter!");
                        brett.wait();
                    } catch (InterruptedException e) {
                    }

                }



                burger = brett.utKoe();
                System.out.println(navn+"(Servitør) tar av hamburger ◖"+ burger.getBurgerNr()+"◗. brett:[" + brett.toString());

                synchronized (brett){
                    brett.notifyAll();
                }
            }

        }

    }

}
