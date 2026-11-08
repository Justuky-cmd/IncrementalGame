import java.util.ArrayList;
import java.util.List;

/**
 * Spiellogik. Hält den Zustand und die Inhalte (Quests, Upgrades, Skills).
 * Kennt keine Oberfläche, die GameWindow ruft nur tick() und click() auf.
 */
public class Game {

    public final GameState state;
    public Monster currentMonster;

    public final List<Quest> quests = new ArrayList<>();
    public final List<Upgrade> upgrades = new ArrayList<>();
    public final List<SkillNode> skills = new ArrayList<>();

    public Game() {
        this(new GameState());
    }

    public Game(GameState state) {
        this.state = state;
        this.currentMonster = Monster.forFloor(state.floor);
        initQuests();
        initUpgrades();
        initSkills();
    }

    /**
     * Wird regelmäßig vom Timer aufgerufen.
     * TODO: automatischer Angriff, Monster tot -> Gold + nächstes Monster, Quests prüfen.
     */
    private double attackTimer = 0;

    public void tick(double seconds) {
        attackTimer += seconds;
        while (attackTimer >= 1.0) {
            attackTimer -= 1.0;
            currentMonster.hp -= 1;
            checkForDead();
        }
    }

    /**
     * Klick auf den Angriffsbutton.
     */
    public void click() {
        currentMonster.hp -= 2;
        checkForDead();
    }

    public void checkForDead() {
        if(!currentMonster.isDead()) return;

        if(state.monsterWaveSize <= state.monsterDefeated){
            state.floor++;
            state.monsterDefeated = 0;
        }
        state.gold += currentMonster.goldReward;
        currentMonster = currentMonster.forFloor(state.floor);
        state.monsterDefeated++;
        
    }

    // Upgrade ein upgrade
    public void buyUpgrade(Upgrade upgrade) {
        int level = state.upgradeLevels.getOrDefault(upgrade.id, 0);
        if (level >= upgrade.maxLevel) return;

        double cost = upgrade.getCost(level);
        if (state.gold < cost) return;

        state.gold -= cost;
        state.upgradeLevels.put(upgrade.id, level + 1);
    }

    // ---- Inhalte ----

    private void initQuests() {
        quests.add(new Quest("floor5", "Erreiche Ebene 5", 1, s -> s.floor >= 5));
        // TODO: weitere Quests
    }

    private void initUpgrades() {
        upgrades.add(new Upgrade("damage", "Schärferes Schwert", "Mehr Schaden", 10, 1.15, 100));
        // TODO: weitere Upgrades
    }

    private void initSkills() {
        skills.add(new SkillNode("start", "Erwachen", "Wurzel des Baums", 1, List.of(), 300, 40));
        skills.add(new SkillNode("gold1", "Beutegier", "Mehr Gold", 2, List.of("start"), 220, 140));
        skills.add(new SkillNode("dmg1", "Kampfgeist", "Mehr Schaden", 2, List.of("start"), 380, 140));
        // TODO: weitere Knoten
    }
}
