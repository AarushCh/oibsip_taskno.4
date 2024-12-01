import java.util.*;

public class ExamTimer {
    private Timer timer;
    private TimerTask timerTask;

    public ExamTimer() {
        timer = new Timer();
    }

    public void startTimer(long delay) {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime is up! Submitting your answers...");
                System.exit(0);
            }
        };
        timer.schedule(timerTask, delay);
    }

    public void stopTimer() {
        if (timerTask != null) {
            timerTask.cancel();
        }
    }
}
