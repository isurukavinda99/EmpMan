package com.sys.empman.employee;

import com.sys.empman.common.exception.NotFoundException;
import com.sys.empman.common.loging.LoginUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeEntity viewEmployee(long id){
        return employeeRepository.findById(id).orElseThrow(() ->{
            log.debug("ERR : " + id + " not found");
            return new NotFoundException("Employee not found");
        });
    }


    public List<EmployeeEntity> employeeList(){
        log.debug("invoke employee list");
        return employeeRepository.findAll();
    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        log.debug(LoginUtil.invoke("create employee service with object : " + employeeEntity.toString()));
        EmployeeEntity saved = employeeRepository.save(employeeEntity);
        LoginUtil.exit("create employee : saved object : " + saved.toString());
        return saved;
    }
}
