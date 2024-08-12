package com.springdata.first.model.entity;

import com.springdata.first.base.BaseEntity;
import com.springdata.first.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;

//,insertable = false,updatable = false
    @ManyToOne
    @JoinColumn(name = "dept_id",updatable = false)
   private Department department;
    @OneToOne
    @JoinColumn(name = "salary_id",updatable = false)
    private Salary salary;


    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        //this.salary = salary;
    }



}
