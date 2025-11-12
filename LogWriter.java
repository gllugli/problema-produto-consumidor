import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogWriter {
    private final BufferedWriter bw;

    public LogWriter(String path) throws IOException {
        this.bw = new BufferedWriter(new FileWriter(path, false));
    }

    public synchronized void log(String tipo, String thread, int espacos) {
        try {
            String linha = String.format("%s | %-10s | %-12s | Espaços disponíveis: %d",
                    LocalDateTime.now(), tipo, thread, espacos);
            bw.write(linha);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void close() {
        try {
            bw.close();
        } catch (IOException ignored) {}
    }
}
