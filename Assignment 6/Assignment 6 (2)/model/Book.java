package model;

public class Book extends LibraryItem {
    private String author;

    public Book() {
        this.id = 0;
        this.title = "";
        this.author = "";
    }

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
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
