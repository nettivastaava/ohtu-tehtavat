package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviSaksetPaperi {

    private static final Scanner scanner = new Scanner(System.in);
    Tekoaly tekoaly = new Tekoaly();
  

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        
        tekoaly.asetaSiirto(viimeisinSiirto);
        System.out.println("Tekoäly valitsi " + tokanSiirto);
        return tokanSiirto;
        
    }
}