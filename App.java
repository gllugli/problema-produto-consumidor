public class App {
    public static void main(String[] args) {
        LogWriter log = null;
        try {
            log = new LogWriter("saida-log.txt");
            Buffer buffer = new Buffer(log);

            Produtor p1 = new Produtor("Produtor-1", buffer);
            Produtor p2 = new Produtor("Produtor-2", buffer);
            Consumidor c1 = new Consumidor("Consumidor-1", buffer);
            Consumidor c2 = new Consumidor("Consumidor-2", buffer);

            p1.start(); p2.start();
            c1.start(); c2.start();

            p1.join(); p2.join();
            c1.join(); c2.join();

            System.out.println("Execução concluída! Verifique o arquivo saida-log.txt");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (log != null) log.close();
        }
    }
}
