package com.womencancode.Projeto.Validator;

import com.womencancode.Projeto.Repository.RoleRepository;
import com.womencancode.Projeto.Repository.UserRepository;
import com.womencancode.Projeto.Service.BaseModel;
import com.womencancode.Projeto.model.Role;
import com.womencancode.Projeto.model.User;
import org.springframework.data.repository.CrudRepository;

public class ValidatorFactory {
    public static <T extends BaseModel> ModelValidator getValidator(Class<T> clazz, CrudRepository repository) {
        if (User.class.equals(clazz))
            return new UserValidator((UserRepository) repository);

        if (Role.class.equals(clazz))
            return new RoleValidator((RoleRepository) repository);

        return null;
    }
}
