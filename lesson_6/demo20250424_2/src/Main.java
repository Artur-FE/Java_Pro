import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(
                () -> {
                    lock.lock();
                    try {
                        System.out.println("thread-1: Захватили ресурс ......");
                        try {
                            Thread.sleep(30_000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    } finally {
                        lock.unlock();
                        System.out.println("thread-1: Освободили ресурс ......");
                    }

                }
        );

        Thread thread2 = new Thread(() -> {
            System.out.println("thread-2: Попытались захватить  ресурс ......");
            try {
                lock.lockInterruptibly();
                try {
                    System.out.println("thread-2: Захватили ресурс ......");

                } finally {
                    lock.unlock();
                    System.out.println("thread-2: Освободили ресурс ......");
                }


            } catch (InterruptedException e) {
                System.out.println("thread-2: прерван во время ожидания блокировки");
            }
        }

        );

        Scanner scanner = new Scanner(System.in);
        System.out.println("Пользователь 1 начал длинную операцию");
        thread1.start();
        Thread.sleep(100);

        System.out.println("Пользователь 2 пытается начать операцию");
        thread2.start();

        System.out.println("Нажмите Enter....");
        scanner.nextLine();
        thread2.interrupt();


    }
}
