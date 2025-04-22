public class Loader implements Runnable{

    private String name;
    private int nBox;
    private int capacity;
    private Warehouse warehouse;
    private int done;

    public Loader(String name, int nBox, int capacity, Warehouse warehouse) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
    }


    @Override
    public void run() {
        Thread.currentThread().setName(name);
        while (!Thread.currentThread().isInterrupted()){
            if(done < nBox) {
                int value = Math.min(nBox - done, capacity);
                warehouse.addValue(value);
                done += capacity;
//                 System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().isInterrupted() + " done < 1000");
                if(done == 1000) {
                    Thread.currentThread().interrupt();
//                    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().isInterrupted() + " done == 1000");
                    break;
                }
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
//        System.out.println(name + Thread.currentThread().getName() + Thread.currentThread().isInterrupted());
        System.out.println(name + " finish. Get: " + done + " boxes");
    }
}
