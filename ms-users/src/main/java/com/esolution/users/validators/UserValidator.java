package com.esolution.users.validators;

import com.esolution.users.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {
    public void deletionValidator(boolean userExists) throws NotFoundException {
        if(!userExists) {
            throw new NotFoundException("user");
        }
    }
}
