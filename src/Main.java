import model.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
import ui.EmployeeUI;

import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("1. Employee Application");
        System.out.println("2. Train Booking Application");
        System.out.println("Enter the application no: ");
        int n = Integer.parseInt(s.nextLine());
        switch (n) {
            case 1:

                EmployeeRepository employeeRepository = new EmployeeRepository();
                EmployeeService employeeService = new EmployeeService(employeeRepository);
                EmployeeUI employeeUI = new EmployeeUI(employeeService);
                employeeUI.start();
                break;
            case 2:

        }
        }
}
