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

    private Button moldRemovedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Uses the onCreate() method of the superclass on the
        //bundle-type variable savedInstanceState to create the visual elements.
        super.onCreate(savedInstanceState);

        //Sets the layout of this activity to be the activity_mini_game2.xml XML file.
        setContentView(R.layout.activity_mini_game2);

        //Creates an OnClickListener object assigned to the variable moldButtonOnClickListener
        //from the OnClickListener interface in the View class.
            //An interface is a set of abstract methods, methods without implementation.
        //This variable is then used to set the OnClickListener for the button.
        //When the button is clicked, the code runs the OnClick() method.
        //OnClick() runs a code block that increments the numberOfMoldRemoved by 1.
        //Furthermore, it sets the View assigned to the v-variable to be INVISIBLE.
        //Lastly, the text in moldRemovedButton is set to what is in the parentheses.
        View.OnClickListener moldButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfMoldRemoved++;
                v.setVisibility(View.INVISIBLE);
                moldRemovedButton.setText("You have removed " + numberOfMoldRemoved + "mold!");
            }
        };

        //ImageButtons found using findViewById in the XML file.
        //The (ImageButton) is a typecast for the View object identified in the findViewByID()
        //Typecasting means converting one data type to another and in this case
        //The compiler is told that the View object is actually an ImageButton, otherwise
        //findViewByID() would just return a View object.
        //The moldButtonOnClickListener is then assigned to the moldButtonX using the
        //setOnClickListener() method. When moldButtonX is clicked, the onClick() method inside of
        //the moldButtonOnClickListener is called.

        ImageButton moldButton1 = (ImageButton)findViewById(R.id.moldButton1);
        moldButton1.setOnClickListener(moldButtonOnClickListener);

        ImageButton moldButton2 = (ImageButton)findViewById(R.id.moldButton2);
        moldButton2.setOnClickListener(moldButtonOnClickListener);

        ImageButton moldButton3 = (ImageButton)findViewById(R.id.moldButton3);
        moldButton3.setOnClickListener(moldButtonOnClickListener);

        ImageButton moldButton4 = (ImageButton)findViewById(R.id.moldButton4);
        moldButton4.setOnClickListener(moldButtonOnClickListener);
        }
    }

        /*//Gets the moldRemovedButton id of an Button in the XML layout file of the activity.
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

        //Instead of an if/else-statement, the following methods run another method
        //called onButtonClick which increments the numberOfMoldRemoved by 1 and
        //then sets the visibility of the image button to false which removes
        //its visibility on the screen. Also changes the text in moldButtonRemoved.
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
        numberOfMoldRemoved++;
        setVisible(false);
        moldRemovedButton.setText("You have removed " + numberOfMoldRemoved + "mold!");
    }*/
