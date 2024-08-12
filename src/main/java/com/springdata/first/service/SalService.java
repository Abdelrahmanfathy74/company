package com.springdata.first.service;

import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.dto.SalaryDto;
import com.springdata.first.model.entity.Salary;
import com.springdata.first.model.entity.mapper.SalaryMapper;
import com.springdata.first.repository.SalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalService {
    @Autowired
   private SalRepo salRepo;
    @Autowired
   private SalaryMapper salaryMapper;
    public List<SalaryDto> getall(){
        return salaryMapper.toDtos(salRepo.findAll());
    }
    public SalaryDto getbyid(Integer id){
        Optional<Salary> sal=salRepo.findById(id);
        return salaryMapper.toCto( sal.orElseThrow(()->new RuntimeException("id salary not found")));
    }
    public SalaryDto save(SalaryDto salaryDto){
        return salaryMapper.toCto(salRepo.save(salaryMapper.toentity(salaryDto)));
    }
    public SalaryDto savesal(SalaryDto salaryDto){
        return salaryMapper.toCto(salRepo.save(salaryMapper.toentity(salaryDto)));
    }
    public void delete(Integer id){
        SalaryDto salaryDto=salaryMapper.toCto(salRepo.findById(id).get());
        salRepo.deleteById(salaryDto.getSalary_id());
    }
}
