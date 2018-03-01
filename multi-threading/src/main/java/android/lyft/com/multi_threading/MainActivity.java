package android.lyft.com.multi_threading;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {

    private static final String RESULT = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        puzzler();
    }

    private void puzzler() {
        SharedPreferences puzzlePref =
                getSharedPreferences("puzzler", Context.MODE_PRIVATE);

        HandlerThread thread1 = new HandlerThread("thread1");
        HandlerThread thread2 = new HandlerThread("thread2");
        thread1.start();
        thread2.start();

        CountDownLatch latchOne = new CountDownLatch(3);
        CountDownLatch latchTwo = new CountDownLatch(1);

        Handler handler1 = new Handler(thread1.getLooper());
        handler1.post(() -> {
            puzzlePref.edit().putInt(RESULT, 4).apply();
            latchTwo.countDown();
            try {
                latchOne.await();
            } catch (InterruptedException e) { }
            puzzlePref.edit().putInt(RESULT, 8).apply();
        });

        Handler handler2 = new Handler(thread2.getLooper());
        handler2.post(() -> {
            puzzlePref.edit().putInt(RESULT, 10).apply();
            latchOne.countDown();
            try {
                latchTwo.await();
                latchOne.countDown();
            } catch (Exception e) { }
            puzzlePref.edit().putInt(RESULT, 19).apply();
        });

        new Handler().postDelayed(() -> {
            int result = puzzlePref.getInt(RESULT, 12);
            Log.d("Puzzlers", "Result is: " + result);
        }, 2000);
    }

}
