import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Callable<String>> callables = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Callable<String> myCallable = new MyCallable();
            callables.add(myCallable);
        }

        for (Future<String> future : threadPool.invokeAll(callables)) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException |
                    ExecutionException e) {
            }
        }

        System.out.println(threadPool.invokeAny(callables));
        threadPool.shutdown();


    }


}
