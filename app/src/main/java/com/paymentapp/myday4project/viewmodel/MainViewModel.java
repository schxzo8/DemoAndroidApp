package com.paymentapp.myday4project.viewmodel;

import android.content.Context;

import com.paymentapp.myday4project.domain.ValidateNameUseCase;
import com.paymentapp.myday4project.model.User;
import com.paymentapp.myday4project.repository.UserRepository;

public class MainViewModel {

    private ValidateNameUseCase validateNameUseCase;
    private UserRepository userRepository;

    public MainViewModel(Context context) {
        this.validateNameUseCase = new ValidateNameUseCase();
        this.userRepository = new UserRepository(context);
    }

    public String getFirstNameError(String firstName) {
        return validateNameUseCase.validateFirstName(firstName);
    }

    public String getLastNameError(String lastName) {
        return validateNameUseCase.validateLastName(lastName);
    }

    public boolean isValid(String firstName, String lastName) {
        return getFirstNameError(firstName) == null && getLastNameError(lastName) == null;
    }

    public void saveUser(String firstName, String lastName) {
        userRepository.insert(new User(firstName, lastName));
    }
}
