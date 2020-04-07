package com.pharm.smartprakhar.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pharm.smartprakhar.triviaapp.classes.Game;

public class Secondpage extends AppCompatActivity {
    Game game;
    String selectedvalue="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);

        game = (Game)(getIntent().getSerializableExtra("game"));
        Log.d("Game",game.getName());
        final RadioGroup radioGroup=(RadioGroup) findViewById(R.id.radiogroup);


        Button buttonnext=findViewById(R.id.button_to_nextpage);
        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonID = radioGroup.getCheckedRadioButtonId();
                // If nothing is selected from Radio Group, then it return -1
                if(selectedRadioButtonID != -1)
                {



                    //Value is extracted and put into the object


                        RadioButton selectedRadioButton = (RadioButton)(radioGroup. findViewById(selectedRadioButtonID));
                        Log.d("selected",selectedRadioButtonID+"");
                        String selectedRadioButtonText = selectedRadioButton.getText().toString();
                    Log.d("selectedtext",selectedRadioButtonText);
                        game.setBestcricketer(selectedRadioButtonText);






                    Intent intent = new Intent(getApplicationContext(), Thirdpage.class);
                    intent.putExtra("game", game);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "This field cannot be blank", Toast.LENGTH_SHORT
                    ).show();


                }

            }
        });

    }
}
