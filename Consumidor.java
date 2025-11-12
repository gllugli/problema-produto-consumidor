import java.util.Random;

public class Consumidor extends Thread {
    private final Buffer buffer;
    private final Random random = new Random();

    public Consumidor(String nome, Buffer buffer) {
        super(nome);
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int qtd = random.nextInt(12) + 1;
            buffer.consumir(getName(), qtd);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
