package repository.impl;

import model.Book;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookRepositoryImpl implements BookRepository {
    private final Map<Integer, Book> bookMap;
    private final Map<Integer, Integer> availabilityMap;
    private int nextBookId = 105;

    public BookRepositoryImpl() {
        bookMap = new LinkedHashMap<>();

        bookMap.put(101, new Book(101, "Atomic Habits", "Ben Stokes"));
        bookMap.put(102, new Book(102, "Harry Potter", "Mitchel Stark"));
        bookMap.put(103, new Book(103, "Avengers", "Stan Lee"));
        bookMap.put(104, new Book(104, "Avengers: Endgame", "Stan Lee"));
        availabilityMap = new LinkedHashMap<>();
        availabilityMap.put(101, 10);
        availabilityMap.put(102, 5);
        availabilityMap.put(103, 1);
        availabilityMap.put(104, 1);
    }
    @Override
    public List<Book> getAllBooks(){
        return bookMap.values().stream().toList();
    }
    @Override
    public List<Book> getAllBooksByAuthor(String authorName) {
        return bookMap.values()
                .stream()
                .filter(k->k.getAuthorName()
                        .contains(authorName))
                .toList();
    }

    @Override
    public Book getBookByName(String fullName) {
        return bookMap.values()
                .stream()
                .filter(k -> k.getBookName()
                        .equals(fullName))
                .findFirst().orElse(null);
    }

    @Override
    public List<Book> getBookStartsWithName(String subString) {
        return bookMap.values()
                .stream()
                .filter(k -> k.getBookName().startsWith(subString))
                .toList();
    }

    @Override
    public Book addBook(Book book, int availability) {
        book.setBookId(nextBookId);
        bookMap.put(nextBookId, book);
        nextBookId++;
        return book;
    }
}
