package xyz.vnhax.picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private String[] imageUrls = new String[] {
            "https://picsum.photos/id/1/367/267",
            "https://picsum.photos/id/1000/367/267",
            "https://picsum.photos/id/1001/367/267",
            "https://picsum.photos/id/1002/367/267",
            "https://picsum.photos/id/1/367/267",
            "https://picsum.photos/id/1/367/267"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        textView.bringToFront();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, imageUrls, width, height);
        viewPager.setAdapter(viewPagerAdapter);

    }
}
