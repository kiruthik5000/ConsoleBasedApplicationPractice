package dto.request;

public class BookRequest {
    public String bookName;
    public String AuthorName;

    public BookRequest(String bookName, String authorName) {
        this.bookName = bookName;
        AuthorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }
}
