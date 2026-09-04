package repository;

import model.Employee;

import java.util.*;

public class EmployeeRepository {
    private final Map<Integer, Employee> employeeRepository;

    public EmployeeRepository() {
        employeeRepository = new HashMap<>();

        employeeRepository.put(1, new Employee(1, "Sriram", 45, "Management", "CEO", ""));
        employeeRepository.put(2, new Employee(2, "Mukund", 42, "HR", "HR Manager", "Sriram" ));
        employeeRepository.put(3, new Employee(3, "Sebastian", 38, "Finance", "Finance Manager", "Sriram"));
        employeeRepository.put(4, new Employee(4, "Aashritha", 32, "Production Management", "Dev Manager", "Sriram"));
        employeeRepository.put(5, new Employee(5, "Mohammad Rafi", 35, "HR", "HR Lead", "Mukund" ));
        employeeRepository.put(6, new Employee(6, "Anjali Kumar", 29, "HR", "HR Associate", "Mohammad Rafi" ));
        employeeRepository.put(7, new Employee(7, "Joseph", 40, "Finance", "Finance Associate", "Sebastian"));
        employeeRepository.put(8, new Employee(8, "Ramachandran", 27, "Product Development", "Tech Lead", "Aashritha" ));
        employeeRepository.put(9, new Employee(9, "Abhinaya Shankar", 23, "Product Development", "System Developer", "Ramachandran"));
        employeeRepository.put(10, new Employee(10, "Imran Khan", 28, "Product Testing", "QA Lead", "Ramachandran"));
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employeeRepository.values());
    }

    public List<Employee> equals(List<Employee> employees, String column, String value) {
        List<Employee> result = new ArrayList<>();
        System.out.println(employees.isEmpty() ? "repo" : "repo fine");

        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "name":
                    if (e.getName().equals(value)) {
                        result.add(e);
                    }
                    break;
                case "department":
                    if (e.getDepartment().equalsIgnoreCase(value)) {
                        result.add(e);
                    }
                    break;
                case "designation":
                    if (e.getDesignation().equalsIgnoreCase(value)) {
                        result.add(e);
                    }
                    break;
                case "reportingto":
                    if (e.getReporting_to().equalsIgnoreCase(value)) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }
        public List<Employee> notEquals(List<Employee> employees, String column, String value) {
            List<Employee> result = new ArrayList<>();
            for (Employee e : employees) {
                switch (column.toLowerCase().replace(" ", "")) {
                    case "name":
                        if (!e.getName().equals(value)) {
                            result.add(e);
                        }
                        break;
                    case "department":
                        if (!e.getDepartment().equalsIgnoreCase(value)) {
                            result.add(e);
                        }
                        break;
                    case "designation":
                        if (!e.getDesignation().equalsIgnoreCase(value)) {
                            result.add(e);
                        }
                        break;
                    case "reportingto":
                        if (!e.getReporting_to().equalsIgnoreCase(value)) {
                            result.add(e);
                        }
                        break;
                    default:
                        System.out.println("Invalid Column Selected");
                        break;
                }
            }
            return result;
        }
    public List<Employee> contains(List<Employee> employees, String column, String value) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "name":
                    if (e.getName().toLowerCase().contains(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "department":
                    if (e.getDepartment().toLowerCase().contains(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "designation":
                    if (e.getDesignation().toLowerCase().contains(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "reportingto":
                    if (e.getReporting_to().toLowerCase().contains(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }

    public List<Employee> notContains(List<Employee> employees, String column, String value) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "name":
                    if (!e.getName().toLowerCase().contains(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "department":
                    if (!e.getDepartment().toLowerCase().contains(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "designation":
                    if (!e.getDesignation().toLowerCase().contains(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "reportingto":
                    if (!e.getReporting_to().toLowerCase().contains(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }
    public List<Employee> equalsto(List<Employee> employees, String column, int value) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "id":
                    if (e.getId() == value) {
                        result.add(e);
                    }
                    break;
                case "age":
                    if (e.getAge() == value) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }
    public List<Employee> notEqualsto(List<Employee> employees, String column, int value) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "id":
                    if (e.getId() != value) {
                        result.add(e);
                    }
                    break;
                case "age":
                    if (e.getAge() != value) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }
    public List<Employee> lessThan(List<Employee> employees, String column, int value) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "id":
                    if (e.getId() < value) {
                        result.add(e);
                    }
                    break;
                case "age":
                    if (e.getAge() < value) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }
    public List<Employee> greaterThan(List<Employee> employees, String column, int value) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "id":
                    if (e.getId() > value) {
                        result.add(e);
                    }
                    break;
                case "age":
                    if (e.getAge() > value) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }

    public List<Employee> startsWith(List<Employee> employees, String column, String value) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "name":
                    if (e.getName().toLowerCase().startsWith(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "department":
                    if (e.getDepartment().toLowerCase().startsWith(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "designation":
                    if (e.getDesignation().toLowerCase().startsWith(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "reportingto":
                    if (e.getReporting_to().toLowerCase().startsWith(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }

    public List<Employee> endsWith(List<Employee> employees, String column, String value) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            switch (column.toLowerCase().replace(" ", "")) {
                case "name":
                    if (e.getName().toLowerCase().endsWith(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "department":
                    if (e.getDepartment().toLowerCase().endsWith(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "designation":
                    if (e.getDesignation().toLowerCase().endsWith(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                case "reportingto":
                    if (e.getReporting_to().toLowerCase().endsWith(value.toLowerCase())) {
                        result.add(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Column Selected");
                    break;
            }
        }
        return result;
    }
}
