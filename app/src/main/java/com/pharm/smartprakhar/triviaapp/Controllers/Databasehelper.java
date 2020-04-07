package com.pharm.smartprakhar.triviaapp.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.json.JSONException;

import java.util.ArrayList;

public class Databasehelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 36;

    // Database Name
    private static final String DATABASE_NAME = "Game_db";

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Game.CREATE_TABLE);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Game.TABLE_NAME);


        // Create tables again
        onCreate(db);
    }
    public void insertGame(Game game) throws JSONException {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();



            ContentValues values = new ContentValues();
            // no need to add them

            values.put(Game.COLUMN_GAMEID, game.getGameid());
        values.put(Game.COLUMN_NAME,game.getName());
        values.put(Game.COLUMN_TIMESTAMP, game.getTimestamp());
        values.put(Game.COLUMN_COLOURS, game.getFlagcolors());
        values.put(Game.COLUMN_CRICKETER, game.getBestcricketer());





            // insert row
            db.insertWithOnConflict(Game.TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);




        // close db connection
       db .close();


    }

    public ArrayList<Game> getAllGame() {
        ArrayList<Game> gamelist = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Game.TABLE_NAME + " ORDER BY " +
                Game.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Game game = new Game();
                game.setGameid(cursor.getString(cursor.getColumnIndex(Game.COLUMN_GAMEID)));
                game.setName(cursor.getString(cursor.getColumnIndex(Game.COLUMN_NAME)));
                game.setTimestamp(cursor.getString(cursor.getColumnIndex(Game.COLUMN_TIMESTAMP)));
                game.setFlagcolors(cursor.getString(cursor.getColumnIndex(Game.COLUMN_COLOURS)));
                game.setBestcricketer(cursor.getString(cursor.getColumnIndex(Game.COLUMN_CRICKETER)));





                gamelist.add(game);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return gamelist;
    }
    public int getGameCount() {
        String countQuery = "SELECT  * FROM " + Game.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;

    }


}
