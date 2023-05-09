package com.example.p2gruppe3;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.TextView;

import java.util.Random;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity {

    private ImageView Map;
    private ImageButton Drag1;
    private ImageButton Drag2;
    private ImageButton Drag3;
    private ImageButton Drag4;
    private ImageButton Drag5;

    private float xDown = 0, yDown = 0;



    private Button MG1;

    private Button MG2;

    private Button MG3;

    private Button Catalog;

    public static int PlantPoints;

    public static TextView DisplayPoints;

    private MediaPlayer Sound1;
    private MediaPlayer Sound2;
    private MediaPlayer Sound3;
    private MediaPlayer Sound4;
    private MediaPlayer Sound5;




    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
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

        Catalog = findViewById(R.id.CatalogButton);

        Sound1 = MediaPlayer.create(this, R.raw.click1);
        Sound2 = MediaPlayer.create(this, R.raw.click2);
        Sound3 = MediaPlayer.create(this, R.raw.click3);
        Sound4 = MediaPlayer.create(this, R.raw.click4);
        Sound5 = MediaPlayer.create(this, R.raw.click5);

        DisplayPoints = findViewById(R.id.PlantPointsDisplay);
        DisplayPoints.setTextColor(R.color.black);

        Drawable Background = getResources().getDrawable(R.drawable.ellipse_26);

        Random random = new Random();
        int RanNumber = random.nextInt(3) +1;

        Drag1.setBackground(Background);
        Drag2.setBackground(Background);
        Drag3.setBackground(Background);
        Drag4.setBackground(Background);
        Drag5.setBackground(Background);

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

                        DisplayPoints.setText("Your points: " + PlantPoints);




                        break;
                }

                return true;
            }
        });


        MG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sound1.start();
                Intent Minigame1= new Intent(view.getContext(), MiniGame1.class);
                startActivity(Minigame1);
            }
        });
        MG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sound2.start();
                Intent Minigame2 = new Intent(view.getContext(), MiniGame2.class);
                startActivity(Minigame2);
            }
        });
        MG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sound3.start();
                Intent intent = new Intent(view.getContext(), Minigame3starterActivity.class);
                startActivity(intent);
            }
        });
        Drag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sound4.start();
                DisplayPoints.setText("Your points: " + PlantPoints);
                int RanNumber = random.nextInt(3) +1;
                if (PlantPoints >= 5){
                    PlantPoints -=5;
                    Drag1.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("Uh oh, not enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            openRanMinigame(RanNumber);
                        }
                    });

                    builder.show();
                }
            }
        });

        Drag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sound5.start();
                int RanNumber = random.nextInt(3) +1;
                DisplayPoints.setText("Your points: " + PlantPoints);
                if (PlantPoints >= 7){
                    PlantPoints -=7;
                    Drag2.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("You dont have enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            openRanMinigame(RanNumber);
                        }
                    });

                    builder.show();
                }
            }
        });
        Drag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int RanNumber = random.nextInt(3) +1;
                DisplayPoints.setText("Your points: " + PlantPoints);
                if (PlantPoints >= 10){
                    PlantPoints -=10;
                    Drag3.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("You dont have enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            openRanMinigame(RanNumber);
                        }
                    });

                    builder.show();
                }
            }
        });
        Drag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int RanNumber = random.nextInt(3) +1;
                DisplayPoints.setText("Your points: " + PlantPoints);
                if (PlantPoints >= 20){
                    PlantPoints -=20;
                    Drag4.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("You dont have enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            openRanMinigame(RanNumber);
                        }
                    });

                    builder.show();
                }
            }
        });
        Drag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int RanNumber = random.nextInt(3) +1;
                DisplayPoints.setText("Your points: " + PlantPoints);
                if (PlantPoints >= 100){
                    PlantPoints -=100;
                    Drag5.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("You dont have enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            openRanMinigame(RanNumber);
                        }
                    });

                    builder.show();
                }
            }
        });

        Catalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCatalog();
            }
        });



    }

    public void OpenCatalog(){
        Intent intent = new Intent(this, com.example.p2gruppe3.Catalog.class);
        startActivity(intent);
    }
    public void openRanMinigame(int RanNumber){
        Intent intent;
        switch (RanNumber){
            case 1:
                intent = new Intent(this, MiniGame1.class);
                break;
            case 2:
                intent = new Intent(this,MiniGame2.class);
                break;
            case 3:
                intent = new Intent(this, MiniGame3.class);
                break;
            default:
                return;
        }
        startActivity(intent);
    }



}