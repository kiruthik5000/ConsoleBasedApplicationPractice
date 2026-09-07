package repository;

import model.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> getAllBooks();
    public Book getBookByName(String fullName);
    public List<Book> getBookStartsWithName(String subString);
    public boolean addBook(Book book, int availability);
}
