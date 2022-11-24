public class BookPackage {
    Book book;
    int quantity;

    public BookPackage(Book book, int quantity) {
        if (quantity > 0) {
            this.book = book;
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getPrice() {
        return quantity * book.getPrice();
    }

    @Override
    public String toString() {
        return "BookPackage{" +
                "book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}
