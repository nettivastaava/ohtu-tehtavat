
package ohtu.kivipaperisakset;

import java.util.HashMap;


public class KPSTehdas {
    HashMap<String, KiviSaksetPaperi> pelit;
    KiviSaksetPaperi tuntematon;
    
    public KPSTehdas() {
        pelit = new HashMap<>();
        
        pelit.put("a", new KPSPelaajaVsPelaaja());
        pelit.put("b", new KPSTekoaly());
        pelit.put("c", new KPSParempiTekoaly());
        
        tuntematon = null;
    }
    
    public KiviSaksetPaperi hae(String peli) {    
        return pelit.getOrDefault(peli, tuntematon);        
    }
    
}
