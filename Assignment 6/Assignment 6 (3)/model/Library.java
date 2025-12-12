package model;

import java.util.HashSet;

public class Library<T extends LibraryItem> implements Iterable<T> {
    private HashSet<T> items;

    public Library() {
        this.items = new HashSet<>();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return items.iterator();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) throws ItemNotFoundException {
        if (!items.remove(item)) {
            throw new ItemNotFoundException("Item not found.");
        }
    }

    public T findItemById(int id) throws ItemNotFoundException {
        for (T item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new ItemNotFoundException("Item not found.");
    }

    public void displayAll() {
        for (T item : items) {
            System.out.println(item.getItemDetails());
        }
    }
}
