import Utils.Database;
import Utils.InputHandler;
import Utils.impl.SqlDatabase;
import repository.*;
import repository.impl.BookRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.BookService;
import service.EmployeeService;
import service.TrainService;
import service.UserService;
import ui.*;

import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("1. Employee Application");
        System.out.println("2. Train Booking Application");
        System.out.println("3. Library Management");
        System.out.println("4. DB Management");
        System.out.println("5. Movie Ticket");
        int n = InputHandler.getNumericValue("Enter the application no: ");
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
            case 3:
                BookRepository br = new BookRepositoryImpl();
                UserRepository ur = new UserRepositoryImpl();
                UserService us = new UserService(ur);
                BookService bs = new BookService(br);
                LibraryUI ui = new LibraryUI(us, bs);
                ui.start();
                break;
            case 4:
                Database db = new SqlDatabase();
                DatabaseUI dbui = new DatabaseUI(db.connect());
                dbui.start();
                break;
            case 5:
                MovieUI mui = new MovieUI();
                mui.start();
                break;
            default:
                System.out.println("Invalid option selected.");
            }
        }
}
