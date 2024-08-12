package com.springdata.first.config;

import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.dto.SalaryDto;
import com.springdata.first.model.entity.Department;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.model.entity.Salary;
import com.springdata.first.repository.DeptRepo;
import com.springdata.first.repository.EmpRepo;
import com.springdata.first.repository.SalRepo;
import com.springdata.first.service.DeptService;
import com.springdata.first.service.EmpService;
import com.springdata.first.service.SalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class EmpConfig {
   @Autowired
   private DeptService deptRepo;
   @Autowired
   private SalService salRepo;
    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }
   /* @Bean
    CommandLineRunner commandLineRunner(
            EmpService empRepo){
        return args -> {
            DepartmentDto hrDepartment = this.deptRepo.getByName("HR");
            if(hrDepartment==null) {
                hrDepartment = new DepartmentDto();
                hrDepartment.setDeptName("HR");
                hrDepartment = deptRepo.save(hrDepartment);
            }
            SalaryDto seniorSalary = new SalaryDto();

            seniorSalary.setSalary_amt(90000.5);
            seniorSalary = salRepo.save(seniorSalary);
            EmployeeDto employee1 = new EmployeeDto();
            employee1.setFirstname("John");
            employee1.setLastname("Doe");

            employee1.setDepartment(hrDepartment);
            employee1.setSalary(seniorSalary);
            empRepo.save(employee1);


//               Employee emp= new Employee(
//                    "abdo",
//                    "fathy"
//
//
//            );


//            empRepo.saveAll(
//                    List.of(emp)
//            );
        };
    }*/}

