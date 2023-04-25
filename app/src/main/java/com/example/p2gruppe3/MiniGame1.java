package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;

public class MiniGame1 extends AppCompatActivity {
private static ImageView imageview;
    private static Button button;
    private int currentImage;
    int[] images={R.drawable.group_2,R.drawable.group_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game1);
        buttonclick();
    }

    public void buttonclick() {
        imageview=(ImageView)findViewById(R.id.nose);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentImage++;
                        currentImage=currentImage % images.length;
                        imageview.setImageResource(images[currentImage]);
                    }
                }
        );

    }


}