package Oppg2;

import java.util.Random;

public class Kokk extends Thread{
    private String navn;
    private static int burgerNr;

    HamburgerBrett brett;
    Hamburger burger;


    public Kokk (HamburgerBrett brett,String navn) {
        this.navn = navn;
        this.brett=brett;
    }


    @Override
    public void run(){

        while (true) {
            Random random =  new Random();
            int tid =random.nextInt(4)+2;
            try {
                sleep(tid*1000);
            } catch (InterruptedException e) {
            }
            synchronized (brett) {
                while (brett.erFull()) {
                    try {
                        System.out.println(navn+" (kokk) klar med hamburger, men brett er fullt. Venter!");
                        brett.wait();
                    } catch (InterruptedException e) {
                    }

                }
                burgerNr+=1;
                Hamburger burger = new Hamburger(burgerNr);
                brett.innKoe(burger);


                synchronized (brett){
                    brett.notifyAll();
                }
                System.out.println(navn +" (Kokk) legger på hamburger ◖" + burger.getBurgerNr()+"◗. brett: ["+ brett.toString());

            }

        }


    }

}