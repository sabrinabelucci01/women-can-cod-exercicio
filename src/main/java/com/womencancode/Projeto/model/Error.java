package com.womencancode.Projeto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class Error {
    private int status;
    private String message;
}