package com.khnkoyan.userimagesappwithroom.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import com.khnkoyan.userimagesappwithroom.modelsForRoom.ImageRoom;
import com.khnkoyan.userimagesappwithroom.modelsForRoom.UserRoom;

import java.util.List;

@Dao
public interface UserOrImageDAO {

    @Insert
    void insertUser(UserRoom user);

   @Query("UPDATE user SET name= :name ,surname= :surName,age= :age,gender= :gender "
           + "WHERE email= :email")
    void updateUser(String name, String surName, int age, UserRoom.Gender gender, String email);

    @Query("DELETE FROM user WHERE user.email LIKE :email")
    void deleteUser(String email);

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT user.name, user.surname, user.email, user.password, user.age,user.gender, image.blob FROM user "
            + "LEFT JOIN image ON user.id = image.user_id "
            + "WHERE user.email LIKE :email")
    UserRoom getUserDataAndImage(String email);


    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT user.name, user.surname, user.email, user.password, user.age, user.gender FROM user "
            + "WHERE user.email LIKE :email")
    UserRoom getUserData(String email);


    @Query("SELECT COUNT(*) FROM user " + "WHERE user.email LIKE :email")
    boolean checkUser(String email);

    @Query("SELECT COUNT(*) FROM user " + "WHERE user.email LIKE :email AND user.password LIKE :password")
    boolean checkUser(String email, String password);

    @Query("SELECT COUNT(*) FROM user " + "WHERE user.userLoggedIn > 0")
    public boolean isLoggedIn();

    @Query("UPDATE user SET userLoggedIn= :isLoggedIn WHERE email LIKE :email")
    void setLogin(boolean isLoggedIn, String email);

    @Query("SELECT user.email FROM user WHERE user.userLoggedIn > 0")
    String selectLoginedUser();

    @Query("SELECT user.id FROM user WHERE user.email LIKE :email")
    int selectUserId(String email);

    @Insert
    void insertImage(ImageRoom imageRoom);

    @Query("SELECT image.id, image.blob FROM image WHERE user_id=:userId")
    List<ImageRoom> findImagesForUser(int userId);

    @Query("DELETE FROM image WHERE id LIKE :id")
    void deleteItemImage(int id);

    @Query("DELETE FROM image WHERE user_id LIKE :userId")
    void deleteUserAllImages(int userId);
}
