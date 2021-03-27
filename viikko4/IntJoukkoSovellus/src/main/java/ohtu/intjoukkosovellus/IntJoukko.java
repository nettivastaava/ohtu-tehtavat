
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukko = new int[KAPASITEETTI];
    
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        joukko = new int[kapasiteetti];
  
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            return;
        }

        joukko = new int[kapasiteetti];

        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
  
        if (alkioidenLkm == joukko.length) {
            kasvataKokoa();
        }
        
        if (!kuuluu(luku)) {
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        
        return false;
    }
    
    public void kasvataKokoa() {
        int[] uusiKoko = new int[joukko.length + kasvatuskoko];
        kopioiTaulukko(uusiKoko);
    }
 
    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int poistettavanIndeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                poistettavanIndeksi = i;
                joukko[poistettavanIndeksi] = 0;
                break;
            }
        }
        if (poistettavanIndeksi != -1) {
            taytaTyhjaIndeksiValista(poistettavanIndeksi);
            return true;
        }
        return false;
    }
    
    public void taytaTyhjaIndeksiValista(int indeksi) {
        int apu;
        for (int i = indeksi; i < alkioidenLkm - 1; i++) {
                apu = joukko[i];
                joukko[i] = joukko[i + 1];
                joukko[i + 1] = apu;
            }
            alkioidenLkm--;
    }

    private void kopioiTaulukko(int[] uusi) {
        for (int i = 0; i < joukko.length; i++) {
            uusi[i] = joukko[i];
        }
        joukko = uusi;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + joukko[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += joukko[i];
                tuotos += ", ";
            }
            tuotos += joukko[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }
   
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        
        yhdiste.lisaaYhdisteeseen(yhdiste, a);
        yhdiste.lisaaYhdisteeseen(yhdiste, b);
        
        return yhdiste;
    }
    
    public static void lisaaYhdisteeseen(IntJoukko yhdiste, IntJoukko lisattavaJoukko) {
        for (int i = 0; i < lisattavaJoukko.getAlkioidenLkm(); i++) {
            yhdiste.lisaa(lisattavaJoukko.getJoukko()[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        
        muodostaLeikkaus(leikkaus, a, b);
        
        return leikkaus;
    }
    
    public static void muodostaLeikkaus(IntJoukko leikkaus, IntJoukko a, IntJoukko b) {
        for (int i = 0; i < a.getAlkioidenLkm(); i++) {
            for (int j = 0; j < b.getAlkioidenLkm(); j++) {
                if (a.getJoukko()[i] == b.getJoukko()[j]) {
                    leikkaus.lisaa(b.getJoukko()[j]);
                }
            }
        }
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        
        muodostaErotus(erotus, a, b);
 
        return erotus;
    }
    
    public static void muodostaErotus(IntJoukko erotus, IntJoukko a, IntJoukko b) {
        for (int i = 0;i < a.getAlkioidenLkm(); i++) {
           erotus.lisaa(a.getJoukko()[i]);
        }
        
        for (int i = 0; i < b.getAlkioidenLkm(); i++) {
            erotus.poista(b.getJoukko()[i]);
        }
    }

    public int[] getJoukko() {
        return joukko;
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }
           
}
