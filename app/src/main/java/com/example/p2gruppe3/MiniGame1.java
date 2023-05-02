package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MiniGame1 extends AppCompatActivity {

    private static ImageView goodMilk;
    private static ImageView badMilk;
private static ImageView neutralMouth;
private static ImageView happyMouth;
private static ImageView badMouth;
private static ImageView bad;
private static ImageView Stank;
private static ImageView Stank2;
private static ImageButton badMilkButton;
private static ImageButton goodMilkButton;
private static ImageButton badEggButton;
private static ImageButton goodEggButton;
private static ImageButton badMeatButton;
private static ImageButton goodMeatButton;

private static Button nextButton;
private int nextBtn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game1);

        goodMilk=(ImageView)findViewById(R.id.goodMilk);
        goodMilkButtonClick();

        badMilk=(ImageView)findViewById(R.id.badMilk);
        badMilkButtonClick();

        bad=(ImageView)findViewById(R.id.bad);
        bad.setVisibility(View.INVISIBLE);

        Stank=(ImageView)findViewById(R.id.Stank);

        neutralMouth=(ImageView)findViewById(R.id.neutralMouth);
        neutralMouth.setVisibility(View.VISIBLE);

        badMouth=(ImageView)findViewById(R.id.badMouth);
        badMouth.setVisibility(View.INVISIBLE);

        happyMouth=(ImageView)findViewById(R.id.happyMouth);
        happyMouth.setVisibility(View.INVISIBLE);

        nextButton=(Button)findViewById(R.id.nextButton);
        nextButton.setVisibility(View.INVISIBLE);
        nextButtonClick();

        goodEggButton=(ImageButton)findViewById(R.id.goodEgg);
        goodEggButton.setVisibility(View.INVISIBLE);
        goodEggButtonClick();

        badEggButton=(ImageButton)findViewById(R.id.badEgg);
        badEggButton.setVisibility(View.INVISIBLE);
        badEggButtonClick();

        Stank2=(ImageView)findViewById(R.id.Stank2);
        Stank2.setVisibility(View.INVISIBLE);

        goodMeatButton=(ImageButton)findViewById(R.id.goodMeat);
        goodMeatButton.setVisibility(View.INVISIBLE);
        goodMeatButtonClick();

        badMeatButton=(ImageButton)findViewById(R.id.badMeat);
        badMeatButton.setVisibility(View.INVISIBLE);
        badMeatButtonClick();
    }

    public void badMilkButtonClick() {

        badMilkButton = (ImageButton) findViewById(R.id.badMilk);

        badMilkButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bad.setVisibility(View.VISIBLE);
                        neutralMouth.setVisibility(View.INVISIBLE);
                        happyMouth.setVisibility(View.INVISIBLE);
                        badMouth.setVisibility(View.VISIBLE);
                        nextButton.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }
    public void goodMilkButtonClick() {

            goodMilkButton = (ImageButton) findViewById(R.id.goodMilk);

            goodMilkButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MainActivity.PlantPoints+=3;
                            bad.setVisibility(View.INVISIBLE);
                            badMouth.setVisibility(View.INVISIBLE);
                            neutralMouth.setVisibility(View.INVISIBLE);
                            happyMouth.setVisibility(View.VISIBLE);
                            nextButton.setVisibility(View.VISIBLE);
                            badMilkButton.setVisibility(View.INVISIBLE);
                            Stank.setVisibility(View.INVISIBLE);

                        }
                    }
            );
    }

    public void badEggButtonClick() {

        badEggButton = (ImageButton) findViewById(R.id.badEgg);

        badEggButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        bad.setVisibility(View.VISIBLE);
                        neutralMouth.setVisibility(View.INVISIBLE);
                        happyMouth.setVisibility(View.INVISIBLE);
                        badMouth.setVisibility(View.VISIBLE);
                        nextButton.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    public void goodEggButtonClick() {

        goodEggButton = (ImageButton) findViewById(R.id.goodEgg);

        goodEggButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity.PlantPoints+=3;
                        bad.setVisibility(View.INVISIBLE);
                        neutralMouth.setVisibility(View.INVISIBLE);
                        happyMouth.setVisibility(View.VISIBLE);
                        badMouth.setVisibility(View.INVISIBLE);
                        nextButton.setVisibility(View.VISIBLE);
                        badEggButton.setVisibility(View.INVISIBLE);
                        Stank2.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    public void badMeatButtonClick() {

        badMeatButton = (ImageButton) findViewById(R.id.badMeat);

        badMeatButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        bad.setVisibility(View.VISIBLE);
                        neutralMouth.setVisibility(View.INVISIBLE);
                        happyMouth.setVisibility(View.INVISIBLE);
                        badMouth.setVisibility(View.VISIBLE);
                        nextButton.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    public void goodMeatButtonClick() {

        goodMeatButton = (ImageButton) findViewById(R.id.goodMeat);

        goodMeatButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity.PlantPoints+= 3;
                        bad.setVisibility(View.INVISIBLE);
                        neutralMouth.setVisibility(View.INVISIBLE);
                        happyMouth.setVisibility(View.VISIBLE);
                        badMouth.setVisibility(View.INVISIBLE);
                        nextButton.setVisibility(View.VISIBLE);
                        badMeatButton.setVisibility(View.INVISIBLE);
                        Stank2.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    public void nextButtonClick() {
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        nextBtn++;

                        if(nextBtn == 1) {
                            neutralMouth.setVisibility(View.VISIBLE);
                            bad.setVisibility(View.INVISIBLE);
                            happyMouth.setVisibility(View.INVISIBLE);
                            goodMilk.setVisibility(View.INVISIBLE);
                            badMilk.setVisibility(View.INVISIBLE);
                            nextButton.setVisibility(View.INVISIBLE);
                            badEggButton.setVisibility(View.VISIBLE);
                            goodEggButton.setVisibility(View.VISIBLE);
                            Stank2.setVisibility(View.VISIBLE);
                            Stank.setVisibility(View.INVISIBLE);
                        }

                        if(nextBtn == 2) {
                            neutralMouth.setVisibility(View.VISIBLE);
                            bad.setVisibility(View.INVISIBLE);
                            happyMouth.setVisibility(View.INVISIBLE);
                            Stank.setVisibility(View.INVISIBLE);
                            nextButton.setVisibility(View.INVISIBLE);
                            badEggButton.setVisibility(View.INVISIBLE);
                            goodEggButton.setVisibility(View.INVISIBLE);
                            goodMeatButton.setVisibility(View.VISIBLE);
                            badMeatButton.setVisibility(View.VISIBLE);
                            Stank2.setVisibility(View.VISIBLE);
                        }

                        if(nextBtn == 3) {
                            neutralMouth.setVisibility(View.INVISIBLE);
                            bad.setVisibility(View.INVISIBLE);
                            happyMouth.setVisibility(View.VISIBLE);
                            Stank.setVisibility(View.INVISIBLE);
                            nextButton.setVisibility(View.INVISIBLE);
                        }
                    }
                }
        );
    }
}