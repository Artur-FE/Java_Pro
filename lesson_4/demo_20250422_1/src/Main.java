public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();

        Thread.sleep(3000);
        thread.setFinish(true);
        System.out.println(thread.isFinish());
        for (int i = 0; i < 5; i++) {
            System.out.println(thread.getCounter());
            Thread.sleep(1000);
        }
        System.out.println("Main finish");
    }
}