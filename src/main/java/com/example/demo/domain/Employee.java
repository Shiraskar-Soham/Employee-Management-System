package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue (generator="uuid-hibernate-generator")
    @GenericGenerator(name="uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name= "id")
    private String id;
    @Column(name= "name")
    private String name;
    @Column(name= "age")
    private Integer age;
    @Column(name= "mobile")
    private String mobile;
    @Column(name= "email")
    private String email;
    @Column(name= "code")
    private String empCode;
    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @Column(name="modification_date")
    private Date modificationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
