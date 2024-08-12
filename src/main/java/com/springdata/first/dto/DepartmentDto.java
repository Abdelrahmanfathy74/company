package com.springdata.first.dto;

import com.springdata.first.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto implements Serializable {
    private Integer dept_id;
    @NotNull
    private String deptName;


}
