package com.example.p2gruppe3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView Map;
    float xDown = 0, yDown = 0;
    private float limitX = 10;
    private float limitY = 10;
    private int parentWidth = 0;
    private int parentHeight = 0;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map = findViewById(R.id.MapImage);

        Map.post(new Runnable() {
            @Override
            public void run() {
                // Get the width and height of the parent view
                parentWidth = ((View) Map.getParent()).getWidth();
                parentHeight = ((View) Map.getParent()).getHeight();
            }
        });

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

                        Map.setX(Map.getX()+distanceX);
                        Map.setY(Map.getY()+distanceY);





                        break;
                }

                return true;
            }
        });
       /* Map.setOnTouchListener(new View.OnTouchListener() {
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

                        Map.setX(Map.getX()+distanceX);
                        Map.setY(Map.getY()+distanceY);

                        float newX = Map.getX() + distanceX;
                        float newY = Map.getY() + distanceY;

                        if (newX < limitX) {
                            newX = limitX;
                        } else if (newX > parentWidth - Map.getWidth() - limitX) {
                            newX = parentWidth - Map.getWidth() - limitX;
                        }

                        if (newY < limitY) {
                            newY = limitY;
                        } else if (newY > parentHeight - Map.getHeight() - limitY) {
                            newY = parentHeight - Map.getHeight() - limitY;
                        }


                        Map.setX(newX);
                        Map.setY(newY);

                        break;
                }



                return true;
            }
        });

    }*/
    }


}