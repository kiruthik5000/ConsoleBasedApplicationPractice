package ui;

import Utils.InputHandler;
import model.Book;
import service.BookService;

import java.util.List;
import java.util.Scanner;

public class BookUI {
    private final BookService bookService;

    public BookUI(BookService bookService) {
        this.bookService = bookService;
    }

    public void start() {
        while (true) {
            System.out.println("==== Welcome to Library ====\n");
            System.out.println("1.getBooksByAuthor");
            System.out.println("2.getBookByName");
            System.out.println("3.getBookStartsWith");
            System.out.println("4.addBook");

            int choice = InputHandler.getNumericValue("Enter the choice:");
            switch (choice) {
                case 1:
//                    getBooksByAuthor();
                    break;
                case 2:
//                    getBookByName();
                    break;
                case 3:
//                    getBookStartsWith();
                    break;
                case 4:
//                    addBook();
                    break;
                default:
                    System.out.println("Invalid Option Choosed");
                    return;
            }
        }
    }
//    private void getBooksByAuthor() {
//        String authorName = InputHandler.getStringValue("Enter the Author Name:");
//        try {
//            List<Book> books = bookService.getBooksByAuthor(authorName);
//            if (books != null) {
//                for (int )
//            }
//        } catch (Exception e) {
//            System.out.println("Error "+e.getMessage());
//        }
//    }
}
