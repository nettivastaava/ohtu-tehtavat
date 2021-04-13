/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author vaxandst
 */
public class All implements Matcher {

    public boolean matches(Player p) {
        if (p != null) {
            return true;
        }
        return false;
    }
    
}
