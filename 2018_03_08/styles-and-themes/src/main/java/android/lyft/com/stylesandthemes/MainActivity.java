package android.lyft.com.stylesandthemes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
     Take a look at the CustomView in res/layout/activity_main.xml
     What is its background color on a v21 device?
     What is its background color on a v16 device?
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
