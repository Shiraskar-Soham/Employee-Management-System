package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/findByName")
    public List<EmployeeDTO> getEmployeeByName(@RequestParam("name") String name){

        return employeeService.getEmployeeByName(name);
    }

    @PostMapping("/create")
    public boolean createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/findByEmpCode")
    public EmployeeDTO getEmployeeByEmpCode(@RequestParam("empCode") String empCode){
        return employeeService.getEmployeeByEmpCode(empCode);
    }

    @GetMapping("/nameByMobile")
    public String getNameByMobile (@RequestParam("mobile") String mobile){
        return employeeService.getNameByMobile(mobile);
    }

    @GetMapping ("/findByAge")
    public List<EmployeeDTO> getEmployeeByAge(@RequestParam("age") int age){
        return employeeService.getEmployeeByAge(age);
    }
}
