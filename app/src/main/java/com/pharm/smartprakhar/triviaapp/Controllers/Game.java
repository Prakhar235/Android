package com.pharm.smartprakhar.triviaapp.Controllers;

import java.io.Serializable;

public  class Game implements Serializable {
    public static final String TABLE_NAME = "game";

    public static final String COLUMN_GAMEID = "gameid";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CRICKETER = "cricketer";
    public static final String COLUMN_COLOURS = "colours";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_GAMEID + " TEXT PRIMARY KEY,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TIMESTAMP+ " TEXT,"
                    + COLUMN_COLOURS + " TEXT,"
                    + COLUMN_CRICKETER + " TEXT"
                    + ")";
    String name;
    String bestcricketer="";
   String flagcolors="";

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    String gameid="0";
    String timestamp;





    public String getFlagcolors() {
        return flagcolors;
    }

    public void setFlagcolors(String flagcolors) {
        this.flagcolors = flagcolors;
    }

    public String getBestcricketer() {
        return bestcricketer;
    }

    public void setBestcricketer(String bestcricketer) {
        this.bestcricketer = bestcricketer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
