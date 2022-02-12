package com.ancestors.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_child")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Parent father;

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Parent mother;
}
