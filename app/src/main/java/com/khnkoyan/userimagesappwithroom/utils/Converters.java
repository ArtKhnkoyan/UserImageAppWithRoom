package com.khnkoyan.userimagesappwithroom.utils;

import android.arch.persistence.room.TypeConverter;

import com.khnkoyan.userimagesappwithroom.modelsForRoom.UserRoom;

import static com.khnkoyan.userimagesappwithroom.modelsForRoom.UserRoom.Gender.FEMALE;
import static com.khnkoyan.userimagesappwithroom.modelsForRoom.UserRoom.Gender.MALE;

public class Converters {
    @TypeConverter
    public static UserRoom.Gender toGender(String value) {
        if (value.equals(MALE.getStr())) {
            return MALE;
        } else if (value.equals(FEMALE.getStr())) {
            return FEMALE;
        } else {
              throw new IllegalArgumentException("Could not recognize status");
        }
    }

    @TypeConverter
    public static String toString(UserRoom.Gender status) {
        return status.getStr();
    }

}