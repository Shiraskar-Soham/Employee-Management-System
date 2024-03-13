package com.example.demo.repository;

import com.example.demo.domain.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "select * from employee where name like %?1%", nativeQuery = true)
    List<Employee> findByNameLike(String name);

    Employee findByEmpCode(String empCode);

    @Query(value = "select name from employee where mobile = ?1", nativeQuery = true)
    String findNameByMobile(String mobile);
    @Query(value = "select * from employee where age >= ?1", nativeQuery = true)
    List<Employee> findByAgeGreaterThan(int age);
}
