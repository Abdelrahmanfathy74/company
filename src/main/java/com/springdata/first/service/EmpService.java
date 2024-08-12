package com.springdata.first.service;

import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.model.entity.mapper.EmployeeMapper;
import com.springdata.first.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmployeeMapper employeeMapper;
 @Autowired
private EmpRepo empRepo;
 public List<EmployeeDto> findBySalary(Double salary){
     List<Employee> employees = empRepo.findBySalaryAmtGreaterThan(salary);
     return employeeMapper.toDTOs(employees);
 }
 public List<EmployeeDto> findByDepartment(String dept){
     return employeeMapper.toDTOs(empRepo.findByDepartment_Name(dept));
 }
     public EmployeeDto getuser(Integer id){
         Optional<Employee> emp=empRepo.findById(id);

         return employeeMapper.toDTO(emp.orElseThrow(()->new RuntimeException("id not found")));
     }
     public EmployeeDto save(EmployeeDto employee){
             return employeeMapper.toDTO(empRepo.save(employeeMapper.toEntity(employee)));
     }
     public EmployeeDto saveemp(EmployeeDto dto){
         return employeeMapper.toDTO(empRepo.save(employeeMapper.toEntity(dto)));
     }
     public List<EmployeeDto> getall(){
         return employeeMapper.toDTOs(empRepo.findAll());
     }

     public void delete(Integer id){
       EmployeeDto employeeDto=employeeMapper.toDTO(empRepo.findById(id).get());
       empRepo.deleteById(employeeDto.getId());

     }
}
