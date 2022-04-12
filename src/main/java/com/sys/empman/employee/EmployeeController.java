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

    @PostMapping("")
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeEntity employeeEntity){

        log.info(LoginUtil.invoke("create employee controller with object : " +  employeeEntity.toString()));

        // this method return true if validation process done other vice it will throw error then no need to use 'if-else'
        this.checkEmployeeValidation(employeeEntity);

        return new ResponseEntity<>(employeeService.createEmployee(employeeEntity) , HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<EmployeeEntity> viewEmployee(@RequestParam long id){
        log.info(LoginUtil.invoke("view employee controller with id : " + id));
        return new ResponseEntity<>(employeeService.viewEmployee(id) , HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<List<EmployeeEntity>> viewEmployeeList(){
        log.info(LoginUtil.invoke("view employee controller list"));
        return new ResponseEntity<>(employeeService.employeeList() , HttpStatus.OK);
    }

    @PutMapping("")
    public EmployeeEntity updateEmpoyee(@RequestBody EmployeeEntity employeeEntity , @RequestParam long id){

        log.info(LoginUtil.invoke("update employee controller with id , object : " + id + " , " + employeeEntity.toString()));

        // this method return true if validation process done other vice it will throw error then no need to use 'if-else'
        this.checkEmployeeValidation(employeeEntity);
        return employeeService.updateEmployee( id , employeeEntity);
    }

    @DeleteMapping("")
    public HttpStatus deleteEmployee(@RequestParam long id){
        log.info(LoginUtil.invoke("delete employee controller with id " + id));
        employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }


    // helper methods
    private boolean checkEmployeeValidation(EmployeeEntity employeeEntity) throws ValidationFaildException{

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

        return true;
    }

}
