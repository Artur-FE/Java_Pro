import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private ReentrantLock lock = new ReentrantLock();
    private final String iban;
    private final String owner;
    private double balance;

    public Account(String iban, String owner, double balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }


    public void deposit(double amount) throws InterruptedException {
        if (lock.tryLock(3, TimeUnit.SECONDS)) {
            try{
                balance += amount;
            }
            finally {
                lock.unlock();
            }
        }
        else {
            System.out.println("Операция невозможна, попробуйте позже");
        }

    }

    public boolean withdraw(double amount) throws InterruptedException {
        if (lock.tryLock(3, TimeUnit.SECONDS)) {
            try {
                if (getBalance() >= amount) {
                    balance -= amount;
                    return true;
                } else {
                    System.out.println("Денег на балансе " + this.owner + " недостаточно. Ваш баланс : " + getBalance() + ". Вы хотите перевести: " + amount);
                    return false;
                }
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Операция невозможна, попробуйте позже");
            return false;
        }
    }


    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
