public class Main {
    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        System.out.println(name + " " + id + " Start");


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + " Start Анонимный класс");
            }
        };

        Thread[] treds = {
                new MyThread(),
                new MyThread(),
                new Thread(new MyRunnable()),
                new Thread(() -> {
                    System.out.println(
                            Thread.currentThread().getName() + " " + " Start Lambda");
                }),
                thread1

        };

        for (Thread thread : treds) {
            thread.start();
        }

        for (Thread thread : treds) {
            thread.join();
        }


        Thread.sleep(1000);
        System.out.println(name + " " + id + " Finish");


    }
}