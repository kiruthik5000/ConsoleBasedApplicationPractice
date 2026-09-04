package ui;

import model.Employee;
import service.EmployeeService;

import java.util.*;

public class SearchUI {

    private final EmployeeService employeeService;
    private static final Scanner s = new Scanner(System.in);

    public SearchUI(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    private List<Employee> printLessThan(List<Employee> employees) {
        System.out.println("Enter the Column [Id | Age ]");
        String column = s.nextLine();
        System.out.println("Enter the value (integer only)");
        int value = Integer.parseInt(s.nextLine());
        return employeeService.getEmployeesWhere(employees, "<", column, value);
    }

    private List<Employee> printGreaterThan(List<Employee> employees) {
        System.out.println("Enter the Column [Id | Age ]");
        String column = s.nextLine();
        System.out.println("Enter the value (integer only)");
        int value = Integer.parseInt(s.nextLine());
        return employeeService.getEmployeesWhere(employees, ">", column, value);
    }

    private List<Employee> printEqualTo(List<Employee> employees) {
        System.out.println("Enter the Column [Id | Age ]");
        String column = s.nextLine();
        System.out.println("Enter the value (integer only)");
        int value = Integer.parseInt(s.nextLine());
        return employeeService.getEmployeesWhere(employees, "=", column, value);
    }

    private List<Employee> printNotEqualTo(List<Employee> employees) {
        System.out.println("Enter the Column [Id | Age ]");
        String column = s.nextLine();
        System.out.println("Enter the value (integer only)");
        int value = Integer.parseInt(s.nextLine());
        return employeeService.getEmployeesWhere(employees, "!=", column, value);
    }

    public void start() {
        List<Employee> intermediateResult = employeeService.getAllRecords();
        while (true) {
            System.out.println("--- Operations ---");
            System.out.println("1. Equals");
            System.out.println("2. Not Equals");
            System.out.println("3. StartsWith");
            System.out.println("4. EndsWith");
            System.out.println("5. Contains");
            System.out.println("6. Not Contains");
            System.out.println("7. < ");
            System.out.println("8. > ");
            System.out.println("9. = ");
            System.out.println("10. != ");
            System.out.println("11. Submit");
            System.out.println("12. Exit Search");

            int action = Integer.parseInt(s.nextLine());
            switch (action) {
                case 1:
                    intermediateResult = printEquals(intermediateResult);
                    break;
                case 2:
                    intermediateResult = printNotEquals(intermediateResult);
                    break;
                case 3:
                    intermediateResult = printStartsWith(intermediateResult);
                    break;
                case 4:
                    intermediateResult = printEndsWith(intermediateResult);
                    break;
                case 5:
                    intermediateResult = printContains(intermediateResult);
                    break;
                case 6:
                    intermediateResult = printNotContains(intermediateResult);
                    break;
                case 7:
                    intermediateResult = printLessThan(intermediateResult);
                    break;
                case 8:
                    intermediateResult = printGreaterThan(intermediateResult);
                    break;
                case 9:
                    intermediateResult = printEqualTo(intermediateResult);
                    break;
                case 10:
                    intermediateResult = printNotEqualTo(intermediateResult);
                    break;
                case 11:
                    printFinalResult(intermediateResult);
                    break;
                case 12:
                    return;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }

    public List<Employee> printContains(List<Employee> employees) {
        System.out.println("Enter the Column [Name | Age | Department | Designation | Reporting To]");
        String column = s.nextLine();
        System.out.println("Enter the value for the "+column);
        String value = s.nextLine();
        return employeeService.getEmployeesWhere(employees, "Contains", column, value);
    }

    public List<Employee> printNotContains(List<Employee> employees) {
        System.out.println("Enter the Column [Name | Age | Department | Designation | Reporting To]");
        String column = s.nextLine();
        System.out.println("Enter the value for the "+column);
        String value = s.nextLine();
        return employeeService.getEmployeesWhere(employees, "Not Contains", column, value);
    }

    public List<Employee> printStartsWith(List<Employee> employees) {
        System.out.println("Enter the Column [Name | Age | Department | Designation | Reporting To]");
        String column = s.nextLine();
        System.out.println("Enter the value for the "+column);
        String value = s.nextLine();
        return employeeService.getEmployeesWhere(employees, "StartsWith", column, value);
    }

    public List<Employee> printEndsWith(List<Employee> employees) {
        System.out.println("Enter the Column [Name | Age | Department | Designation | Reporting To]");
        String column = s.nextLine();
        System.out.println("Enter the value for the "+column);
        String value = s.nextLine();
        return employeeService.getEmployeesWhere(employees, "EndsWith", column, value);
    }

    public List<Employee> printNotEquals(List<Employee> employees) {
        System.out.println("Enter the Column [Name | Age | Department | Designation | Reporting To]");
        String column = s.nextLine();
        System.out.println("Enter the value for the "+column);
        String value = s.nextLine();
        return employeeService.getEmployeesWhere(employees, "Not Equals", column, value);
    }

    public List<Employee> printEquals(List<Employee> employees) {
        if (employees != null) {
            System.out.println(employees.isEmpty() ? "UI" : "UI fine");
        } else {
            System.out.println("UI empty");
        }

        System.out.println("Enter the Column [Name | Age | Department | Designation | Reporting To]");
        String column = s.nextLine();
        System.out.println("Enter the value for the "+column);
        String value = s.nextLine();
        return employeeService.getEmployeesWhere(employees, "Equals", column, value);
    }

    public void printFinalResult(List<Employee> employees) {
        System.out.println("ID |\t| Name |\t| Department |\t| Designation |\t| Reporting To |");
        if (employees != null) {
            System.out.println(employees.isEmpty() ? "print" : "print fine");
            for (Employee e : employees) {
                System.out.println(e);
            }
        } else {
            System.out.println("print");
        }
    }
}
