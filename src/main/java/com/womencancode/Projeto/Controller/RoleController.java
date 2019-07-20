package com.womencancode.Projeto.Controller;

import com.womencancode.Projeto.Service.RoleService;
import com.womencancode.Projeto.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/role", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {

    private RoleService service;

    public RoleController(@Autowired RoleService Service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Role> insertRole(@RequestBody Role role) throws Exception {
        return ResponseEntity.ok(service.insertRole(role));
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }
}
