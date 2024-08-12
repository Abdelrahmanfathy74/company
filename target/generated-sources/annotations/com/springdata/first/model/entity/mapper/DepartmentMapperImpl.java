package com.springdata.first.model.entity.mapper;

import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.dto.DepartmentDto.DepartmentDtoBuilder;
import com.springdata.first.model.entity.Department;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T14:42:40+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto todto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDtoBuilder departmentDto = DepartmentDto.builder();

        departmentDto.dept_id( department.getDept_id() );
        departmentDto.deptName( department.getDeptName() );

        return departmentDto.build();
    }

    @Override
    public Department toentity(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setDept_id( departmentDto.getDept_id() );
        department.setDeptName( departmentDto.getDeptName() );

        return department;
    }

    @Override
    public List<Department> toenities(List<DepartmentDto> departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        List<Department> list = new ArrayList<Department>( departmentDto.size() );
        for ( DepartmentDto departmentDto1 : departmentDto ) {
            list.add( toentity( departmentDto1 ) );
        }

        return list;
    }

    @Override
    public List<DepartmentDto> todtos(List<Department> department) {
        if ( department == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( department.size() );
        for ( Department department1 : department ) {
            list.add( todto( department1 ) );
        }

        return list;
    }
}
