import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Swing-Oberflächen gehören in den Event-Dispatch-Thread
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            // TODO: Spielstand laden, falls vorhanden (SaveManager.load)
            new GameWindow(game).setVisible(true);
        });
    }
}
