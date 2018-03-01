package android.lyft.com.stylesandthemes;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.customViewStyle);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray attributes =
                context.obtainStyledAttributes(
                        attrs,
                        R.styleable.CustomView,
                        defStyleAttr,
                        R.style.Widget_DefaultCustomView);
        int backgroundColor =
                attributes.getColor(R.styleable.CustomView_backgroundColor, 0);
        attributes.recycle();

        setBackgroundColor(backgroundColor);

        Log.d("Puzzlers", "Background color is: " + Integer.toHexString(backgroundColor));
    }
}
