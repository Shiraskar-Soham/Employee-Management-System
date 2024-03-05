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
}
