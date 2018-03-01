package android.lyft.com.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener((view) -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra(NAME, "Joe");
            startActivity(intent);
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        trace(intent.getStringExtra(NAME));

        trace(getIntent().getStringExtra(NAME));
        super.onNewIntent(intent);
        trace(getIntent().getStringExtra(NAME));
    }

    private void trace(String message) {
        Log.d("Puzzlers", message != null ? message : "null");
    }
}
