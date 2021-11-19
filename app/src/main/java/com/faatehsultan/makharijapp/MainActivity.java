package com.faatehsultan.makharijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int[] imageViewList;
    int[] textList;
    int currentIndex;
    int total;
    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        total = R.string.total_chapters;
        currentIndex = 0;
        imageViewList = new int[5];
        imageViewList[0] = R.drawable.img_1;
        imageViewList[1] = R.drawable.img_2;
        imageViewList[2] = R.drawable.img_3;
        imageViewList[3] = R.drawable.img_4;
        imageViewList[4] = R.drawable.img_5;
        textList = new int[5];
        textList[0] = R.string.cat_1;
        textList[1] = R.string.cat_2;
        textList[2] = R.string.cat_3;
        textList[3] = R.string.cat_4;
        textList[4] = R.string.cat_5;

        img = findViewById(R.id.imageView);
        txt = findViewById(R.id.chapterText);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                Log.d("Current Index", String.valueOf(currentIndex));
                currentIndex = (currentIndex + 1)%5;
                updateImgText();
                break;
            case R.id.btnPrevious:
                currentIndex --;
                if(currentIndex - 1 < 0) currentIndex = 4;
                updateImgText();
                break;
        }
    }

    protected void updateImgText() {
        img.setImageResource(imageViewList[currentIndex]);
        txt.setText(textList[currentIndex]);
    }
}