package com.example.smartpantrymanager.database;

import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {
    public static AppDatabase database;
    public static AppDatabase getInstance(Context context){
        if (database == null) {

            database = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "smart_pantry_db"
            )
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }

}
