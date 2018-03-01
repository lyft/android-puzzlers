package android.lyft.com.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TrackedTextView> textViews = findViewsWithType(TrackedTextView.class);

        Button button = findViewById(R.id.request_layout);
        button.setOnClickListener((view) -> {
            TrackedTextView.measure = 0;
            TrackedTextView.layout = 0;

            for (TrackedTextView textView : textViews) {
                textView.requestLayout();
            }

            View decorView = getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    decorView.getViewTreeObserver().removeOnPreDrawListener(this);

                    Log.d("Puzzlers", "Measure: " + TrackedTextView.measure);
                    Log.d("Puzzlers", "Layout: " + TrackedTextView.layout);

                    return true;
                }
            });
        });
    }

    private <T extends View> List<T> findViewsWithType(Class<T> cls) {
        List<T> result = new ArrayList<>();

        ArrayDeque<View> queue = new ArrayDeque<>();
        queue.add(getWindow().getDecorView());

        while (!queue.isEmpty()) {
            View view = queue.poll();
            if (cls.isInstance(view)) {
                result.add(cls.cast(view));
            }

            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    queue.add(viewGroup.getChildAt(i));
                }
            }
        }

        return result;
    }
}
