import java.util.concurrent.atomic.AtomicInteger;

public class LatencyMonitor {

    private final AtomicInteger minLatency = new AtomicInteger(Integer.MAX_VALUE);

    public void updateLatency(int latency){

        while (true) {

            int currentMin = minLatency.get();
            if (latency >= currentMin) {
                return;
            }
            if (minLatency.compareAndSet(currentMin, latency)) {
                return;
            }
        }
    }

    public int getMinLatency() {
        return minLatency.get();
    }
}
