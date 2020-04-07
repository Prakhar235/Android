package com.pharm.smartprakhar.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pharm.smartprakhar.triviaapp.Controllers.Databasehelper;
import com.pharm.smartprakhar.triviaapp.Controllers.Game;

import java.util.Calendar;

public class Fourthpage extends AppCompatActivity {
    Game game;
    Databasehelper db;
    int gameid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthpage);
        game = (Game)(getIntent().getSerializableExtra("game"));
        TextView gamedetail1=findViewById(R.id.gamedetail1);
        TextView gamedetail2=findViewById(R.id.gamedetail2);
        TextView gamedetail3=findViewById(R.id.gamedetail3);
        Log.d("gamedetails",game.getBestcricketer());
        gamedetail1.setText("Hello "+game.getName());
        gamedetail2.setText(game.getBestcricketer());
        gamedetail3.setText(game.getFlagcolors());
        db=new Databasehelper(getApplicationContext());
        //We use squillite database through databasehelper class

        Button buttonfinish=findViewById(R.id.button_to_nextpage);
        Button buttonhistory=findViewById(R.id.history);

        buttonhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //We move to history without destroying this activity

                Intent intent = new Intent(getApplicationContext(), Historypage.class);
                startActivity(intent);




            }
        });


        buttonfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    gameid= db.getGameCount();
                    gameid++;

                }
                catch(Exception  e)
                {

                }





                try {
                    String currentdate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

                    game.setGameid(Integer.toString(gameid));
                    game.setTimestamp(currentdate);
                    Log.d("gamecount",game.getGameid());
                    db.insertGame(game);

                }
                catch(Exception e)
                {

                }

                //We Save the changes and move to First Page for a regame and this activity is destroyed


                Intent intent = new Intent(getApplicationContext(), Firstpage.class);
                startActivity(intent);
                finish();


            }
        });

    }
}
