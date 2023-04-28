package com.example.p2gruppe3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MiniGame2 extends AppCompatActivity {

    private int numberOfMoldRemoved;

    //Gets the moldRemovedButton id of an Button in the XML layout file of the activity.
    private Button moldRemovedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game2);

        moldRemovedButton = (Button)findViewById(R.id.moldRemovedButton);

        //Gets the moldButtonX id of an ImageButton in the XML layout file of the activity.
        ImageButton moldButton1 = (ImageButton)findViewById(R.id.moldButton1);
        ImageButton moldButton2 = (ImageButton)findViewById(R.id.moldButton2);
        ImageButton moldButton3 = (ImageButton)findViewById(R.id.moldButton3);
        ImageButton moldButton4 = (ImageButton)findViewById(R.id.moldButton4);

        //Explanation of the methods using setOnClickListener below:
        //This method calls the setOnClickListener() method on the ImageButton object.
        //new View.OnClickListener() creates an anonymous class.
        //An anonymous class is a class that is defined and used once and therefore does not
        //need a name nor to be used elsewhere in the code.
        //Its used to implement the setOnClickListener() method
        //and override its onClick() method.
        //View.OnClickListener() overrides its onClick() method to run
        //the specific code block we want.
        //View v is its physical view/appearance on the screen's UI but we don't use it
        //to manipulate anything about the button

        moldRemovedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //When the button is pressed, it checks if the user has removed 4 molds,
                //which is kept track of by using the numberOfMoldRemoved integer variable.
                //If numberOfMoldRemoved is equals 4, then it runs the block of code that
                //tells the user they've won. If the variable isn't exactly 4, then the code
                //will run the "lose" screen which tells the user they haven't removed all of the
                //mold!

                if (numberOfMoldRemoved == 4)
                {
                    //Victory screen! WOO!!!
                }

                else
                {
                    //Tell the user they haven't removed all of the mold and therefore they can't
                    //eat it yet.
                }

            }
        });

        moldButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });

        moldButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });

        moldButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });

        moldButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });
    }

    private void onButtonClick() {

        //Increments the numberOfMoldRemoved by 1 and then sets the visibility of the
        //image button to false which removes its visibility on the screen.
        //Changes the text in moldButtonRemoved.

        numberOfMoldRemoved++;
        setVisible(false);
        moldRemovedButton.setText("You have removed " + numberOfMoldRemoved + "mold!");
    }

}