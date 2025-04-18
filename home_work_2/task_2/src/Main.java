//Задача №1
//
//Давайте возьмем задачу про грузчиков, реализованную на занятие.
//        Теперь,  нам необходимо зафиксировать, кто из грузчиков первый справился с поставленной задачей ( и выдать ему премию). Т.е. в main должна появится запись о том, что грузчик такой то первый закончил свою работу.
//Можно немного увеличить разбросы результатов, добавив случайную паузу [5-15] миллисекунд, после того, как грузчик отнес коробки т.е. сделал одну итерацию.


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

        for (Thread thread : loaders) {
            thread.start();
        }
        boolean count = true;
        while (count) {
            for (Thread thread : loaders) {
                if (thread.isInterrupted()) {
                    System.out.println(thread.getName() + " первый");
                    count = false;
                    break;
                }
            }

        }

        for (Thread thread : loaders) {
            thread.join();
        }

        System.out.println(warehouse);
    }
}