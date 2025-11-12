import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private final int capacidade = 7;
    private final Queue<Integer> fila = new LinkedList<>();
    private final Semaphore empty = new Semaphore(capacidade, true);
    private final Semaphore full = new Semaphore(0, true);
    private final ReentrantLock mutex = new ReentrantLock(true);
    private final LogWriter log;

    public Buffer(LogWriter log) {
        this.log = log;
    }

    public void produzir(String nomeProdutor, int quantidade) throws InterruptedException {
        for (int i = 0; i < quantidade; i++) {
            empty.acquire();       // espera espaço disponível
            mutex.lock();          // entra na região crítica
            try {
                fila.add(i);
                int espacos = capacidade - fila.size();
                log.log("Produtor", nomeProdutor, espacos);
            } finally {
                mutex.unlock();    // sai da região crítica
                full.release();    // sinaliza que há item disponível
            }
        }
    }

    public void consumir(String nomeConsumidor, int quantidade) throws InterruptedException {
        for (int i = 0; i < quantidade; i++) {
            full.acquire();        // espera item disponível
            mutex.lock();          // entra na região crítica
            try {
                fila.poll();
                int espacos = capacidade - fila.size();
                log.log("Consumidor", nomeConsumidor, espacos);
            } finally {
                mutex.unlock();    // sai da região crítica
                empty.release();   // sinaliza espaço livre
            }
        }
    }
}
