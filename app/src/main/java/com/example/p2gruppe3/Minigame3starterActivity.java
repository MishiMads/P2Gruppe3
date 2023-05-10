package com.example.p2gruppe3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

public class Minigame3starterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigame3starter);
        MiniGame3 miniGame3 = new MiniGame3(this);
        setContentView(miniGame3);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle("Flip the Phone");
        builder.setMessage("Flip the phone to start and then drag the avocado to either the pot to plant the avocados seeds or the bread to eat the avocado");

        builder.setNegativeButton("Start Minigame", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                MainActivity.ClickSound.start();
            }
        });


        builder.show();

    }
}