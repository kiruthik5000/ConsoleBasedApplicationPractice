package service;

import dto.mapper.BookMapper;
import dto.request.BookRequest;
import model.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository br) {
        this.bookRepository = br;
    }

    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepository.getAllBooksByAuthor(authorName);
    }

    public Book getBookByName(String bookName) {
        return bookRepository.getBookByName(bookName);
    }

    public List<Book> getBooksStartsWithName(String startingName) {
        return bookRepository.getBookStartsWithName(startingName);
    }

    public Book addBook(BookRequest bookRequest, int availability) {
        if (!validateBook(bookRequest)) throw new IllegalArgumentException("Invalid Book Details Provided");
        return bookRepository.addBook(BookMapper.toEntity(bookRequest), availability);
    }

    private boolean validateBook(BookRequest bookRequest) {
        if (bookRequest.getAuthorName() == null || bookRequest.getAuthorName().isEmpty()) return false;
        return bookRequest.getBookName() != null && !bookRequest.getBookName().isEmpty();
    }
}
