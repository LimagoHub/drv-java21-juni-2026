package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool ();
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add( service.submit(new SinnDesLebens()));
        }

        service.shutdown();

        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }

        //service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("Fertig");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random()*2000));
            System.out.println(Thread.currentThread().getId() +  "Finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class SinnDesLebens implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep((long)(Math.random()*2000));
        System.out.println(Thread.currentThread().getId() +  "Finished");
        return 42;

    }
}
