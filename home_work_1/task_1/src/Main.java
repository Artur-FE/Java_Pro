public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread threadDivisibleBy2 = new ThreadDivisibleBy2();
        Thread threadDivisibleBy3 = new ThreadDivisibleBy3();
        threadDivisibleBy2.setDaemon(true);
        threadDivisibleBy3.setDaemon(true);
        threadDivisibleBy2.start();
        threadDivisibleBy3.start();
        Thread.sleep(3000);
    }
}