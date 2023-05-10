package com.example.p2gruppe3;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;


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
    public static MediaPlayer Badclick;
    public static MediaPlayer Yay;

    private TextView PotText1;
    private TextView PotText2;
    private TextView PotText3;
    private TextView PotText4;
    private TextView PotText5;
    KonfettiView konfettiView;



    public void confetti()
    {
        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(10f, 30f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .stream(700, 2000L);

    }






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

        PotText1 = findViewById(R.id.BuyFor1);
        PotText2 = findViewById(R.id.buyFor2);
        PotText3 = findViewById(R.id.buyFor3);
        PotText4 = findViewById(R.id.buyFor4);
        PotText5 = findViewById(R.id.BuyFor5);


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
        Badclick = MediaPlayer.create(this,R.raw.badclick);
        Yay = MediaPlayer.create(this, R.raw.yay);


        DisplayPoints = findViewById(R.id.PlantPointsDisplay);
        DisplayPoints.setTextColor(R.color.black);

        Drawable Background = getResources().getDrawable(R.drawable.ellipse_26);

        konfettiView = findViewById(R.id.konfetti_view);

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

                        Drag1.setX(Mapsx + 2600);
                        Drag1.setY(Mapsy + 1200);

                        Drag2.setX(Mapsx + 2000);
                        Drag2.setY(Mapsy + 260);

                        Drag3.setX(Mapsx + 1300);
                        Drag3.setY(Mapsy + 1550);

                        Drag4.setX(Mapsx + 890);
                        Drag4.setY(Mapsy + 210);

                        Drag5.setX(Mapsx + 550);
                        Drag5.setY(Mapsy + 950);

                        PotText1.setX(Mapsx + 2460);
                        PotText1.setY(Mapsy + 1400);
                        PotText1.setText("Buy this pot for 3 Points");
                        PotText2.setX(Mapsx + 1860);
                        PotText2.setY(Mapsy + 460);
                        PotText2.setText("Buy this pot for 5 Points");
                        PotText3.setX(Mapsx + 1160);
                        PotText3.setY(Mapsy + 1750);
                        PotText3.setText("Buy this pot for 7 Points");
                        PotText4.setX(Mapsx + 740);
                        PotText4.setY(Mapsy + 410);
                        PotText4.setText("Buy this pot for 5 Points");
                        PotText5.setX(Mapsx + 400);
                        PotText5.setY(Mapsy + 1150);
                        PotText5.setText("Buy this pot for 10 Points");

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
                    confetti();


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
                    confetti();
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
                    confetti();
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
                    confetti();
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
                    confetti();
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