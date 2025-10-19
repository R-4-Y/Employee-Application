package service;

import exception.EmployeeNotFoundException;
import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EmployeeService {

    public Employee getEmployeeById(int id, List<Employee> employees){

        if (employees == null || id < 0){
                throw new EmployeeNotFoundException("Invalid input: employees list is null or ID is negative");
        }

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        throw new EmployeeNotFoundException(id);
    }

    public List<Employee> getEmployeesBySalaryGreaterThan(int targetSalary, List<Employee> employees){
        if (employees == null || targetSalary < 0){
            throw new EmployeeNotFoundException("Invalid input: employees list is null or targetSalary is negative");
        }

        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getSalary() >= targetSalary) {
                employeeList.add(employee);
            }
        }

        return employeeList;
    }

    public Map<String, Employee> getEmployeeMap(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException();
        }

        Map<String, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                String key = "id" + employee.getId();
                employeeMap.put(key, employee);
            }
        }

        return employeeMap;
    }
}
