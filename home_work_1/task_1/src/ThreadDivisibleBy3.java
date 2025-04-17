public class ThreadDivisibleBy3 extends Thread{

    public void run() {
        for (int i = 0; i <Integer.MAX_VALUE; i = i + 3) {
                System.out.println(i);
        }
    }
}
