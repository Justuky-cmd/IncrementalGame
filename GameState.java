import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Alles, was gespeichert wird. Keine Spiellogik, nur Daten.
 */
public class GameState {

    // wird beim Rebirth zurückgesetzt
    public double gold = 0;
    public int floor = 1;
    public int monsterWaveSize = 5;
    public int monsterDefeated = 0;
    public Set<String> claimedQuests = new HashSet<>();
    public Map<String, Integer> upgradeLevels = new HashMap<>();   // Upgrade-ID -> Stufe

    // bleibt beim Rebirth
    public int ruhm = 0;
    public int rebirths = 0;
    public Set<String> skillsBought = new HashSet<>();

    /**
     * Setzt alles zurück, was beim Rebirth verloren geht.
     * TODO: selbst schreiben. Ruhm, rebirths und skillsBought bleiben.
     */
    public void rebirth() {
        
    }
}
