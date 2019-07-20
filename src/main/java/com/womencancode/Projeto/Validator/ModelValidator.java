package com.womencancode.Projeto.Validator;

import com.womencancode.Projeto.Exception.EntityNotFoundException;
import com.womencancode.Projeto.Exception.InvalidFieldException;
import com.womencancode.Projeto.Exception.ServiceException;
import com.womencancode.Projeto.Service.BaseModel;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.StringUtils;

import java.util.List;

@Getter
public abstract class ModelValidator<T extends BaseModel> {

    private CrudRepository repository;

    public ModelValidator(CrudRepository repository) {
        this.repository = repository;
    }
    public void validateInsert(List<T> models) throws ServiceException {
        for (T model : models) {
            validateInsert(model);
        }
    }
    public void validateInsert(T model) throws ServiceException {
        if (StringUtils.hasLength(model.getId()))
            throw new InvalidFieldException("Id is an invalid parameter for the insert action") ;

        customInsertValidation(model);
    }
    public void validateId(String id) throws EntityNotFoundException {
        String className = getClass().getName();
        if (!repository.findById(id).isPresent())
            throw new EntityNotFoundException(String.format("%s %s not found", className, id));
}
