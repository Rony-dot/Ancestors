package com.ancestors.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Size(min = 2, message = "min 2 chars needed")
    private String street;

    @Size(min = 2, message = "min 2 chars needed")
    private String city;

    @Size(min = 2, message = "min 2 chars needed")
    private String state;

    @Column(unique = true)
    @Size(min = 2, message = "min 2 digits needed")
    private String zip;
}
