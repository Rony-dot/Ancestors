package com.ancestors.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionModel {
    private String message;
    private String description;
    private LocalDateTime localDateTime;
}
