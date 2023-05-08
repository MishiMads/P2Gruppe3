package com.example.p2gruppe3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MiniGame2 extends AppCompatActivity {

    //A private integer is declared and assigned with the numberOfMoldRemoved variable name.
    private int numberOfMoldRemoved;

    //A private Button variable is declared with the variable name moldRemovedButton.
    private Button moldRemovedButton;

    private ImageButton moldButton1;
    private ImageButton moldButton2;
    private ImageButton moldButton3;
    private ImageButton moldButton4;
    private TextView messageText;

    private TextView Pointsdisplay;

    //@Override means that the method is from the AppCompatActivity superclass and is overriden in
    //the following code block. The onCreate() method takes a Bundle-type variable and assigns it
    //to the variable name savedInstanceState.
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        //Uses the onCreate() method of the superclass on the
        //bundle-type variable savedInstanceState to create the visual elements.
        super.onCreate(savedInstanceState);

        //Sets the layout of this activity to be the activity_mini_game2.xml XML file.
        setContentView(R.layout.activity_mini_game2);

        AlertDialog.Builder builder = new AlertDialog.Builder(MiniGame2.this);

        builder.setCancelable(true);
        builder.setTitle("Minigame 2");
        builder.setMessage("Remove the mold from the cheese by clicking on the mold spots.");

        builder.setNegativeButton("Start Minigame", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
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
                MainActivity.PlantPoints++;
                v.setVisibility(View.INVISIBLE);
                messageText.setText("You have removed " + numberOfMoldRemoved + " mold!");
                Pointsdisplay.setText("Your points: " +MainActivity.PlantPoints);

            }
        };

        //ImageButton objects are found using findViewById in the XML file.
        //The (ImageButton) is a typecast for the View object identified in the findViewByID()
        //Typecasting means converting one data type to another and in this case
        //The compiler is told that the View object is actually an ImageButton, otherwise
        //findViewByID() would just return a View object.
        //The moldButtonOnClickListener is then assigned to the moldButtonX using the
        //setOnClickListener() method. When moldButtonX is clicked, the onClick() method inside of
        //the moldButtonOnClickListener is called.
        Pointsdisplay = findViewById(R.id.Points);

        moldButton1 = (ImageButton)findViewById(R.id.moldButton1);
        moldButton1.setOnClickListener(moldButtonOnClickListener);

        moldButton2 = (ImageButton)findViewById(R.id.moldButton2);
        moldButton2.setOnClickListener(moldButtonOnClickListener);

        moldButton3 = (ImageButton)findViewById(R.id.moldButton3);
        moldButton3.setOnClickListener(moldButtonOnClickListener);

        moldButton4 = (ImageButton)findViewById(R.id.moldButton4);
        moldButton4.setOnClickListener(moldButtonOnClickListener);

        //Uses findViewById() to find moldRemovedButton from the XML file and typecasts it from a
        //View object to a Button object and assigns it to moldRemovedButton of type Button.
        moldRemovedButton = (Button)findViewById(R.id.moldRemovedButton);

        //Uses findViewById() to find messageText from the XML file and typecasts it from a
        //View object to a TextView object and assigns it to messageText of type TextView.
        messageText = (TextView)findViewById(R.id.messageText);

        //The line new View.OnClickListener() creates an anonymous class.
            //An anonymous class is a class that is defined and used once and therefore does not
            //need a name nor to be used elsewhere in the code.
        //Its used to implement the setOnClickListener() method
        //and override its onClick() method.
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
                    Return();
                }
                else if (numberOfMoldRemoved < 4)
                {
                    messageText.setText("You still need to remove " + (4-numberOfMoldRemoved) + " more mold!");
                }
            }
        });
        }

        public void Return(){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
