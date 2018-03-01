package android.lyft.com.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /* What is printed when we show a new instance of this Activity? */

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        trace("onCreated");

        finish();
        trace("finished");
    }

    @Override
    protected void onStart() {
        super.onStart();
        trace("onStarted");
    }

    @Override
    protected void onResume() {
        super.onResume();
        trace("onResumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        trace("onPaused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        trace("onStopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        trace("onDestroyed");
    }

    private void trace(String message) {
        Log.d("Puzzlers", message);
    }
}
