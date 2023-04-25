package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MiniGame2 extends AppCompatActivity {

    private int numberOfMoldRemoved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game2);

        ImageButton moldButton1 = (ImageButton)findViewById(R.id.moldButton1);

        moldButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberOfMoldRemoved(1);
            }
        });
    }

    public void setNumberOfMoldRemoved(int numberOfMoldRemoved) {
        this.numberOfMoldRemoved++;
    }


}