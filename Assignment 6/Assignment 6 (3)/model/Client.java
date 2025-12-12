package model;

import java.util.HashSet;

public class Client {
    private int id;
    private String name;
    private String email;
    private HashSet<LibraryItem> borrowedItems = new HashSet<>();

    public Client() {
        this.id = 0;
        this.name = "";
        this.email = "";
    }

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashSet<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(HashSet<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public void borrowItem(LibraryItem item) {
        if (!borrowedItems.contains(item) && item.isAvailable() && item.getStock() > 0) {
            borrowedItems.add(item);
            item.setAvailable(false);
            item.setStock(item.getStock() - 1);
            System.out.println("Item borrowed successfully.");
        } else {
            System.out.println("Item is not available.");
        }
    }

    public void returnItem(LibraryItem item) {
        if (borrowedItems.contains(item) && !item.isAvailable()) {
            borrowedItems.remove(item);
            item.setAvailable(true);
            item.setStock(item.getStock() + 1);
            System.out.println("Item returned successfully.");
        } else {
            System.out.println("Item was not borrowed.");
        }

    }

    public String getClientDetails() {
        return "ID: " + id + "\nName: " + name + "\nEmail: " + email;
    }
}
