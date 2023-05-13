package Model;

public class Book {
    private String bookID;
    private String name;
    private String author;
    private String publisher;
    private String categories;
    private int quantityAvailable;
    private double price;

    public Book(String bookID, String name, String author, String publisher, String categories, int quantityAvailable, double price) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.categories = categories;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {}

    @Override
    public String toString() {
        return "Model.Book{" +
                "bookID='" + bookID + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", categories='" + categories + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                ", price=" + price +
                '}';
    }
}
