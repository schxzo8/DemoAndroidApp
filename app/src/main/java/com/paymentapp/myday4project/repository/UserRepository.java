package com.paymentapp.myday4project.repository;

import android.content.Context;

import com.paymentapp.myday4project.data.AppDatabase;
import com.paymentapp.myday4project.data.UserDao;
import com.paymentapp.myday4project.model.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertUser(User user) {
        userDao.insert(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();   // pass-through
    }
}
