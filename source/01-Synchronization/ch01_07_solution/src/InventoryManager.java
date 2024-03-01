public class InventoryManager implements Runnable {
    private int itemCount = 200000;
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public void run() {
        String function = Thread.currentThread().getName();

        if(function.equals("issue")) {
            for(int i = 0; i < 100000; i++) {
                synchronized (this) {
                    itemCount--;
                }
            }
        } else if(function.equals("receive")) {
            for(int i = 0; i < 100000; i++) {
                synchronized (this) {
                    itemCount++;
                }
            }
        }
    }
}
