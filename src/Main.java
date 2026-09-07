import repository.EmployeeRepository;
import repository.ScheduleRepository;
import repository.TrainRepository;
import service.EmployeeService;
import service.TrainService;
import ui.EmployeeUI;
import ui.TrainUI;

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
                TrainRepository tr = new TrainRepository();
                ScheduleRepository sr = new ScheduleRepository();
                TrainService ts = new TrainService(tr, sr);
                TrainUI tu = new TrainUI(ts);
                tu.start();
                break;
            default:
                System.out.println("Invalid option selected.");
                return;
            }
        }
}
