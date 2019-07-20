package com.womencancode.Projeto.model;

import com.womencancode.Projeto.Service.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Role extends BaseModel {
    @Id
    private String id;
    @NonNull
    private String name;

}
