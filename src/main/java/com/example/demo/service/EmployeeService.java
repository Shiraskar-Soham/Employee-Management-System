package com.example.demo.service;

import com.example.demo.convertor.EmployeeConvertor;
import com.example.demo.domain.Employee;
import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service

public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeConvertor employeeConvertor;

    public EmployeeDTO getEmployeeByName (String name){
        if(ObjectUtils.isEmpty(name)){
            return null;
        }
        Employee e = employeeRepository.findByNameLike(name);
        if(ObjectUtils.isEmpty(e)){
            return null;
        }
        return employeeConvertor.convert(e);
    }
}
