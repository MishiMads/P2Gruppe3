package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Minigame3starterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigame3starter);
        MiniGame3 miniGame3 = new MiniGame3(this);
        setContentView(miniGame3);

    }
}