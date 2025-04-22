public class Main {
    private static final int N_Box = 1000;
    private static final int CAPACITY = 1;

    public static void main(String[] args) throws InterruptedException {
        Warehouse warehouse = new Warehouse("#1");
        Thread[] loaders = {
                new Thread(new Loader("Jack", N_Box, CAPACITY, warehouse)),
                new Thread(new Loader("John", N_Box, CAPACITY, warehouse)),
                new Thread(new Loader("Nick", N_Box, CAPACITY, warehouse)),
        };

        for(Thread thread : loaders) {
            thread.start();
        }
        for(Thread thread : loaders) {
            thread.join();
        }

        System.out.println(warehouse);
    }
}