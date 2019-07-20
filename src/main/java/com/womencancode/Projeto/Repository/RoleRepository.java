package com.womencancode.Projeto.Repository;

import com.womencancode.Projeto.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {
    Optional<Role>findByNameIgnoreCase(String name);
}
