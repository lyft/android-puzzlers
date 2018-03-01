package android.lyft.com.bughunt;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

@SuppressWarnings("Convert2MethodRef")
public class MainActivity extends AppCompatActivity {

    private static final long POLLING_INTERVAL_MILLIS = 2000L;

    private final Handler pollingHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pollServer();
    }

    private void pollServer() {
        // ask the server for some data
        refreshDataInBackground();

        pollingHandler.postDelayed(() -> {
            pollServer();
        }, POLLING_INTERVAL_MILLIS);
    }

    private void refreshDataInBackground() {
        Log.d("Puzzlers", "Refreshing data...");
    }
}
