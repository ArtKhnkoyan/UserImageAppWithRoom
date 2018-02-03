package com.khnkoyan.userimagesappwithroom.asyncTask;

import android.os.AsyncTask;

import com.khnkoyan.userimagesappwithroom.activities.ImageActivity;
import com.khnkoyan.userimagesappwithroom.activities.ProfileActivity;
import com.khnkoyan.userimagesappwithroom.databaseForRoom.AppDatabase;
import com.khnkoyan.userimagesappwithroom.modelsForRoom.UserRoom;

public class GetUserDataAsyncTaskRoom extends AsyncTask<String, Void, UserRoom> {
    private ProfileActivity activity;
    private ImageActivity activityWithCheckbox;

    public GetUserDataAsyncTaskRoom(ProfileActivity activity) {
        this.activity = activity;
    }

    @Override
    protected UserRoom doInBackground(String... params) {
        String userEmail = params[0];
        UserRoom user = AppDatabase
                .getInstance(activity)
                .getDao()
                .getUserDataAndImage(userEmail);
        return user;
    }

    @Override
    protected void onPostExecute(UserRoom user) {
        super.onPostExecute(user);
        if (activity != null) {
            activity.getUserDataRoom(user);
        }
    }
}
