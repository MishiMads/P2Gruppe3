package com.example.p2gruppe3;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


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

    public static MediaPlayer ClickSound;
    public static MediaPlayer PointSound;
    public static MediaPlayer BadNose;
    public static MediaPlayer GoodNose;
    public static MediaPlayer Leafsound;
    public static MediaPlayer MoldClick;






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

        ClickSound = MediaPlayer.create(this, R.raw.click1);
        PointSound = MediaPlayer.create(this, R.raw.point);
        BadNose = MediaPlayer.create(this, R.raw.badsounddd);
        GoodNose = MediaPlayer.create(this,R.raw.goodsound1);
        Leafsound = MediaPlayer.create(this, R.raw.leaf);
        MoldClick = MediaPlayer.create(this, R.raw.click3);


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
                ClickSound.start();
                Intent Minigame1= new Intent(view.getContext(), MiniGame1.class);
                startActivity(Minigame1);
            }
        });
        MG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSound.start();
                Intent Minigame2 = new Intent(view.getContext(), MiniGame2.class);
                startActivity(Minigame2);
            }
        });
        MG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSound.start();
                Intent intent = new Intent(view.getContext(), Minigame3starterActivity.class);
                startActivity(intent);
            }
        });
        Drag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSound.start();
                DisplayPoints.setText("Your points: " + PlantPoints);
                int RanNumber = random.nextInt(3) +1;
                if (PlantPoints >= 3){
                    Leafsound.start();
                    PlantPoints -=3;
                    Drag1.setImageResource(R.drawable.frame);


                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("Uh oh, not enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ClickSound.start();
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ClickSound.start();
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
                ClickSound.start();
                int RanNumber = random.nextInt(3) +1;
                DisplayPoints.setText("Your points: " + PlantPoints);
                if (PlantPoints >= 5){
                    Leafsound.start();
                    PlantPoints -=5;
                    Drag2.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("You dont have enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ClickSound.start();
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ClickSound.start();
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
                ClickSound.start();
                int RanNumber = random.nextInt(3) +1;
                DisplayPoints.setText("Your points: " + PlantPoints);
                if (PlantPoints >= 7){
                    Leafsound.start();
                    PlantPoints -=7;
                    Drag3.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("You dont have enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ClickSound.start();
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ClickSound.start();
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
                ClickSound.start();
                int RanNumber = random.nextInt(3) +1;
                DisplayPoints.setText("Your points: " + PlantPoints);
                if (PlantPoints >= 5){
                    Leafsound.start();
                    PlantPoints -=5;
                    Drag4.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("You dont have enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ClickSound.start();
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ClickSound.start();
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
                ClickSound.start();
                int RanNumber = random.nextInt(3) +1;
                DisplayPoints.setText("Your points: " + PlantPoints);
                if (PlantPoints >= 10){
                    Leafsound.start();
                    PlantPoints -=10;
                    Drag5.setImageResource(R.drawable.frame);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setCancelable(true);
                    builder.setTitle("You dont have enough points");
                    builder.setMessage("You can get more points from minigames. Go to minigame?");

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ClickSound.start();
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to minigame", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ClickSound.start();
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
                ClickSound.start();
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