package ui;

import model.Employee;
import service.EmployeeService;

import java.util.Scanner;

public class EmployeeUI {

    private static EmployeeService employeeService;
    private static final Scanner s = new Scanner(System.in);
    public EmployeeUI(EmployeeService employeeService) {
        EmployeeUI.employeeService = employeeService;
    }

    public void start() {
        while (true) {
            System.out.println("---- Employee Management ----");
            System.out.println("1. Show All Records");
            System.out.println("2. Search");
            System.out.println("3. Update Records");
            System.out.println("4. Manager Report");
            System.out.println("5. Reporting To -Tree");
            System.out.println("6. Summary Reports");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(s.nextLine());

            switch (choice) {
                case 1:
                    showRecords();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Input Try again.");
                    break;
            }
        }
    }
    public void searchEmployee() {
        SearchUI searchUI = new SearchUI(employeeService);
        searchUI.start();
    }
    public void showRecords() {
        System.out.println("ID |\t| Name |\t| Department |\t| Designation |\t| Reporting To |");
        for (Employee e : employeeService.getAllRecords()) {
            System.out.println(e);
        }
    }
}
