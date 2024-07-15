package com.homework26.homework_demo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private static final int MAX_EMPLOYEES = 100;
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен.");
        }
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Лимит количества сотрудников превышен.");
        }
        employees.add(newEmployee);
    }

    public void removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
        employees.remove(employee);
    }

    public Employee findEmployee(String firstName, String lastName) {
        return employees.stream()
                .filter(employee -> employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден."));
    }

    public List<Employee> getEmployees() {
        return null;
    }
}