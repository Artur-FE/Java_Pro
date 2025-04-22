import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
    private String title;
    private AtomicInteger value = new AtomicInteger();

    public Warehouse(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "title='" + title + '\'' +
                ", value=" + value +
                '}';
    }

    public void addValue(int value) {
            this.value.getAndAdd(value);


    }


}
