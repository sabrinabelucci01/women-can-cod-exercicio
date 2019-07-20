package com.womencancode.Projeto.Validator;

import com.womencancode.Projeto.Exception.DuplicatedKeyException;
import com.womencancode.Projeto.Exception.ServiceException;
import com.womencancode.Projeto.Repository.UserRepository;
import com.womencancode.Projeto.model.User;

public class UserValidator extends ModelValidator<User> {

    public UserValidator(UserRepository repository) {
        super(UserRepository);
    }


    public void customInsertValidation(User model) throws ServiceException {
        UserRepository repository = (UserRepository) getrepository();
        if (repository.findByUsername(model.getUsername()).isPresent())
            throw new DuplicatedKeyException(String.format("Username %s already exist", model.getUsername()));
    }
}

