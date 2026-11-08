public class Monster {

    public final String name;
    public final double maxHp;
    public double hp;
    public final double damage;       // Schaden pro Sekunde auf den Helden
    public final double goldReward;

    public Monster(String name, double maxHp, double damage, double goldReward) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.damage = damage;
        this.goldReward = goldReward;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    /**
     * Erzeugt ein Monster passend zur Ebene.
     * TODO: Werte aus der Ebene berechnen (Leben, Schaden, Gold), Boss alle X Ebenen.
     * TODO: je nach Ebene werden verschiedene Monster zurückgegeben auch gruppen in höheren floors
     */
    public static Monster forFloor(int floor) {
        switch (floor) {
            case 1: return new Monster("Goblin", 10, 1, 1);
            case 2: return new Monster("Hexe", 15, 3, 2);
            case 3: return new Monster("Krieger", 20, 5, 5);
            case 4: return new Monster("Tank", 40, 3, 10);
        }
        return new Monster("Goblin", 10, 1, 1);
    }
}
