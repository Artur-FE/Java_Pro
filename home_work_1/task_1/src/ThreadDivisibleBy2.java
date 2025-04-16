public class ThreadDivisibleBy2 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i <Integer.MAX_VALUE; i = i + 2) {
                System.out.println(i);
        }
    }
}
