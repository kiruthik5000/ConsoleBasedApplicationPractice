package repository;

import model.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> getAllBooks();
    public List<Book> getAllBooksByAuthor(String authorName);
    public Book getBookByName(String fullName);
    public List<Book> getBookStartsWithName(String subString);
    public Book addBook(Book book, int availability);
}
