package com.example.demo.service;

import com.example.demo.convertor.EmployeeConvertor;
import com.example.demo.domain.Employee;
import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeConvertor employeeConvertor;

    public List<EmployeeDTO> getEmployeeByName (String name){
        if(ObjectUtils.isEmpty(name)){
            return null;
        }
        List<Employee> e = employeeRepository.findByNameLike(name);
        if(ObjectUtils.isEmpty(e)){
            return null;
        }
        List<EmployeeDTO> empList = new ArrayList<>();
        // for (auto i : arr)
        for(Employee employee : e){
            //EmployeeDTO dto = employeeConvertor.convert(employee);
            //empList.add(dto);
            empList.add(employeeConvertor.convert(employee));
        }
        return empList;
    }

    public boolean createEmployee(EmployeeDTO employeeDTO) {
        Employee e = employeeConvertor.convert(employeeDTO);
        employeeRepository.save(e);
        return true;
    }

    public EmployeeDTO getEmployeeByEmpCode(String empCode) {
        if(ObjectUtils.isEmpty(empCode)) return null;
        Employee e = employeeRepository.findByEmpCode(empCode);
        if(ObjectUtils.isEmpty(e)) return null;
        return employeeConvertor.convert(e);
    }

    public String getNameByMobile(String mobile) {
        if(ObjectUtils.isEmpty(mobile)) return null;
        return employeeRepository.findNameByMobile(mobile);
    }
}
