package com.springdata.first.service;

import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.model.entity.Department;
import com.springdata.first.model.entity.mapper.DepartmentMapper;
import com.springdata.first.repository.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptService {
    @Autowired
   private DeptRepo deptRepo;
    @Autowired
    private DepartmentMapper departmentMapper;
    public DepartmentDto getByName(String name){
        return departmentMapper.todto(deptRepo.findByDeptName(name));
    }
    public List<DepartmentDto> getall(){
        return departmentMapper.todtos(deptRepo.findAll());
    }
    public DepartmentDto getbyid(Integer id){
       Optional<Department> dept= deptRepo.findById(id);
       return departmentMapper.todto(dept.orElseThrow(()->new RuntimeException("id of dept not found")));
    }
    public DepartmentDto save(DepartmentDto department){
        if(this.deptRepo.findByDeptName(department.getDeptName())==null)
        return departmentMapper.todto(deptRepo.save(departmentMapper.toentity(department)));
    else
        throw new RuntimeException("Department Name Already Exist");
    }
    public DepartmentDto savedept(DepartmentDto departmentDto){
        return departmentMapper.todto(deptRepo.save(departmentMapper.toentity(departmentDto)));

    }
    public void delete(Integer id){
        DepartmentDto departmentDto=departmentMapper.todto(deptRepo.findById(id).get());
        deptRepo.deleteById(departmentDto.getDept_id());
    }
}
