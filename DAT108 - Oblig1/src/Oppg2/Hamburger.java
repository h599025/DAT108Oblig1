package Oppg2;

public class Hamburger {
    private Hamburger neste;
    private Hamburger element;
    HamburgerBrett brett;
    private int burgerNr;



    public Hamburger (int nr){
        neste = null;
        element = null;
        burgerNr = nr;
    }


    public Hamburger(Hamburger elm){
        neste = null;
        element = elm;
    }

    public void setNeste(Hamburger burger){
        neste = burger;
    }

    public Hamburger getNeste(){
        return neste;
    }

    public Hamburger getElement(){
        return element;
    }
    public void setEelement(Hamburger burger){
        element = burger;
    }

    public int getBurgerNr(){return burgerNr;}
    
}
