import java.util.concurrent.ThreadLocalRandom;

public class Main {
    
    public static final int N_THREADS = 3;
    public static final int N_INTS = 5;
    
    public static void main(String[] args) throws InterruptedException {
        LatencyMonitor latencyMonitor = new LatencyMonitor();

        Thread[] threads = new Thread[N_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(
                    ()-> {
                        for (int j = 0; j < N_INTS; j++) {
                            int value = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
                            latencyMonitor.updateLatency(value);
                            System.out.println(value);
                        }
                    }

            );
        }

        for(Thread thread : threads) {
            thread.start();
        }

        for(Thread thread : threads) {
            thread.join();
        }

        System.out.println("latencyMonitor.getMinLatency() - " + latencyMonitor.getMinLatency());
    }
}