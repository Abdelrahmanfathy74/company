package com.springdata.first.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "Salary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salary_id;
    @Column
    @NotNull
    private Double salary_amt;
//    @OneToOne
//    @JoinColumn(name = "emp_id")
//    private Employee employee;
}
