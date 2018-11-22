package com.sjyy.jhy.photodemo2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void click(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//实例化Intent对象,使用MediaStore的ACTION_IMAGE_CAPTURE常量调用系统相机
        //该对象是requestCode
        startActivityForResult(intent, CAMERA_RESULT);//开启相机，传入上面的Intent对象
    }

    /**
     * 用onActivityResult()接收传回的图像，当用户拍完照片，或者取消后，系统都会调用这个函数
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == CAMERA_RESULT) {

            //xActivity就是启动的另一个界面，在xxxActivity中，
            Intent intent2 = new Intent(this, A.class);
            //从Intent中获取附加值
            Bundle extras = data.getExtras();
            //从附加值中获取返回的图像
            Bitmap datas = (Bitmap) extras.get("data");
            //intent2.setData(data);
            //将数据附加给intent2
            intent2.putExtra("zp", datas);
            startActivityForResult(intent2, 101);

        }

    }
}
