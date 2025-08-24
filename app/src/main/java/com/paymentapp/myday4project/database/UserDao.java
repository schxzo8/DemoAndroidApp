package com.paymentapp.myday4project.database;

import androidx.room.*;
import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE id = :userId")
    User getUserById(int userId);

    @Delete
    void deleteUser(User user);
}