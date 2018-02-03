package com.khnkoyan.userimagesappwithroom.asyncTask;

import android.content.Context;
import android.os.AsyncTask;

import com.khnkoyan.userimagesappwithroom.databaseForRoom.AppDatabase;
import com.khnkoyan.userimagesappwithroom.modelsForRoom.UserRoom;

public class SaveUserDataAsyncTaskRoom extends AsyncTask<UserRoom, Void, Void> {
    private Context context;

    public SaveUserDataAsyncTaskRoom(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(UserRoom... params) {
        UserRoom user = params[0];
        AppDatabase
                .getInstance(context)
                .getDao()
                .insertUser(user);
        return null;
    }
}
