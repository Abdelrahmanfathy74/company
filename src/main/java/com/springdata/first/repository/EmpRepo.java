package com.springdata.first.repository;

import com.springdata.first.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
    @Query("SELECT e " +
            "FROM Employee e " +
            "JOIN e.department d " +
            "JOIN e.salary s " +
            "WHERE s.salary_amt > :minSalary")
    List<Employee> findBySalaryAmtGreaterThan(@Param("minSalary") Double minSalary);
  @Query("SELECT e "+
          "FROM Employee e " +
          "JOIN e.department d " +
          "WHERE d.deptName = :deptName"
  )
    List<Employee> findByDepartment_Name(@Param("deptName") String deptName);


}
