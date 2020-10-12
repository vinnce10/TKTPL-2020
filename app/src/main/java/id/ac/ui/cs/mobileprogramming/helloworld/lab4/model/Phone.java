package id.ac.ui.cs.mobileprogramming.helloworld.lab4.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;

public class Phone {
    String name;
    String brand;
    String shortReview;
    String imgURL;

    public Phone(String name, String brand, String shortReview, String imgURL){
        this.name = name;
        this.brand = brand;
        this.shortReview = shortReview;
        this.imgURL = imgURL;
    }

    public String getShortReview() {
        return shortReview;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getImgURL() {
        return imgURL;
    }

    @BindingAdapter("android:productImage")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView).load(imageUrl).into(imageView);
    }
}
