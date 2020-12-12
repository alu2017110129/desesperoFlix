package br.com.grupo5.desesperoFlix.databinding.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageBinding {
    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
