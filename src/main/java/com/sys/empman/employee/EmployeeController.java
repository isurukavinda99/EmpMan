package com.sys.empman.employee;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    @PostMapping("/")
    public void createEmployee(@RequestBody EmployeeEntity employeeEntity){

    }

    @GetMapping("/")
    public ResponseEntity viewEmployee(@RequestParam long id){
        log.info("view employee");
        return new ResponseEntity(employeeService.viewEmployee(id) , HttpStatus.OK);
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
