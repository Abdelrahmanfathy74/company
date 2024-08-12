package com.springdata.first.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dept_id;
    @Column(name = "dept_name")
    @NotNull
    private String deptName;

//    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)

//   private List<Employee> employee;

}
