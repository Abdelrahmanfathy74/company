package com.springdata.first.model.entity.mapper;

import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.model.entity.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentDto todto(Department department);
    Department toentity(DepartmentDto departmentDto);
    List<Department> toenities (List<DepartmentDto> departmentDto);
    List<DepartmentDto> todtos(List<Department> department);
}
