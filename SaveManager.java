import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

/**
 * Speichern und Laden als einfache Textdatei (java.util.Properties).
 */
public class SaveManager {

    public static final Path SAVE_FILE = Path.of("savegame.properties");

    /**
     * TODO: gold, ruhm, floor, rebirths in Properties schreiben,
     * Sets und Map als kommagetrennten String ablegen, Datei schreiben.
     */
    public static void save(GameState state, Path file) throws IOException {
    }

    /**
     * TODO: Datei lesen und einen GameState daraus bauen.
     * Existiert die Datei nicht, einen neuen GameState zurückgeben.
     */
    public static GameState load(Path file) throws IOException {
        Properties props = new Properties();
        return new GameState();
    }
}
