/**
 * Gold-Upgrade. Die aktuelle Stufe steht im GameState (upgradeLevels), nicht hier.
 */
public class Upgrade {

    public final String id;
    public final String name;
    public final String description;
    public final double baseCost;
    public final double costGrowth;   // z. B. 1.10 = jede Stufe 10 % teurer
    public final int maxLevel;

    public Upgrade(String id, String name, String description,
                   double baseCost, double costGrowth, int maxLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.baseCost = baseCost;
        this.costGrowth = costGrowth;
        this.maxLevel = maxLevel;
    }

    /**
     * Kosten für die nächste Stufe.
     * TODO: aus baseCost, costGrowth und aktueller Stufe berechnen.
     */
    public double getCost(int currentLevel) {
        return Math.ceil(baseCost * Math.pow(costGrowth, currentLevel));
    }
}
