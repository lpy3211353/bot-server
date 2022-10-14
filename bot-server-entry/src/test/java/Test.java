import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }, 2000L, 1000L);

    }
}
