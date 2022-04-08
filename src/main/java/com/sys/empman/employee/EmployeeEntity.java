package com.sys.empman.employee;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "tbl_employee")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(length = 9 , unique = true)
    private String nic;
    @Column(unique = true)
    private String email;
    @Column(length = 10)
    private String phoneNumber;

}
