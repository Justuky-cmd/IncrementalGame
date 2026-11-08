import java.util.List;

/**
 * Ein Knoten im Skilltree. Gekauft ist er, wenn seine ID in GameState.skillsBought steht.
 */
public class SkillNode {

    public final String id;
    public final String name;
    public final String description;
    public final int ruhmCost;
    public final List<String> requires;   // IDs der Knoten, die vorher gekauft sein müssen
    public final int x;                   // Position im Baum (Pixel)
    public final int y;

    public SkillNode(String id, String name, String description,
                     int ruhmCost, List<String> requires, int x, int y) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ruhmCost = ruhmCost;
        this.requires = requires;
        this.x = x;
        this.y = y;
    }

    /**
     * TODO: true, wenn alle Voraussetzungen gekauft sind, der Knoten noch nicht gekauft ist
     * und der Ruhm reicht.
     */
    public boolean isBuyable(GameState state) {
        return false;
    }
}
