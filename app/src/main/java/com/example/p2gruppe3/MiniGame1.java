package com.example.p2gruppe3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MiniGame1 extends AppCompatActivity {

    private static ImageView goodMilk;
    private static ImageView neutralMouth;
    private static ImageView happyMouth;
    private static ImageView badMouth;
    private static ImageView bad;

    private static ImageButton badEggButton;
    private static ImageButton goodEggButton;
    private static ImageButton badMeatButton;


    private ImageButton Trashcan;

    private ImageButton Trashcan2;

    private ImageButton Trashcan3;

    private ImageButton MilkGlass;

    private float xDown = 0, yDown = 0;

    private ImageView Nose;

    private ImageButton Bread;

    private ImageButton FryPan;

    private Button frontPage;


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

        badMeatButton = (ImageButton) findViewById(R.id.badMeat);
        badMeatButton.setVisibility(View.INVISIBLE);

        Nose = (ImageView) findViewById(R.id.goodNose);

        Trashcan = (ImageButton) findViewById(R.id.Trash);
        Trashcan.setVisibility(View.INVISIBLE);

        MilkGlass = (ImageButton) findViewById(R.id.GlassMilk);
        MilkGlass.setVisibility(View.INVISIBLE);

        Bread = (ImageButton) findViewById(R.id.Toast);
        Bread.setVisibility(View.INVISIBLE);

        Trashcan2 = (ImageButton) findViewById(R.id.Trash2);
        Trashcan2.setVisibility(View.INVISIBLE);

        Trashcan3 = (ImageButton) findViewById(R.id.Trash3);
        Trashcan3.setVisibility(View.INVISIBLE);

        FryPan = (ImageButton) findViewById(R.id.fryingPan);
        FryPan.setVisibility(View.INVISIBLE);

        frontPage = (Button) findViewById(R.id.Frontpage);
        frontPage.setVisibility(View.INVISIBLE);

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

        badMeatButton.setOnTouchListener(new View.OnTouchListener() {
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

                        badMeatButton.setX(badMeatButton.getX() + distanceX);
                        badMeatButton.setY(badMeatButton.getY() + distanceY);

                        MeatColDetect();

                }
                return false;
            }
        });
    }

    private boolean MeatCollision(){
        Rect stillRect = new Rect();
        Nose.getHitRect(stillRect);

        Rect movingRect = new Rect();
        badMeatButton.getHitRect(movingRect);

        return movingRect.intersect(stillRect);
    }

    private boolean MeatColDetect(){
        if (MeatCollision()){
            BadNose();
            Trashcan3.setVisibility(View.VISIBLE);
            FryPan.setVisibility(View.VISIBLE);

            frontPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OpenFront();
                }
            });

            FryPan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MiniGame1.this);

                    builder.setCancelable(true);
                    builder.setTitle("Wrong");
                    builder.setMessage("You shouldn´t eat meat if it is green!");

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
            Trashcan3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.PlantPoints += 3;
                    frontPage.setVisibility(View.VISIBLE);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MiniGame1.this);

                    builder.setCancelable(true);
                    builder.setTitle("Congrats");
                    builder.setMessage("You got all of the questions correct");

                   builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.setPositiveButton("Go to front page", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            OpenFront();
                        }
                    });

                    builder.show();
                }
            });

        } else{

        }
        return MeatCollision();
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
            Trashcan2.setVisibility(View.VISIBLE);
            Bread.setVisibility(View.VISIBLE);
            Bread.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.PlantPoints +=3;
                    Meatside();
                }
            });

            Trashcan2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MiniGame1.this);

                    builder.setCancelable(true);
                    builder.setTitle("Wrong");
                    builder.setMessage("You shouldn´t eat eggs if they smell weird or some other thing about eggs");

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
            Bread.setVisibility(View.INVISIBLE);
            Trashcan2.setVisibility(View.INVISIBLE);
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
        goodMilk.setVisibility(View.GONE);
        goodEggButton.setVisibility(View.VISIBLE);
    }

    public void Meatside(){
        goodEggButton.setVisibility(View.GONE);
        Trashcan2.setVisibility(View.INVISIBLE);
        Bread.setVisibility(View.INVISIBLE);
        badMeatButton.setVisibility(View.VISIBLE);
    }

    public void OpenFront(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

