package com.springdata.first.controller;

import com.springdata.first.dto.SalaryDto;
import com.springdata.first.service.SalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sal")
public class SalaryController {
    @Autowired
    public SalService salService;
    @GetMapping("/all_sal")
    public List<SalaryDto> getallsal(){
        return  salService.getall();
    }
    @GetMapping("/{id}")
    public SalaryDto getsalbyid(@PathVariable Integer id){
        return salService.getbyid(id);
    }
    @PostMapping("/save")
    public SalaryDto postsal(@RequestBody SalaryDto salaryDto){
        return salService.save(salaryDto);
    }
    @PutMapping("/update")
    public SalaryDto update(@RequestBody SalaryDto salaryDto){
        return salService.savesal(salaryDto);
    }
    @DeleteMapping("/delete{id}")
    public void deletesal(@PathVariable Integer id){
         salService.delete(id);
    }
}
