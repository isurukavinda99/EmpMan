package com.sys.empman.employee;

import com.sys.empman.common.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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


    public void employeeList(){

    }

}
