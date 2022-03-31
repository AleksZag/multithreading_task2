import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    final static int maxMassage = 3;

    public MyCallable() {
    }

    @Override
    public String call() throws Exception {
        int massageCounter = 0;

        while (massageCounter < maxMassage) {
            massageCounter++;
            Thread.sleep(2500);
            System.out.println("Я "  +Thread.currentThread().getName() + " Всем привет!");
        }
        return "Количество сообщений " + massageCounter;

    }
}
