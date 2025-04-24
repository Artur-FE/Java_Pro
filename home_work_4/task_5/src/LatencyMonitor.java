import java.util.concurrent.atomic.AtomicInteger;

public class LatencyMonitor extends Thread{

    private static AtomicInteger value = new AtomicInteger(Integer.MAX_VALUE);

    public static int getValue() {
        return value.get();
    }

    @Override
    public void run() {
        double latency = Math.random() * Integer.MAX_VALUE;
        if(latency < getValue()) {
            updateLatency(latency);
        }
        System.out.println("Метод run завершен");
    }

    public void updateLatency(double latency) {

        System.out.println("Метод updateLatency стартовал " + getValue());

        if(latency < getValue()){
            System.out.println(getValue());
            value.set((int) latency);
            System.out.println("Метод updateLatency завершен " + getValue());
        }
    }
}
