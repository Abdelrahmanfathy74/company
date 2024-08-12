package com.springdata.first.model.entity.mapper;

import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.dto.DepartmentDto.DepartmentDtoBuilder;
import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.dto.EmployeeDto.EmployeeDtoBuilder;
import com.springdata.first.dto.SalaryDto;
import com.springdata.first.dto.SalaryDto.SalaryDtoBuilder;
import com.springdata.first.model.entity.Department;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.model.entity.Employee.EmployeeBuilder;
import com.springdata.first.model.entity.Salary;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T21:03:20+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.id( dto.getId() );
        employee.firstname( dto.getFirstname() );
        employee.lastname( dto.getLastname() );
        employee.department( departmentDtoToDepartment( dto.getDepartment() ) );
        employee.salary( salaryDtoToSalary( dto.getSalary() ) );

        return employee.build();
    }

    @Override
    public EmployeeDto toDTO(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        employeeDto.id( entity.getId() );
        employeeDto.firstname( entity.getFirstname() );
        employeeDto.lastname( entity.getLastname() );
        employeeDto.department( departmentToDepartmentDto( entity.getDepartment() ) );
        employeeDto.salary( salaryToSalaryDto( entity.getSalary() ) );

        return employeeDto.build();
    }

    @Override
    public List<EmployeeDto> toDTOs(List<Employee> entity) {
        if ( entity == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( entity.size() );
        for ( Employee employee : entity ) {
            list.add( toDTO( employee ) );
        }

        return list;
    }

    @Override
    public List<Employee> toentity(List<EmployeeDto> entity) {
        if ( entity == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( entity.size() );
        for ( EmployeeDto employeeDto : entity ) {
            list.add( toEntity( employeeDto ) );
        }

        return list;
    }

    protected Department departmentDtoToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setDept_id( departmentDto.getDept_id() );
        department.setDeptName( departmentDto.getDeptName() );

        return department;
    }

    protected Salary salaryDtoToSalary(SalaryDto salaryDto) {
        if ( salaryDto == null ) {
            return null;
        }

        Salary salary = new Salary();

        salary.setSalary_id( salaryDto.getSalary_id() );
        salary.setSalary_amt( salaryDto.getSalary_amt() );

        return salary;
    }

    protected DepartmentDto departmentToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDtoBuilder departmentDto = DepartmentDto.builder();

        departmentDto.dept_id( department.getDept_id() );
        departmentDto.deptName( department.getDeptName() );

        return departmentDto.build();
    }

    protected SalaryDto salaryToSalaryDto(Salary salary) {
        if ( salary == null ) {
            return null;
        }

        SalaryDtoBuilder salaryDto = SalaryDto.builder();

        salaryDto.salary_id( salary.getSalary_id() );
        salaryDto.salary_amt( salary.getSalary_amt() );

        return salaryDto.build();
    }
}
