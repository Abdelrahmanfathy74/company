package com.springdata.first.model.entity.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.model.entity.Department;
import com.springdata.first.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public interface EmployeeMapper {
    //  DepartmentMapper dmapper = Mappers.getMapper(DepartmentMapper.class);
    Employee toEntity(EmployeeDto dto);

  //  @Mapping(target = "department",qualifiedByName = "removeId")
    EmployeeDto toDTO(Employee entity);

    List<EmployeeDto> toDTOs(List<Employee> entity);
    List<Employee> toentity(List<EmployeeDto> entity);

//    @Named("removeId")
//    default DepartmentDto removeId(Department department){
//        department.setDept_id(null);
//        return dmapper.todto(department);
//    }
}
