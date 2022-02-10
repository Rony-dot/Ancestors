package com.ancestors.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_child")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Parent father;

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Parent mother;
}
