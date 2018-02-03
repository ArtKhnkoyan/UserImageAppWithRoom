package com.khnkoyan.userimagesappwithroom.modelsForRoom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.khnkoyan.userimagesappwithroom.utils.Converters;

@Entity(tableName = "user", indices = {@Index(value = {"email"},
        unique = true)})
public class UserRoom {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "surname")
    private String surName;
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "gender")
    private Gender gender;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "age")
    private int age;
    @ColumnInfo(name = "userLoggedIn")
    private boolean userLoggedIn = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }


    public enum Gender {
        MALE("MALE"), FEMALE("FEMALE");
        private String str;

        Gender(String s) {
            this.str = s;
        }

        public String getStr() {
            return str;
        }
    }
}
