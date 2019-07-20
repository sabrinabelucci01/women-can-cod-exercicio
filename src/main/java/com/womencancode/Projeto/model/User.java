package com.womencancode.Projeto.model;

import com.womencancode.Projeto.Service.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document
@Data
@Builder
@Wither
public class User extends BaseModel {
    @Id
    private String id;
    private String name;
    private String lastName;
    @NonNull
    private String email;
    private Date birthDate;

    @DBRef
    private Role role;


}
