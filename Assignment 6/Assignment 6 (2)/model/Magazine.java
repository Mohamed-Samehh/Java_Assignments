package model;

public class Magazine extends LibraryItem {
    private String date;

    public Magazine() {
        this.id = 0;
        this.title = "";
        this.date = "";
    }

    public Magazine(int id, String title, String date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getItemDetails() {
        return "ID: " + id + "\nTitle: " + title + "\nDate: " + date;
    }
}
