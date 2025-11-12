import java.util.Random;

public class Produtor extends Thread {
    private final Buffer buffer;
    private final Random random = new Random();

    public Produtor(String nome, Buffer buffer) {
        super(nome);
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int qtd = random.nextInt(15) + 1;
            buffer.produzir(getName(), qtd);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
