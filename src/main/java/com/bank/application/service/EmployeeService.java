package com.bank.application.service;

import com.bank.application.constant.ErrorMessages;
import com.bank.application.exception.NotFoundIdException;
import com.bank.application.model.Client;
import com.bank.application.model.Employee;
import com.bank.application.repository.ClientRepository;
import com.bank.application.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> readAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundIdException(String.format(ErrorMessages.EMPLOYEE_WAS_NOT_FOUND_BY_ID, id))
        );
    }

    public boolean update(Employee employee, Long id) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            employeeRepository.save(employee);
            return true;
        }

        return false;
    }

    public boolean delete(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}