//Компания разрабатывает систему мониторинга производительности веб-сервисов. Один из важных показателей — минимальная задержка ответа (latency) от сервера. Нужно реализовать компонент LatencyMonitor, который отслеживает самое минимальное время отклика, полученное из множества параллельных потоков, поступающих от разных серверов/кластеров. Задержка - случайное целое число (мс), в диапазоне от 0 до Integer.MAX_VALUE. Каждый из N потоков-серверов генерирует это число и вызывает метод updateLatency(double latency) класса LatencyMonitor. Реализация не должна использовать synchronized или блокировки — только атомарные структуры (Atomic*).
//
public class Main {
    public static void main(String[] args) throws InterruptedException {
        LatencyMonitor latencyMonitor = new LatencyMonitor();
        LatencyMonitor latencyMonitor2 = new LatencyMonitor();
        LatencyMonitor latencyMonitor3 = new LatencyMonitor();

        latencyMonitor.start();
        latencyMonitor2.start();
        latencyMonitor3.start();
        latencyMonitor.join();
        latencyMonitor2.join();
        latencyMonitor3.join();

        System.out.println("main " + LatencyMonitor.getValue());

    }
}