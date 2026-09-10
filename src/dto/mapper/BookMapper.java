package dto.mapper;

import dto.request.BookRequest;
import model.Book;

public class BookMapper {
    public static Book toEntity(BookRequest bookRequest) {
        return new Book(
                0,
                bookRequest.getBookName(),
                bookRequest.getAuthorName()
        );
    }
}
