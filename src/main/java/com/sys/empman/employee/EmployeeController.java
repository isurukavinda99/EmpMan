package com.sys.empman.employee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @PostMapping("/")
    public void createEmployee(@RequestBody EmployeeEntity employeeEntity){

    }

    @GetMapping("/")
    public void viewEmployee(@RequestParam long id){

    }


    @GetMapping("/list")
    public void viewEmployeeList(){

    }

    @PutMapping("/update")
    public void updateEmpoyee(@RequestBody EmployeeEntity employeeEntity , @RequestParam long id){

    }

    @DeleteMapping("/")
    public void deleteEmployee(@RequestBody long id){

    }

}
