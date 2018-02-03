package com.khnkoyan.userimagesappwithroom.asyncTask;

import android.content.Context;
import android.os.AsyncTask;

import com.khnkoyan.userimagesappwithroom.databaseForRoom.AppDatabase;

/**
 * Created by User on 02.02.2018.
 */

public class DeleteUserDataByEmail extends AsyncTask<String, Void, Void> {
    private Context context;

    public DeleteUserDataByEmail(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(String... params) {
        String userEmail = params[0];
        AppDatabase
                .getInstance(context)
                .getDao()
                .deleteUser(userEmail);
        return null;
    }
}
