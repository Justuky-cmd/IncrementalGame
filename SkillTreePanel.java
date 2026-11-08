import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Zeichnet den Skilltree selbst. Zeichnen passiert in paintComponent.
 */
public class SkillTreePanel extends JPanel {

    private static final int RADIUS = 24;
    private final Game game;

    public SkillTreePanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(600, 500));
        setBackground(new Color(30, 30, 40));
        // TODO: MouseListener, um Knoten per Klick zu kaufen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // TODO: zuerst die Verbindungslinien (requires), danach die Knoten,
        // gekauft / kaufbar / gesperrt in unterschiedlichen Farben
        for (SkillNode node : game.skills) {
            g2.setColor(Color.GRAY);
            g2.fillOval(node.x - RADIUS, node.y - RADIUS, RADIUS * 2, RADIUS * 2);
            g2.setColor(Color.WHITE);
            g2.drawString(node.name, node.x - RADIUS, node.y + RADIUS + 15);
        }
    }
}
