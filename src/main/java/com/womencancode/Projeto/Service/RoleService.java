package com.womencancode.Projeto.Service;

import com.womencancode.Projeto.Exception.EntityNotFoundException;
import com.womencancode.Projeto.Exception.ServiceException;
import com.womencancode.Projeto.Repository.RoleRepository;
import com.womencancode.Projeto.Validator.ModelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;

import javax.validation.ValidatorFactory;
import java.util.List;

@Service
public class RoleService {
    private RoleRepository repository;
    private ModelValidator validator;

    public RoleService(@Autowired RoleRepository Repository) {
        this.repository = repository;
        this.validator = ValidatorFactory.getValidator(Role.class, repository);
    }

    public Role insertRole(Role role) throws Exception {
        validator.validateInsert(Role);
        return repository.insert(role);
    }

    public List<Role> findAll() {
        return RoleRepository.findAll();
    }

    public Role findById(String id) throws ServiceException {
        return repository.findById(id).orElseThrow(() -> {
            String message = String.format("Role %s not found.", id);
            return new EntityNotFoundException(message);
        });
    }
}
