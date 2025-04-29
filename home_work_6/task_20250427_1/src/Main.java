public class Main {
//Возмите за основу проект demo20250423_1 из пятого урока.
// Реализуйте перевод денег со счета на счет без взаимной блокировки (deadlock),
// используя ReentrantLock. Например, вы можете использовать timeout при оидание блокировки.
    public static void main(String[] args) throws InterruptedException {
        Account accountA = new Account("DE1111","Jack", 1000);
        Account accountB = new Account("DE2222","John", 1000);

        Thread thread1 = new Thread(() -> {
            try {
                transfer(accountA, accountB, 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T1");
        Thread thread2 = new Thread(() -> {
            try {
                transfer(accountB, accountA, 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T2");



        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);

    }

    public static void transfer(Account from, Account to, double amount) throws InterruptedException {
//            System.out.println("account " + from + " is locked by " + Thread.currentThread().getName());
//            System.out.println("account " + to + " is locked by" + Thread.currentThread().getName());
                if(from.withdraw(amount)) {  // перевод денег from .... to
                    to.deposit(amount);
                }

//            System.out.println("account " + to + " is unlocked");

//        System.out.println("account " + from + " is unlocked");
//        System.out.println("transfer is finish");
    }

}

