package com.paymentapp.myday4project.repository;

import android.content.Context;

import com.paymentapp.myday4project.data.AppDatabase;
import com.paymentapp.myday4project.data.UserDao;
import com.paymentapp.myday4project.model.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        userDao = db.userDao();
    }

    public void insert(User user) {
        userDao.insert(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
