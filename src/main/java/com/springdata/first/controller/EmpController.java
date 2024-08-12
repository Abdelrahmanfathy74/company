package com.springdata.first.controller;

import com.springdata.first.customeKeyGenerator.CustomeKeyGenerator;
import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.model.entity.mapper.EmployeeMapper;
import com.springdata.first.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
    //@CacheConfig(cacheNames = "employee")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CustomeKeyGenerator customeKeyGenerator;


    @GetMapping("/salary/{amount}")
    public List<EmployeeDto> getEmployeesWithSalaryGreaterThan(@PathVariable("amount") Double amount){
        return empService.findBySalary(amount);
    }
  @GetMapping("/department/{name}")
    public List<EmployeeDto> getEmployeesByDepartmentName(@PathVariable("name") String name) {
        return empService.findByDepartment(name);
    }

    @GetMapping("/get{id}")
   // @Cacheable(value = "employee", key = "#id",unless = "#result.salary <10000")
    public EmployeeDto getusetbyid(@PathVariable Integer id){
        EmployeeDto result=empService.getuser(id);
        return result;
    }
    @GetMapping("/get_allemp")
    //@Cacheable(value = "employee",keyGenerator = "customeKeyGenerator")
    public List<EmployeeDto>    getalluser(){
        return empService.getall();
    }

    @PostMapping("/save_emp")
    //@CacheEvict(cacheNames = "employee", allEntries = true)
    public EmployeeDto save(@RequestBody EmployeeDto employee){
        return empService.save(employee);
    }
    @PutMapping("/update_emp")
    //@CachePut(cacheNames = "employee")

    public EmployeeDto update(@RequestBody EmployeeDto dto){
        //convert to entity
        //save
        //return to dto
        return empService.saveemp(dto);
    }

    @DeleteMapping("/delete{id}")
    //@CacheEvict(cacheNames = "employee", key = "#id", allEntries = true)
    public void deleteusetbyid(@PathVariable Integer id){
         empService.delete(id);
    }
}
