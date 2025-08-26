package com.paymentapp.myday4project.viewmodel;

import com.paymentapp.myday4project.domain.ValidateNameUseCase;

public class MainViewModel {

    private final ValidateNameUseCase validateNameUseCase;

    public MainViewModel() {
        this.validateNameUseCase = new ValidateNameUseCase();
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
}
