package com.pharm.smartprakhar.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pharm.smartprakhar.triviaapp.classes.Game;

public class Firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        final EditText editText=findViewById(R.id.edittext_name);
        Button buttonnext=findViewById(R.id.button_to_nextpage);
        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(editText.getText().toString().equals("")))//Validator for null
                {
                    Game game= new Game();  //Creates a object of game class in this activity only which is passed through intent
                    game.setName(editText.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), Secondpage.class);
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
