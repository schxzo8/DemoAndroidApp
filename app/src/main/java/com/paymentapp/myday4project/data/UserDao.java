package com.paymentapp.myday4project.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.paymentapp.myday4project.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM user_table")
    List<User> getAllUsers();
}
