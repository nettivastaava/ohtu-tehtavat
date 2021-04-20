package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            KPSTehdas tehdas = new KPSTehdas();
            KiviSaksetPaperi peli = tehdas.hae(vastaus);
            
            if (peli == null) {
                break;
            } else {
               peli.pelaa();
            }
        }

    }
}
