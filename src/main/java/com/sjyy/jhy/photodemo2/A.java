package com.sjyy.jhy.photodemo2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/4/23.
 */

public class A extends AppCompatActivity {

    private ImageView mPlayPicture;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mPlayPicture = (ImageView) findViewById(R.id.imageView);

        //将intent1的数据传递到intent2
        Bundle extras = getIntent().getExtras();
        Bitmap zp = (Bitmap) extras.get("zp");
        mPlayPicture.setImageBitmap(zp);

    }
}
