package service;

import model.Employee;
import repository.EmployeeRepository;
import java.util.*;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllRecords() {
        List<Employee> employees = employeeRepository.getAll();
        if (employees == null || employees.isEmpty()) {
            System.out.println("No Employees Available");
            return new ArrayList<>();
        }
        return employees;
    }


    public List<Employee> getEmployeesWhere(List<Employee> employees, String criteria, String column, String value) {
        if (employees == null) {
            employees = getAllRecords();
        }
        System.out.println(employees.isEmpty() ? "service" : "service fine");

        return switch (criteria) {
            case "Equals" -> employeeRepository.equals(employees, column, value);
            case "Not Equals" -> employeeRepository.notEquals(employees, column, value);
            case "Contains" -> employeeRepository.contains(employees, column, value);
            case "Not Contains" -> employeeRepository.notContains(employees, column, value);
            case "StartsWith" -> employeeRepository.startsWith(employees, column, value);
            case "EndsWith" -> employeeRepository.endsWith(employees, column, value);
            default -> new ArrayList<>();
        };
    }
    public List<Employee> getEmployeesWhere(List<Employee> employees, String criteria, String column, int value) {
        if (employees == null) {
            employees = getAllRecords();
        }
        return switch (criteria) {
            case "=" -> employeeRepository.equalsto(employees, column, value);
            case "!=" -> employeeRepository.notEqualsto(employees, column, value);
            case "<" -> employeeRepository.lessThan(employees, column, value);
            case ">" -> employeeRepository.greaterThan(employees, column, value);
            default -> new ArrayList<>();
        };
    }
}
