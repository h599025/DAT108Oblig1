package Oppg2;

public class HamburgerBrett  {
private Hamburger foran, bak;
private int antall;
private int antBurger;
private boolean burgerSent;
        HamburgerBrett brett;
        Hamburger burger;

public HamburgerBrett() {
        foran = bak = null;
        }

public void innKoe(Hamburger element) {
        Hamburger burger = new Hamburger(element);

                if (erTom()) {
                        foran = burger;
                } else {
                        bak.setNeste(burger);
                }

        bak = burger;
        antall +=1;
        antBurger+=1;
        burgerSent=true;

        }
        public int getAntBurger(){return antBurger;}
        public Hamburger utKoe() {
                Hamburger resultat = foran.getElement();


                        foran = foran.getNeste();
                        antall--;
                        if (foran == null) {
                                bak = null;
                        }


                return resultat;
        }

        public boolean erTom(){
        return (foran == null && (bak==null));
        }

        public boolean erFull(){
        return (antall >= 4);
        }

        public boolean erBurgerSent(){
        return burgerSent;
        }

        public int getAntall(){return antall;}

        public String toString() {

                Hamburger aktuell = foran;
                String resultat = "";

                while (aktuell != null) {
                        resultat = resultat + "◖"+(aktuell.getElement()).getBurgerNr()+"◗";
                        aktuell = aktuell.getNeste();
                }

                return resultat+"]";
        }


}
