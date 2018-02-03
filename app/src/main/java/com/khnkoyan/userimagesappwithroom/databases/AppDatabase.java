package com.khnkoyan.userimagesappwithroom.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.khnkoyan.userimagesappwithroom.dao.UserOrImageDAO;
import com.khnkoyan.userimagesappwithroom.models.ImageRoom;
import com.khnkoyan.userimagesappwithroom.models.UserRoom;
import com.khnkoyan.userimagesappwithroom.utils.Converters;


@Database(entities = {UserRoom.class, ImageRoom.class}, version = 2)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "AppDatabase.db";
    private static volatile AppDatabase instance;

    public abstract UserOrImageDAO getDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public static void destroyInstance() {
        instance = null;
    }
}
