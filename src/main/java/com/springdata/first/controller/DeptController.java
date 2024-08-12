package com.springdata.first.controller;

import com.springdata.first.customeKeyGenerator.CustomeKeyGenerator;
import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
@CacheConfig(cacheNames = "department")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private CustomeKeyGenerator customeKeyGenerator;
    @GetMapping("/{name}")
   // @Cacheable(value = "department")
    public DepartmentDto getByName(@PathVariable String name){
        return deptService.getByName(name);
    }
    @GetMapping("/findbyId/{id}")
    @Cacheable(value="department",key = "#id")
    public DepartmentDto getbyid(Integer id){
        return deptService.getbyid(id);
    }

    @GetMapping("/alldept")
    @Cacheable(value = "department",keyGenerator = "customeKeyGenerator")
    public List<DepartmentDto> getalldept(){

        return deptService.getall();
    }
    @PostMapping("/add")
    @CacheEvict(cacheNames = "department",allEntries = true)
    public  DepartmentDto add(@RequestBody DepartmentDto departmentDto){
        return deptService.save(departmentDto);
    }
    @PutMapping("/update")
    @CachePut(cacheNames = "department")
    public DepartmentDto update(@RequestBody DepartmentDto departmentDto){
        return deptService.savedept(departmentDto);
    }
    @DeleteMapping("/delete{id}")
    @CacheEvict(cacheNames = "department",key = "#id",allEntries = true)
    public void delete(@PathVariable Integer id){
         deptService.delete(id);
    }

}