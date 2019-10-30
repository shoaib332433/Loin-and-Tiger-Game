package com.example.lionandtigergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onImageclick(View Imageclick){

        ImageView image=(ImageView) Imageclick;

        image.setTranslationX(-2000);
        image.setImageResource(R.drawable.tiger);
        image.animate().translationXBy(2000).alpha(1).rotationX(3600).setDuration(1000);


    }

}
