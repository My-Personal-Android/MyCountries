package com.mycountries.view;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mycountries.R;

public class Util {

    public static void loadImage(ImageView imageView , String url , CircularProgressDrawable circularProgressDrawable){
        RequestOptions options = new RequestOptions()
                .placeholder(circularProgressDrawable)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(options)
                .load(url)
                .into(imageView);
    }

    public static CircularProgressDrawable getCircularProgressDrawable(Context context){
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(10f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }
}
