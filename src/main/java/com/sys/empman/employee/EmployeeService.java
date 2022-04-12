package com.sys.empman.employee;

import com.sys.empman.common.exception.NotFoundException;
import com.sys.empman.common.loging.LoginUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeEntity viewEmployee(long id) {
        log.debug("invoke view employee");
        return employeeRepository.findById(id).orElseThrow(() -> {
            log.debug("ERR : " + id + " not found");
            return new NotFoundException("Employee not found");
        });
    }


    public List<EmployeeEntity> employeeList() {
        log.debug("invoke employee list");
        return employeeRepository.findAll();
    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        log.debug(LoginUtil.invoke("create employee service with object : " + employeeEntity.toString()));
        EmployeeEntity saved = employeeRepository.save(employeeEntity);
        log.debug(LoginUtil.exit("create employee : saved object : " + saved.toString()));
        return saved;
    }

    public EmployeeEntity updateEmployee(long id, EmployeeEntity employeeEntity) {
        log.debug(LoginUtil.invoke("update employee service with id , object : " + id + employeeEntity.toString()));

        //check user is exist
        EmployeeEntity updateToBe = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found along with id : " + id));

        updateToBe.setFirstName(employeeEntity.getFirstName());
        updateToBe.setLastName(employeeEntity.getLastName());
        updateToBe.setNic(employeeEntity.getNic());
        updateToBe.setEmail(employeeEntity.getEmail());
        updateToBe.setPhoneNumber(employeeEntity.getPhoneNumber());

        updateToBe = employeeRepository.save(updateToBe);
        log.debug(LoginUtil.exit("create employee : saved object : " + updateToBe.toString()));

        return updateToBe;
    }
}
