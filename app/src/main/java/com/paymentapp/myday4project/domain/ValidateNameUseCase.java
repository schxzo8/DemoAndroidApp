package com.paymentapp.myday4project.domain;

public class ValidateNameUseCase {

    public String validateFirstName(String name) {
        if (name.isEmpty()) {
            return "Please enter your first name";
        } else if (!name.matches("[a-zA-Z]+")) {
            return "First name should contain only letters";
        }
        return null; // no error
    }

    public String validateLastName(String name) {
        if (name.isEmpty()) {
            return "Please enter your last name";
        } else if (!name.matches("[a-zA-Z]+")) {
            return "Last name should contain only letters";
        }
        return null; // no error
    }
}
