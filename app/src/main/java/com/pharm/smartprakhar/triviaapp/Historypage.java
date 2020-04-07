package com.pharm.smartprakhar.triviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.pharm.smartprakhar.triviaapp.Adapters.Adapter_History;
import com.pharm.smartprakhar.triviaapp.Controllers.Databasehelper;
import com.pharm.smartprakhar.triviaapp.Controllers.Game;

import java.util.ArrayList;

public class Historypage extends AppCompatActivity {
    Databasehelper db;
    private RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    Adapter_History adapter_history;
    ArrayList<Game> gamelist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historypage);
        db=new Databasehelper(getApplicationContext());
        try {
          gamelist= db.getAllGame();

        }
        catch(Exception e)
        {

        }
        //We take the list out from database and pass it to recycler view with a adapter and we use squillite databasehelper class


        recyclerView =  findViewById(R.id.recycler_view);
        mLayoutManager =

                new LinearLayoutManager(getApplicationContext());
        if(!(gamelist.size()==0))
        {
            try {
                adapter_history=new Adapter_History(gamelist, getApplicationContext());
                recyclerView.setAdapter(adapter_history);

            }
            catch(Exception e)
            {

            }


        }
        else
        {
            Toast.makeText(getApplicationContext(), "No games in history", Toast.LENGTH_SHORT
            ).show();


        }





        recyclerView.setLayoutManager(mLayoutManager);

    }
}
