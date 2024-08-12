package com.springdata.first.repository;

import com.springdata.first.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepo extends JpaRepository<Department,Integer> {
    @Query(value = "select h from Department h where h.deptName = :deptName ")
    Department findByDeptName(@Param("deptName") String deptName);
}
