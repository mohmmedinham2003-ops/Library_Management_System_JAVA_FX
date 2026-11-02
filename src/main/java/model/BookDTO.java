package model;

public class BookDTO {
    private String bookTitle;
    private String author;
    private String Category;
    private int publishedyear;
    private int quantity;

    public BookDTO() {
    }

    public BookDTO(String bookTitle, String author, String category, int publishedyear, int quantity) {

        this.bookTitle = bookTitle;
        this.author = author;
        Category = category;
        this.publishedyear = publishedyear;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", Category='" + Category + '\'' +
                ", publishedyear=" + publishedyear +
                ", quantity=" + quantity +
                '}';
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getPublishedyear() {
        return publishedyear;
    }

    public void setPublishedyear(int publishedyear) {
        this.publishedyear = publishedyear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
