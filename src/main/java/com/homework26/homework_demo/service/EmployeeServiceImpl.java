package com.homework26.homework_demo.service;

import ch.qos.logback.core.util.StringUtil;
import com.homework26.homework_demo.Employee;
import com.homework26.homework_demo.exception.EmployeeAlreadyAddedException;
import com.homework26.homework_demo.exception.EmployeeNotFoundException;
import com.homework26.homework_demo.exception.WrongNameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Collections.unmodifiableCollection;
import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.split;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        firstName = verifyStrings(firstName);
        lastName = verifyStrings(lastName);
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        firstName = verifyStrings(firstName);
        lastName = verifyStrings(lastName);
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        firstName = verifyStrings(firstName);
        lastName = verifyStrings(lastName);
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    private String verifyStrings(String string) {
        if (!isAlpha(string)) {
            throw new WrongNameException();
        }
        return StringUtils.capitalize(string);
    }


    @Override
    public Collection<Employee> findAll() {
        return unmodifiableCollection(employees.values());
    }
}
