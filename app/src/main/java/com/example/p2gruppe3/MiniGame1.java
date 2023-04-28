package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MiniGame1 extends AppCompatActivity {
private static ImageView goodNose;
private static ImageView neutralMouth;
private static ImageView happyMouth;
private static ImageView badMouth;
private static ImageView bad;
    private static ImageButton badMilkImgButton;

    private static ImageButton goodMilkImgButton;
    private int currentImage;
    int[] images={R.drawable.good_nose,R.drawable.bad_nose__1_};


    public static void setters(ImageView badNose) {
        MiniGame1.bad = bad;

    }

    public static void setGoodMilkImgButton(ImageButton goodMilkImgButton) {
        MiniGame1.goodMilkImgButton = goodMilkImgButton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game1);
        badMilkButtonClick();
        goodMilkButtonClick();
        bad=(ImageView)findViewById(R.id.bad);
        bad.setVisibility(View.INVISIBLE);
        neutralMouth=(ImageView)findViewById(R.id.neutralMouth);
        neutralMouth.setVisibility(View.VISIBLE);
        badMouth=(ImageView)findViewById(R.id.badMouth);
        badMouth.setVisibility(View.INVISIBLE);
        happyMouth=(ImageView)findViewById(R.id.happyMouth);
        happyMouth.setVisibility(View.INVISIBLE);
    }

    public void badMilkButtonClick() {
        goodNose = (ImageView) findViewById(R.id.goodNose);
        badMilkImgButton = (ImageButton) findViewById(R.id.badMilk);

        badMilkImgButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        bad.setVisibility(View.VISIBLE);
                        neutralMouth.setVisibility(View.INVISIBLE);
                        happyMouth.setVisibility(View.INVISIBLE);
                        badMouth.setVisibility(View.VISIBLE);
                    }
                }
        );
    }
    public void goodMilkButtonClick() {
            goodNose = (ImageView) findViewById(R.id.goodNose);
            goodMilkImgButton = (ImageButton) findViewById(R.id.goodMilk);

            goodMilkImgButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            bad.setVisibility(View.INVISIBLE);
                            badMouth.setVisibility(View.INVISIBLE);
                            neutralMouth.setVisibility(View.INVISIBLE);
                            happyMouth.setVisibility(View.VISIBLE);
                        }
                    }
            );

    }

}
