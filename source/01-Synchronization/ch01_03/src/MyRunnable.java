public class MyRunnable implements Runnable {

    private int counter;

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {

        long startTime = System.nanoTime();
        for(int i = 0; i < 1_000_000; i++) {
                counter++;
        }
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println(Thread.currentThread().getName() + " increased the counter up to: " +
                counter + " in " + elapsedTime/1000000 + " milliseconds");
    }
}
