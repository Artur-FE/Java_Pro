//Задача №2
//
//Давайте доработаем задачку про грузчиков написанную на занятие.
//Давайте добавим второй склад, и теперь грузчик должен брать 2 коробки за раз, но одну отвозить на один склад, а вторую на второй. Т.е. за одну итерацию!


public class Main {
    private static final int N_Box = 1000;
    private static final int CAPACITY = 2;

    public static void main(String[] args) throws InterruptedException {
        Warehouse warehouse = new Warehouse("#1");
        Warehouse warehouse2 = new Warehouse("#2");
        Thread[] loaders = {
                new Thread(new Loader("Jack", N_Box, CAPACITY, warehouse, warehouse2)),
                new Thread(new Loader("John", N_Box, CAPACITY, warehouse, warehouse2)),
                new Thread(new Loader("Nick", N_Box, CAPACITY, warehouse, warehouse2)),
        };

        for(Thread thread : loaders) {
            thread.start();
        }
        for(Thread thread : loaders) {
            thread.join();
        }

        System.out.println(warehouse);
        System.out.println(warehouse2);
    }
}