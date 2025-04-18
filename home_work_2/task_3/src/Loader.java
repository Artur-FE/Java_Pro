public class Loader implements Runnable {

    private String name;
    private int nBox;
    private int capacity;
    private Warehouse warehouse;
    private Warehouse warehouse2;
    private int done;

    public Loader(String name, int nBox, int capacity, Warehouse warehouse, Warehouse warehouse2) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
        this.warehouse2 = warehouse2;
    }

    @Override
    public void run() {
        while (done < nBox) {
            int value = Math.min(nBox - done, capacity);
            if (value != capacity) {
                warehouse.addValue(value);
                done += value;
                break;
            } else {
                warehouse.addValue(capacity / 2);
                warehouse2.addValue(capacity / 2);
                done += capacity;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " finish. Get: " + done + " boxes");
    }
}
