package com.springdata.first.model.entity.mapper;

import com.springdata.first.dto.SalaryDto;
import com.springdata.first.dto.SalaryDto.SalaryDtoBuilder;
import com.springdata.first.model.entity.Salary;
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
public class SalaryMapperImpl implements SalaryMapper {

    @Override
    public SalaryDto toCto(Salary salary) {
        if ( salary == null ) {
            return null;
        }

        SalaryDtoBuilder salaryDto = SalaryDto.builder();

        salaryDto.salary_id( salary.getSalary_id() );
        salaryDto.salary_amt( salary.getSalary_amt() );

        return salaryDto.build();
    }

    @Override
    public Salary toentity(SalaryDto salaryDto) {
        if ( salaryDto == null ) {
            return null;
        }

        Salary salary = new Salary();

        salary.setSalary_id( salaryDto.getSalary_id() );
        salary.setSalary_amt( salaryDto.getSalary_amt() );

        return salary;
    }

    @Override
    public List<SalaryDto> toDtos(List<Salary> salaries) {
        if ( salaries == null ) {
            return null;
        }

        List<SalaryDto> list = new ArrayList<SalaryDto>( salaries.size() );
        for ( Salary salary : salaries ) {
            list.add( toCto( salary ) );
        }

        return list;
    }

    @Override
    public List<Salary> toentities(List<SalaryDto> salaryDtos) {
        if ( salaryDtos == null ) {
            return null;
        }

        List<Salary> list = new ArrayList<Salary>( salaryDtos.size() );
        for ( SalaryDto salaryDto : salaryDtos ) {
            list.add( toentity( salaryDto ) );
        }

        return list;
    }
}
