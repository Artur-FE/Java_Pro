import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl2 implements TaskBoard {
    //private String task;

    private LinkedList<String> tasks = new LinkedList<>();

    private Lock lock = new ReentrantLock();
    private Condition managerCondition = lock.newCondition();
    private Condition workerCondition = lock.newCondition();


    @Override
    public void setTask(String task, int sizeTasksList) {
        lock.lock();
        try {
            while (this.tasks.size() >= sizeTasksList) {
                try {
                    managerCondition.await();         // !!!! не wait()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.tasks.add(task);
            workerCondition.signal();   // !!!!  не notify()

        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getTask() {
        lock.lock();
        try {
            while (this.tasks.isEmpty()) {
                try {
                    workerCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String result = this.tasks.pollFirst();
            managerCondition.signal();
            return result;

        } finally {
            lock.unlock();
        }

    }
}
