public class Warehouse {
    private String title;
    private int value;

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
        synchronized(this) {
            this.value += value;
        }
    }


}
