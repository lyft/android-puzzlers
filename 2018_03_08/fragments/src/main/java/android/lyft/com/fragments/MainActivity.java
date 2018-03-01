package android.lyft.com.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

@SuppressWarnings("CodeBlock2Expr")
public class MainActivity extends AppCompatActivity {

    /* What happens when we show a new instance of this Activity? */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(() -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, new MainFragment())
                    .commit();
        }).start();
    }
}
