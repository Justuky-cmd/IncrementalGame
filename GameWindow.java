import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class GameWindow extends JFrame {

    private static final int TICK_MS = 50;

    private final Game game;
    private final SkillTreePanel skillTreePanel;

    private final JLabel goldLabel = new JLabel();
    private final JLabel ruhmLabel = new JLabel();
    private final JLabel floorLabel = new JLabel();
    private final JLabel monsterLabel = new JLabel("", SwingConstants.CENTER);
    private final JProgressBar hpBar = new JProgressBar();
    private final JButton attackButton = new JButton("Angreifen");

    public GameWindow(Game game) {
        super("Dungeon");
        this.game = game;
        this.skillTreePanel = new SkillTreePanel(game);

        setDefaultCloseOperation(EXIT_ON_CLOSE);   // TODO: vor dem Beenden speichern
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(buildTopBar(), BorderLayout.NORTH);
        add(buildBattlePanel(), BorderLayout.CENTER);
        add(buildTabs(), BorderLayout.EAST);

        attackButton.addActionListener(e -> game.click());

        new Timer(TICK_MS, e -> {
            game.tick(TICK_MS / 1000.0);
            refresh();
        }).start();

        refresh();
    }

    private JPanel buildTopBar() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 8));
        bar.add(floorLabel);
        bar.add(goldLabel);
        bar.add(ruhmLabel);
        return bar;
    }

    private JPanel buildBattlePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        hpBar.setStringPainted(true);
        panel.add(monsterLabel);
        panel.add(hpBar);
        panel.add(attackButton);
        return panel;
    }

    private JTabbedPane buildTabs() {
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Upgrades", new JLabel("TODO: Upgrade-Liste", SwingConstants.CENTER));
        tabs.addTab("Quests", new JLabel("TODO: Quest-Liste", SwingConstants.CENTER));
        tabs.addTab("Skilltree", skillTreePanel);
        return tabs;
    }

    /** Liest den Zustand aus dem Game und schreibt ihn in die Anzeige. */
    private void refresh() {
        GameState s = game.state;
        Monster m = game.currentMonster;

        floorLabel.setText("Ebene " + s.floor);
        goldLabel.setText("Gold: " + (long) s.gold);
        ruhmLabel.setText("Ruhm: " + s.ruhm);

        monsterLabel.setText(m.name);
        hpBar.setMaximum((int) m.maxHp);
        hpBar.setValue((int) Math.max(0, m.hp));
        hpBar.setString((int) Math.max(0, m.hp) + " / " + (int) m.maxHp);

        skillTreePanel.repaint();
    }
}
