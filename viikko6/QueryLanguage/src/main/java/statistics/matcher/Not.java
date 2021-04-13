package statistics.matcher;

import statistics.Player;


public class Not implements Matcher {
    private Matcher m;
    
    public Not(Matcher matcher) {
        this.m = matcher;
    }
    public boolean matches(Player p) {
        if (!this.m.matches(p)) {
            return true;
        }
        return false;
    }
    
}
