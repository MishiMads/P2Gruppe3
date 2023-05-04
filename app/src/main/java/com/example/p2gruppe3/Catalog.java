package com.example.p2gruppe3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Catalog extends AppCompatActivity {

    private Button buttonAvocado;
    private Button buttonCheese;
    private Button buttonMilk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        buttonAvocado = (Button) findViewById(R.id.buttonAvocado);
        buttonCheese = (Button) findViewById(R.id.buttonCheese);
        buttonMilk = (Button) findViewById(R.id.buttonMilk);

        buttonAvocado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Catalog.this);

                builder.setCancelable(true);
                builder.setTitle("Avocado");

                builder.setMessage("Did you know that you can make your own little plant out of an avocado seed?\nBut keep in mind you will not get a fresh new avocado out of it.\n\nThis is done in different steps:\n 1: Take out the avocado pit, put some toothpicks in the upper part and place it with the pit bottom down (the more flat part) in a glass of water filled until it covers half of the pit.\n2: Place the glass in sunny spot, and you should see roots reaching down within a few weeks.\n3: Change out the water regularly and soon you will have a little avocado plant.");
                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.show();
            }
        }
        );

        buttonCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Catalog.this);

                builder.setCancelable(true);
                builder.setTitle("Cheese");
                builder.setMessage("Did you know that mold on some kinds of cheeses can be cut away and you will be able to eat the cheese safely afterward?\nHowever, this depends on the type of cheese you have.\n\nIf mold becomes visible on fresh cheese it is likely time to discard the cheese. Fresh cheeses are high in moisture, so mold can spread quickly and make the cheese unsafe to eat\nFor aged or hard cheeses mold can be cut off. Around one inch is a good rule of thumb for how much to cut away. Because that type of cheese is so dense and have less moisture, so mold can not penetrate as deeply into the cheese.");


                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.show();
            }
        }
        );

        buttonMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Catalog.this);

                builder.setCancelable(true);
                builder.setTitle("Milk");
                builder.setMessage("Did you know that you can check if your milk is spoiled by smelling it?\n\nIf it smells sour, it means that the milk is sour and it is spoiled.\nThis sour smell is caused by lactic acid bacteria as they break down and afterwards ferment the milk. This indicates that it is time to throw out the milk.");

                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.show();
            }
        }
        );
    }
}