package ui;

import Utils.InputHandler;
import dto.request.UserRequest;
import model.Book;
import model.User;
import service.BookService;
import service.UserService;

import java.util.Scanner;

public class LibraryUI {
    private final UserService userService;
    private final BookService bookService;
    private static final Scanner s = new Scanner(System.in);

    public LibraryUI(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    public void start() {
        while (true) {
            System.out.println("==== Welcome to Library Management ====");
            System.out.println("1. Login User");
            System.out.println("2. SignIn User");
            int choice = InputHandler.getNumericValue("Enter your choice:");

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signin();
                    break;
                default:
                    System.out.println("Invalid Option !");
                    return;
            }
        }
    }

    private void login() {
        int uId = InputHandler.getNumericValue("Enter the User Id:");
        String password = InputHandler.getStringValue("Enter the password:");
        try {
            if (userService.login(uId, password)) {
                System.out.println("User LoggedIn Successfully.");
                BookUI bui = new BookUI(bookService);
                bui.start();
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    private void signin() {
        String userName = InputHandler.getStringValue("Enter the UserName:");
        String designation = InputHandler.getStringValue("Enter the Designation: [STUDENT | FACULTY | GUEST]");
        String password = InputHandler.getStringValue("Enter your Password:");
        try {
            UserRequest user = new UserRequest(userName, password, designation);
            User userEntity = userService.signIn(user);
            if (userEntity != null) {
                System.out.println("User Registered Successfully.");
                System.out.println(userEntity);
            } else {
                System.out.println("Error in System Cannot Register User");
            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
}
