package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviSaksetPaperi {

    private static final Scanner scanner = new Scanner(System.in);


    @Override
    protected String toisenSiirto() {
        String toinenPelaaja = scanner.nextLine();
        System.out.println("Toinen pelaaja valitsi: " + toinenPelaaja);
        return toinenPelaaja;  
    }
}