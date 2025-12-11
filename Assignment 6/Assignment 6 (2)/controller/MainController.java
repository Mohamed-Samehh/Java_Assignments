package controller;

import model.*;
import view.MenuView;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    private Library<Book> bookLibrary = new Library<>();
    private Library<Magazine> magazineLibrary = new Library<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private MenuView menuView = new MenuView();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            int choice = menuView.showMainMenu();
            switch (choice) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageClients();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void manageItems() {
        boolean back = false;
        while (!back) {
            int choice = menuView.showItemMenu();
            switch (choice) {
                case 1:
                    int bookId = 0;
                    while (true) {
                        System.out.print("Enter Book ID: ");
                        try {
                            bookId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scanner.nextLine();
                    bookLibrary.addItem(new Book(bookId, bookTitle, bookAuthor));
                    System.out.println("Book added.");
                    break;
                case 2:
                    int magId = 0;
                    while (true) {
                        System.out.print("Enter Magazine ID: ");
                        try {
                            magId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    System.out.print("Enter Magazine Title: ");
                    String magTitle = scanner.nextLine();
                    System.out.print("Enter Magazine Date: ");
                    String magDate = scanner.nextLine();
                    magazineLibrary.addItem(new Magazine(magId, magTitle, magDate));
                    System.out.println("Magazine added.");
                    break;
                case 3:
                    System.out.println("Books:");
                    bookLibrary.displayAll();
                    System.out.println("Magazines:");
                    magazineLibrary.displayAll();
                    break;
                case 4:
                    int findBookId = 0;
                    while (true) {
                        System.out.print("Enter Book ID to find: ");
                        try {
                            findBookId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    try {
                        Book book = bookLibrary.findItemById(findBookId);
                        System.out.println(book.getItemDetails());
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    int removeBookId = 0;
                    while (true) {
                        System.out.print("Enter Book ID to remove: ");
                        try {
                            removeBookId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    try {
                        Book toRemove = bookLibrary.findItemById(removeBookId);
                        bookLibrary.removeItem(toRemove);
                        System.out.println("Book removed.");
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void manageClients() {
        boolean back = false;
        while (!back) {
            int choice = menuView.showClientMenu();
            switch (choice) {
                case 1:
                    int clientId = 0;
                    while (true) {
                        System.out.print("Enter Client ID: ");
                        try {
                            clientId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    System.out.print("Enter Client Name: ");
                    String clientName = scanner.nextLine();
                    System.out.print("Enter Client Email: ");
                    String clientEmail = scanner.nextLine();
                    clients.add(new Client(clientId, clientName, clientEmail));
                    System.out.println("Client added.");
                    break;
                case 2:
                    for (Client client : clients) {
                        System.out.println(client.getClientDetails());
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
