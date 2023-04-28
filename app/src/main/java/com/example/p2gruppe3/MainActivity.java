package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView Map;
    private ImageButton Drag;

    private float xDown = 0, yDown = 0;
    private float xDelta = 0, yDelta = 0;

    private Button MG1;

    private Button MG2;

    private Button MG3;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map = findViewById(R.id.MapImage);
        Drag = findViewById(R.id.Pot);


        MG1 = findViewById(R.id.MG1);
        MG2 = findViewById(R.id.MG2);
        MG3 = findViewById(R.id.MG3);





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

                        Map.setX(Map.getX() + distanceX);
                        Map.setY(Map.getY() + distanceY);
                        Drag.setX(Map.getX() + distanceX + 50);
                        Drag.setY(Map.getY() + distanceY + 50);

                        break;
                }

                return true;
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
    }

}