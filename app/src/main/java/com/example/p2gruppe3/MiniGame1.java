package com.example.p2gruppe3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MiniGame1 extends AppCompatActivity {

    private static ImageView goodMilk;
    private static ImageView neutralMouth;
    private static ImageView happyMouth;
    private static ImageView badMouth;
    private static ImageView bad;

    private static ImageButton goodMilkButton;
    private static ImageButton badEggButton;
    private static ImageButton goodEggButton;
    private static ImageButton badMeatButton;
    private static ImageButton goodMeatButton;

    private ImageButton Trashcan;

    private ImageButton MilkGlass;


    private int nextBtn = 0;

    private float xDown = 0, yDown = 0;

    private ImageView Nose;

    private ImageButton Bread;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game1);

        goodMilk = (ImageView) findViewById(R.id.goodMilk);
        //goodMilkButtonClick();


        bad = (ImageView) findViewById(R.id.bad);
        bad.setVisibility(View.INVISIBLE);


        neutralMouth = (ImageView) findViewById(R.id.neutralMouth);
        neutralMouth.setVisibility(View.VISIBLE);

        badMouth = (ImageView) findViewById(R.id.badMouth);
        badMouth.setVisibility(View.INVISIBLE);

        happyMouth = (ImageView) findViewById(R.id.happyMouth);
        happyMouth.setVisibility(View.INVISIBLE);


        goodEggButton = (ImageButton) findViewById(R.id.goodEgg);
        goodEggButton.setVisibility(View.INVISIBLE);


        badEggButton = (ImageButton) findViewById(R.id.badEgg);
        badEggButton.setVisibility(View.INVISIBLE);



        goodMeatButton = (ImageButton) findViewById(R.id.goodMeat);
        goodMeatButton.setVisibility(View.INVISIBLE);


        badMeatButton = (ImageButton) findViewById(R.id.badMeat);
        badMeatButton.setVisibility(View.INVISIBLE);


        Nose = (ImageView) findViewById(R.id.goodNose);

        Trashcan = (ImageButton) findViewById(R.id.Trash);
        Trashcan.setVisibility(View.INVISIBLE);

        MilkGlass = (ImageButton) findViewById(R.id.GlassMilk);
        MilkGlass.setVisibility(View.INVISIBLE);

        Bread = (ImageButton) findViewById(R.id.Toast);
        Bread.setVisibility(View.INVISIBLE);

        goodMilk.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionevent) {
                switch (motionevent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        yDown = motionevent.getY();
                        xDown = motionevent.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float xMoved, yMoved;
                        xMoved = motionevent.getX();
                        yMoved = motionevent.getY();

                        float distanceX, distanceY;
                        distanceX = xMoved - xDown;
                        distanceY = yMoved - yDown;

                        goodMilk.setX(goodMilk.getX() + distanceX);
                        goodMilk.setY(goodMilk.getY() + distanceY);

                        MilkColDetect();

                }
                return false;
            }
        });

        goodEggButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionevent) {
                switch (motionevent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        yDown = motionevent.getY();
                        xDown = motionevent.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float xMoved, yMoved;
                        xMoved = motionevent.getX();
                        yMoved = motionevent.getY();

                        float distanceX, distanceY;
                        distanceX = xMoved - xDown;
                        distanceY = yMoved - yDown;

                        goodEggButton.setX(goodEggButton.getX() + distanceX);
                        goodEggButton.setY(goodEggButton.getY() + distanceY);

                        EggColDetect();

                }
                return false;
            }
        });
    }

    private boolean MilkCollision() {
        Rect stillRect = new Rect();
        Nose.getHitRect(stillRect);

        Rect movingRect = new Rect();
        goodMilk.getHitRect(movingRect);

        return movingRect.intersect(stillRect);
    }

    private boolean MilkColDetect() {

        if (MilkCollision()) {
            BadNose();
            Trashcan.setVisibility(View.VISIBLE);
            MilkGlass.setVisibility(View.VISIBLE);
            Trashcan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.PlantPoints += 3;
                    goodMilk.setVisibility(View.GONE);
                    Eggside();
                }
            });
            MilkGlass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MiniGame1.this);

                    builder.setCancelable(true);
                    builder.setTitle("Wrong");
                    builder.setMessage("You shouldn´t drink milk if it smells weird");

                    builder.setNegativeButton("try again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to catalog", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            OpenCatalog();
                        }
                    });

                    builder.show();
                }
            });
        } else {
            NeutralNose();
            Trashcan.setVisibility(View.INVISIBLE);
            MilkGlass.setVisibility(View.INVISIBLE);
        }

        return MilkCollision();
    }

    private boolean EggCollision() {
        Rect stillRect = new Rect();
        Nose.getHitRect(stillRect);

        Rect movingRect = new Rect();
        goodEggButton.getHitRect(movingRect);

        return stillRect.intersect(movingRect);
    }

    private boolean EggColDetect() {
        if (EggCollision()) {
            GoodNose();
            Trashcan.setVisibility(View.VISIBLE);
            Bread.setVisibility(View.VISIBLE);
        } else {
            NeutralNose();
        }
        return EggCollision();
    }

    public void OpenCatalog() {
        Intent intent = new Intent(this, Catalog.class);
        startActivity(intent);
    }

    public void BadNose() {
        bad.setVisibility(View.VISIBLE);
        badMouth.setVisibility(View.VISIBLE);
        neutralMouth.setVisibility(View.INVISIBLE);
        happyMouth.setVisibility(View.INVISIBLE);
    }

    public void GoodNose() {
        bad.setVisibility(View.INVISIBLE);
        badMouth.setVisibility(View.INVISIBLE);
        neutralMouth.setVisibility(View.INVISIBLE);
        happyMouth.setVisibility(View.VISIBLE);
    }

    public void NeutralNose() {
        bad.setVisibility(View.INVISIBLE);
        badMouth.setVisibility(View.INVISIBLE);
        neutralMouth.setVisibility(View.VISIBLE);
        happyMouth.setVisibility(View.INVISIBLE);
    }

    public void Eggside() {
        MilkGlass.setVisibility(View.INVISIBLE);
        Trashcan.setVisibility(View.INVISIBLE);
        goodMilk.setVisibility(View.INVISIBLE);
        goodEggButton.setVisibility(View.VISIBLE);
    }


}

