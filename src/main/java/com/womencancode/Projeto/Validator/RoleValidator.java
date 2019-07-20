package com.womencancode.Projeto.Validator;

import com.womencancode.Projeto.Exception.ServiceException;
import com.womencancode.Projeto.Repository.RoleRepository;
import com.womencancode.Projeto.model.Role;

public class RoleValidator extends ModelValidator<Role> {
    public RoleValidator(RoleRepository repository) {
        super(repository);
    }


    public void customInsertValidation(Role model) throws ServiceException {
        // Do nothing
    }
}
