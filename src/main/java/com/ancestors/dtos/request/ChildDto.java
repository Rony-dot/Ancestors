package com.ancestors.dtos.request;

import lombok.Data;

@Data
public class ChildDto {
    private String id;
    private String firstName;
    private String lastName;
    private long fathersId;
    private long mothersId;
}
