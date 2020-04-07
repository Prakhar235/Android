package com.pharm.smartprakhar.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pharm.smartprakhar.triviaapp.classes.Game;

import java.util.ArrayList;

public class Thirdpage extends AppCompatActivity {
    Game game;
   ArrayList<String> selectedvalue=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdpage);
        game = (Game)(getIntent().getSerializableExtra("game"));
        Log.d("Game",game.getName());
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkbox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkbox4 = (CheckBox) findViewById(R.id.checkBox4);
        final ArrayList<CheckBox> checkboxlist=new ArrayList<>();
       checkboxlist.add(checkbox1);
       checkboxlist.add(checkbox2);//We Make a list of Checkbox and attach setOnCheckChangeListener through a loop
       checkboxlist.add(checkbox3);
       checkboxlist.add(checkbox4);

       int x;
       for(x=0;x<=checkboxlist.size()-1;x++)
       {

           checkboxlist.get(x).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                   if (isChecked) {
                       //manupulates list according to ischecked boolean value
                       selectedvalue.add(compoundButton.getText().toString());

                   }
                   else
                   {
                       selectedvalue.remove(compoundButton.getText().toString());

                   }

               }
           });

       }



        Button buttonnext=findViewById(R.id.button_to_nextpage);
        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(selectedvalue.size()==0))
                {
                    //value is extracted and put into the object

                    game.setFlagcolors(stringifycolours(selectedvalue));
                    Intent intent = new Intent(getApplicationContext(), Fourthpage.class);
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
    private String stringifycolours(ArrayList<String> colourlist)
    {
        //We return a comma separated string from arraylist to fill the object
        String flagcolours="";
        int x;
       for(x=0;x<=colourlist.size()-1;x++)
       {
           flagcolours=flagcolours+colourlist.get(x)+",";

       }



       return flagcolours;


    }

}
