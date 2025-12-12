package model;

public class Book extends LibraryItem {
    private String author;

    public Book() {
        this.id = 0;
        this.title = "";
        this.author = "";
        this.stock = 0;
        this.available = true;
    }

    public Book(int id, String title, String author, int stock, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.available = available;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getItemDetails() {
        return "ID: " + id + "\nTitle: " + title + "\nAuthor: " + author;
    }
}
