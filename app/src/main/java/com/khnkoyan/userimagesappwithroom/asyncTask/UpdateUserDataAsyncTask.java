package com.khnkoyan.userimagesappwithroom.asyncTask;

import android.content.Context;
import android.os.AsyncTask;

import com.khnkoyan.userimagesappwithroom.databaseForRoom.AppDatabase;
import com.khnkoyan.userimagesappwithroom.modelsForRoom.UserRoom;

public class UpdateUserDataAsyncTask extends AsyncTask<UserRoom, Void, Void> {
    private Context context;
    private String userEmail;

    public UpdateUserDataAsyncTask(Context context, String userEmail) {
        this.context = context;
        this.userEmail = userEmail;
    }

    @Override
    protected Void doInBackground(UserRoom... params) {
        UserRoom user = params[0];
        String name = user.getName();
        String surName = user.getSurName();
        int age = user.getAge();
        UserRoom.Gender gender = user.getGender();
        AppDatabase
                .getInstance(context)
                .getDao()
                .updateUser(name, surName, age, gender, userEmail);
        return null;
    }
}
