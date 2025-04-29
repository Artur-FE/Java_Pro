public class Manager implements Runnable{
    private  TaskBoard taskBoard;
    private  int nTask;
    private int sizeTasksList;

    public Manager(TaskBoard taskBoard, int nTask, int sizeTasksList) {
        this.taskBoard = taskBoard;
        this.nTask = nTask;
        this.sizeTasksList = sizeTasksList;
    }

    @Override
    public void run() {
        for (int i = 0; i < nTask; i++) {
            taskBoard.setTask("task "+i, sizeTasksList);
            System.out.println("manager setTask" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            /*try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
    }
}
