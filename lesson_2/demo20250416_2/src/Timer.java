import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer implements Runnable{
    public static int timeOut = 1;

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern(
                    "hh:mm:ss"
            )));
            try {
                Thread.sleep(timeOut *1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
