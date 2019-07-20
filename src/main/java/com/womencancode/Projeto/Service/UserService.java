package com.womencancode.Projeto.Service;

import com.womencancode.Projeto.Exception.EntityNotFoundException;
import com.womencancode.Projeto.Exception.ServiceException;
import com.womencancode.Projeto.Repository.UserRepository;
import com.womencancode.Projeto.Validator.ModelValidator;
import com.womencancode.Projeto.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import javax.validation.ValidatorFactory;
import java.awt.print.Pageable;

@Service
@Slf4j

public class UserService {

    @Autowired
    private UserRepository repository;
    private ModelValidator Validator;

    public UserService(@Autowired UserRepository repository){
        this.repository = repository;
        this.validator = ValidatorFactory.getValidator(User.class, repository);
    }
    public User insertUser(User user) throws ServiceException {
        validator.validateInsert(user);
        return repository.insert(user);
    }
    public User updateUser(User user) throws ServiceException {
        validator.validateId(user.getId());
        return repository.save(user);
    }
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public User findById(String id) throws ServiceException {
        String message = String.format("User %s not found", id);
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(message));
    }

    public void delete(String id) throws ServiceException {
        validator.validateId(id);
        repository.deleteById(id);
    }
}
