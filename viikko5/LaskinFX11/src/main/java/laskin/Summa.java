/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    TextField tuloskentta;
    TextField syotekentta;  
    Button nollaa; 
    Button undo; 
    Sovelluslogiikka sovellus;
    int aiempi;
    
    public Summa(TextField tuloskentta, TextField syotekentta,  Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;  
        this.nollaa = nollaa; 
        this.undo = undo; 
        this.sovellus = sovellus;
        aiempi = 0;
    }
    
    @Override
    public void suorita() {
        aiempi = sovellus.tulos();
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
    }

    @Override
    public void peru() {
        sovellus.setTulos(aiempi);
    }
}
