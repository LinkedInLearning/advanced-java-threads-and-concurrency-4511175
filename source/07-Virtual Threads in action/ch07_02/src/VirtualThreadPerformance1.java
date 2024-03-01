public class VirtualThreadPerformance1 {

    public static void main(String[] args) throws InterruptedException {

//        long startTime = System.nanoTime();
//
//        for(int i = 0; i < 1_000_000; i++) {
//            Thread.ofPlatform().start(() -> System.out.println(Thread.currentThread()));
//        }
//
//        long elapsedTime = System.nanoTime() - startTime;
//        System.out.println((elapsedTime/1000000) / 1000 + " seconds");

        long startTime = System.nanoTime();

        for(int i = 0; i < 1_000_000; i++) {
            Thread thread = Thread.ofVirtual().start(() -> System.out.println(Thread.currentThread()));
            thread.join();
        }

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println((elapsedTime/1000000)/ 1000 + " seconds");


    }
}
