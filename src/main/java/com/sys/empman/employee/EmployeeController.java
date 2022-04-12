package com.sys.empman.employee;

import com.sys.empman.common.exception.ValidationFaildException;
import com.sys.empman.common.loging.LoginUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeEntity employeeEntity){

        log.info(LoginUtil.invoke("create employee controller with object : " +  employeeEntity.toString()));

        //validations
        if(employeeEntity.getFirstName().isEmpty()){
            throw new ValidationFaildException("give proper first name");
        }

        if(employeeEntity.getLastName().isEmpty()){
            throw new ValidationFaildException("give proper last name");
        }

        if(employeeEntity.getNic().isEmpty()){
            throw new ValidationFaildException("nic is important");
        }

        if(employeeEntity.getNic().length() >= 9 && employeeEntity.getNic().length() <= 12){
            throw new ValidationFaildException("nic must have correct length");
        }

        if(employeeEntity.getEmail().isEmpty()){
            throw new ValidationFaildException("email is important");
        }

        if(employeeEntity.getEmail().contains("@")){
            throw new ValidationFaildException("enter valid email");
        }

        if(employeeEntity.getPhoneNumber().isEmpty()){
            throw new ValidationFaildException("phone number is important");
        }

        if(employeeEntity.getPhoneNumber().length() == 10){
            throw new ValidationFaildException("give proper length to phone number");
        }

        return new ResponseEntity<>(employeeService.createEmployee(employeeEntity) , HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity viewEmployee(@RequestParam long id){
        log.info(LoginUtil.invoke("view employee controller with id : " + id));
        return new ResponseEntity(employeeService.viewEmployee(id) , HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<List<EmployeeEntity>> viewEmployeeList(){
        log.info(LoginUtil.invoke("view employee controller list"));
        return new ResponseEntity<>(employeeService.employeeList() , HttpStatus.OK);
    }

    @PutMapping("/update")
    public void updateEmpoyee(@RequestBody EmployeeEntity employeeEntity , @RequestParam long id){

    }

    @DeleteMapping("/")
    public void deleteEmployee(@RequestBody long id){

    }

}
