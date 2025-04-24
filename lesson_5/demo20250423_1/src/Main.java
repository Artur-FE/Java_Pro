public class Main {
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("DE1111", "Jack", 1000);
        Account accountB = new Account("DE2222", "John", 1000);

        Thread thread1 = new Thread(()-> transfer(accountA, accountB, 100), "Thread1");
        Thread thread2 = new Thread(()-> transfer(accountB, accountA, 200), "Thread2");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);
    }

    public static void transfer(Account from, Account to, double amount){

        synchronized (from) {
            System.out.println("account " + from + " is locked" + Thread.currentThread().getName());

            synchronized (to) {
                System.out.println("account " + to + " is locked");
                from.withdraw(amount);
                to.deposit(amount);
            }
            System.out.println("account " + to + " is unlocked");
        }
        System.out.println("account " + from + " is unlocked");
        System.out.println("transfer is finish");
    }
}