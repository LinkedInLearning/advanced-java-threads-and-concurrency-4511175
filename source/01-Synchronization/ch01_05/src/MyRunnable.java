public class MyRunnable implements Runnable {

    private int counter;

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {

        long startTime = System.nanoTime();
        for(int i = 0; i < 1_000_000; i++) {
            synchronized (this) {
                counter++;
            }
        }
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println(Thread.currentThread().getName() + " increased the counter up to: " +
                counter + " in " + elapsedTime/1000000 + " milliseconds");
    }

    public synchronized void someMethod() {
        // Critical section here
        // The monitor is implicitly the monitor of the current object to which the method belongs
    }

}
