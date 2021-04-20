package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviSaksetPaperi {

    private static final Scanner scanner = new Scanner(System.in);
    TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        
        tekoaly.asetaSiirto(viimeisinSiirto);
        System.out.println("Tekoäly valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}
