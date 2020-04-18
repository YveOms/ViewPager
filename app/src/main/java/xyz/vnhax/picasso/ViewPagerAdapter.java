package xyz.vnhax.picasso;

import android.content.Context;
import android.media.Image;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private String[] imageUrls;

    private int width, height;


    public ViewPagerAdapter(Context context, String[] imageUrls, int width, int height) {
        this.context = context;
        this.imageUrls = imageUrls;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TextView textView = new TextView(context);
        textView.setText("this is the " + position + " view");
        ImageView imageView = new ImageView(context);
        Picasso.get()
                .load(imageUrls[position])
                .centerInside()
                .resize(width, height)
                .into(imageView);
        container.addView(imageView);
        container.addView(textView);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
