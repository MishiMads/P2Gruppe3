package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.type.Color;

public class MainActivity extends AppCompatActivity {

    private ImageView Map;
    private ImageButton Drag1;
    private ImageButton Drag2;
    private ImageButton Drag3;
    private ImageButton Drag4;
    private ImageButton Drag5;

    private float xDown = 0, yDown = 0;
    private float xDelta = 0, yDelta = 0;

    private Button MG1;

    private Button MG2;

    private Button MG3;

    private Button Change;

    public static int PlantPoints;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map = findViewById(R.id.MapImage);
        Drag1 = findViewById(R.id.Pot);
        Drag2 = findViewById(R.id.Pot2);
        Drag3 = findViewById(R.id.pot3);
        Drag4 = findViewById(R.id.pot4);
        Drag5 = findViewById(R.id.pot5);


        MG1 = findViewById(R.id.MG1);
        MG2 = findViewById(R.id.MG2);
        MG3 = findViewById(R.id.MG3);

        Change = findViewById(R.id.BGB);



        Map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getActionMasked()){

                    case MotionEvent.ACTION_DOWN:
                        xDown = motionEvent.getX();
                        yDown = motionEvent.getY();

                        break;

                    case MotionEvent.ACTION_MOVE:
                        float xMoved, yMoved;
                        xMoved = motionEvent.getX();
                        yMoved = motionEvent.getY();

                        float distanceX = xMoved - xDown;
                        float distanceY = yMoved - yDown;

                        float Mapsx = Map.getX() + distanceX;
                        float Mapsy = Map.getY() + distanceY;

                        Map.setX(Mapsx);
                        Map.setY(Mapsy);
                        Drag1.setX(Mapsx + 50);
                        Drag1.setY(Mapsy + 1300);
                        Drag2.setX(Mapsx + 1500);
                        Drag2.setY(Mapsy + 2500);
                        Drag3.setX(Mapsx + 5000);
                        Drag3.setY(Mapsy + 1600);
                        Drag4.setX(Mapsx + 4490);
                        Drag4.setY(Mapsy + 750);
                        Drag5.setX(Mapsx + 3500);
                        Drag5.setY(Mapsy + 1800);
                        break;
                }

                return true;
            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Drag1.setBackgroundColor(R.color.black);
                Drag2.setBackgroundColor(R.color.white);
                Drag3.setBackgroundColor(R.color.white);
                Drag4.setBackgroundColor(R.color.white);
                Drag5.setBackgroundColor(R.color.white);


            }
        });



        MG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Minigame1= new Intent(view.getContext(), MiniGame1.class);
                startActivity(Minigame1);
            }
        });
        MG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Minigame2 = new Intent(view.getContext(), MiniGame2.class);
                startActivity(Minigame2);
            }
        });
        MG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Minigame3= new Intent(view.getContext(), MiniGame3.class);
                startActivity(Minigame3);
            }
        });
        Drag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantPoints ++;
                if (PlantPoints >= 5){
                    Drag1.setImageResource(R.drawable.frame);
                }
            }
        });

        Drag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantPoints ++;
                if (PlantPoints >= 7){
                    Drag2.setImageResource(R.drawable.frame);
                }
            }
        });
        Drag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantPoints ++;
                if (PlantPoints >= 10){
                    Drag3.setImageResource(R.drawable.frame);
                }
            }
        });
        Drag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantPoints ++;
                if (PlantPoints >= 20){
                    Drag4.setImageResource(R.drawable.frame);
                }
            }
        });
        Drag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlantPoints ++;
                if (PlantPoints >= 100){
                    Drag5.setImageResource(R.drawable.frame);
                }
            }
        });
    }

}