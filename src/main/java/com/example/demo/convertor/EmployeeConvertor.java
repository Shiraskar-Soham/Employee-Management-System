package com.example.demo.convertor;

import com.example.demo.domain.Employee;
import com.example.demo.dtos.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component

public class EmployeeConvertor {
    public EmployeeDTO convert(Employee e){
        EmployeeDTO dto = EmployeeDTO.builder()
                .name(e.getName())
                .age(e.getAge())
                .mobile(e.getMobile())
                .email(e.getEmail())
                .empCode(e.getEmpCode())
                .build();
        return dto;
    }
    public Employee convert(EmployeeDTO dto){
        Employee e = Employee.builder()
                .id(null)
                .name(dto.getName())
                .age(dto.getAge())
                .mobile(dto.getMobile())
                .email(dto.getEmail())
                .empCode(dto.getEmpCode())
                .modificationDate(null)
                .build();
        return e;
    }
}
