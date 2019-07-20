package com.womencancode.Projeto.Controller;

import com.womencancode.Projeto.Service.UserService;
import com.womencancode.Projeto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

   @Autowired
   private UserService service;

   public User insertService(User insertService) {
      return null;
   }

   @PostMapping
   public ResponseEntity<User> insertUser(@RequestBody User user) throws Exception {
      return ResponseEntity.ok(service.insertUser(user));
   }

   @PutMapping("/{id}")
   public ResponseEntity<User> updateUser(RequestBody User, user, @PathVariable String id) throws Exception {
      user.setId(id);
      return ResponseEntity.ok(service.updateUser(user));
   }

   @GetMapping
   public ResponseEntity<Stream<User>> getAll(@SortDefault.SortDefaults(
           {@SortDefault(sort = "name", direction = Sort.Direction.ASC)}) Pageable pageable) {
      return ResponseEntity.ok(service.findAll(pageable).get());
   }

   @GetMapping("/{id}")
   public ResponseEntity<User> getById(@PathVariable String id) throws Exception {
      return ResponseEntity.ok(service.findById(id));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable String id) throws Exception {
      service.delete(id);
      return ResponseEntity.noContent().build();
   }
}

