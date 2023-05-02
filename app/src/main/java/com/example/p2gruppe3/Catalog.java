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
                builder.setMessage("Did you know... Augh");

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
                builder.setMessage("Augh");


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
                builder.setMessage("Augh");

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