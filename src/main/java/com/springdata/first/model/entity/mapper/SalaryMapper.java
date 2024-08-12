package com.springdata.first.model.entity.mapper;

import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.dto.SalaryDto;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.model.entity.Salary;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel ="spring")
public interface SalaryMapper {
    SalaryDto toCto(Salary salary);
    Salary toentity(SalaryDto salaryDto);
    List<SalaryDto> toDtos(List<Salary> salaries);
    List<Salary> toentities(List<SalaryDto> salaryDtos);

}
