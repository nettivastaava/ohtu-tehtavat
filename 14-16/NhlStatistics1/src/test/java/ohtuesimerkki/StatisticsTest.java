
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 
    
    @Test
    public void correctStatisticsAreShownForExistingPlayer() {
        Player p = stats.search("Lemieux");
        
        assertEquals(p.getName(), "Lemieux");
        assertEquals(p.getGoals(), 45);
        assertEquals(p.getAssists(), 54);
        assertEquals(p.getPoints(), 45+54);
        assertEquals(p.getTeam(), "PIT");
    }
    
    @Test
    public void searchingInvalidPlayerReturnsNull() {
        Player p = stats.search("Pallekallejallu");
        
        assertEquals(p, null);
    }
    
    @Test
    public void searchByTeamReturnCorrectPlayers() {
        List<Player> team = stats.team("EDM");
        
        assertEquals(team.size(), 3);
    }
    
    @Test
    public void topScorersAreListedCorrectly() {
        List<Player> scorers = stats.topScorers(3);
        
        assertEquals(scorers.size(), 4);
    }
}
