package com.springdata.first.repository;

import com.springdata.first.model.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalRepo extends JpaRepository<Salary,Integer> {
}
