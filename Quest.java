import java.util.function.Predicate;

public class Quest {

    public final String id;
    public final String text;
    public final int ruhmReward;
    public final Predicate<GameState> condition;

    public Quest(String id, String text, int ruhmReward, Predicate<GameState> condition) {
        this.id = id;
        this.text = text;
        this.ruhmReward = ruhmReward;
        this.condition = condition;
    }

    public boolean isCompleted(GameState state) {
        return condition.test(state);
    }
}
