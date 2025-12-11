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
                            int tempId = scanner.nextInt();
                            scanner.nextLine();
                            boolean duplicate = clients.stream().anyMatch(c -> c.getId() == tempId);
                            if (duplicate) {
                                throw new model.DuplicateEntryException(
                                        "Book ID already exists. Please enter a unique ID.");
                            }
                            bookId = tempId;
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        } catch (model.DuplicateEntryException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter Book Stock: ");
                    int bookStock = scanner.nextInt();
                    scanner.nextLine();
                    bookLibrary.addItem(new Book(bookId, bookTitle, bookAuthor, bookStock, true));
                    System.out.println("Book added.");
                    break;
                case 2:
                    int magId = 0;
                    while (true) {
                        System.out.print("Enter Magazine ID: ");
                        try {
                            int tempId = scanner.nextInt();
                            scanner.nextLine();
                            boolean duplicate = clients.stream().anyMatch(c -> c.getId() == tempId);
                            if (duplicate) {
                                throw new model.DuplicateEntryException(
                                        "Magazine ID already exists. Please enter a unique ID.");
                            }
                            magId = tempId;
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        } catch (model.DuplicateEntryException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.print("Enter Magazine Title: ");
                    String magTitle = scanner.nextLine();
                    System.out.print("Enter Magazine Date: ");
                    String magDate = scanner.nextLine();
                    System.out.print("Enter Magazine Stock: ");
                    int magStock = scanner.nextInt();
                    scanner.nextLine();
                    magazineLibrary.addItem(new Magazine(magId, magTitle, magDate, magStock, true));
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
                    int findMagId = 0;
                    while (true) {
                        System.out.print("Enter Magazine ID to find: ");
                        try {
                            findMagId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    try {
                        Magazine magazine = magazineLibrary.findItemById(findMagId);
                        System.out.println(magazine.getItemDetails());
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
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
                case 7:
                    int removeMagId = 0;
                    while (true) {
                        System.out.print("Enter Magazine ID to remove: ");
                        try {
                            removeMagId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    try {
                        Magazine toRemoveMag = magazineLibrary.findItemById(removeMagId);
                        magazineLibrary.removeItem(toRemoveMag);
                        System.out.println("Magazine removed.");
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
                            int tempId = scanner.nextInt();
                            scanner.nextLine();
                            boolean duplicate = clients.stream().anyMatch(c -> c.getId() == tempId);
                            if (duplicate) {
                                throw new model.DuplicateEntryException(
                                        "Client ID already exists. Please enter a unique ID.");
                            }
                            clientId = tempId;
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        } catch (model.DuplicateEntryException e) {
                            System.out.println(e.getMessage());
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
                case 3:
                    int findClientId = 0;
                    while (true) {
                        System.out.print("Enter Client ID to find: ");
                        try {
                            findClientId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    final int finalFindClientId = findClientId;
                    Client foundClient = clients.stream().filter(c -> c.getId() == finalFindClientId).findFirst()
                            .orElse(null);
                    if (foundClient != null) {
                        System.out.println(foundClient.getClientDetails());
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;
                case 4:
                    int borrowClientId = 0;
                    while (true) {
                        System.out.print("Enter Client ID that will borrow: ");
                        try {
                            borrowClientId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    final int finalBorrowClientId = borrowClientId;
                    Client client_borrow = clients.stream().filter(c -> c.getId() == finalBorrowClientId).findFirst()
                            .orElse(null);
                    if (client_borrow != null) {
                        System.out.print("Enter Book ID to borrow: ");
                        int itemIdToBorrow = scanner.nextInt();
                        scanner.nextLine();
                        for (Book item : bookLibrary) {
                            if (item.getId() == itemIdToBorrow) {
                                client_borrow.borrowItem(item);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;
                case 5:
                    int returnClientId = 0;
                    while (true) {
                        System.out.print("Enter Client ID that will return: ");
                        try {
                            returnClientId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    final int finalReturnClientId = returnClientId;
                    Client client_return = clients.stream().filter(c -> c.getId() == finalReturnClientId).findFirst()
                            .orElse(null);
                    if (client_return != null) {
                        System.out.print("Enter Book ID to return: ");
                        int itemIdToReturn = scanner.nextInt();
                        scanner.nextLine();
                        for (Book item : bookLibrary) {
                            if (item.getId() == itemIdToReturn) {
                                client_return.returnItem(item);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;
                case 6:
                    int borrowMagClientId = 0;
                    while (true) {
                        System.out.print("Enter Client ID that will borrow: ");
                        try {
                            borrowMagClientId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    final int finalBorrowMagClientId = borrowMagClientId;
                    Client client_borrow_mag = clients.stream().filter(c -> c.getId() == finalBorrowMagClientId)
                            .findFirst().orElse(null);
                    if (client_borrow_mag != null) {
                        System.out.print("Enter Magazine ID to borrow: ");
                        int magIdToBorrow = scanner.nextInt();
                        scanner.nextLine();
                        for (Magazine item : magazineLibrary) {
                            if (item.getId() == magIdToBorrow) {
                                client_borrow_mag.borrowItem(item);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Client not found.");
                    }
                    break;
                case 7:
                    int returnMagClientId = 0;
                    while (true) {
                        System.out.print("Enter Client ID that will return: ");
                        try {
                            returnMagClientId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.nextLine();
                        }
                    }
                    final int finalReturnMagClientId = returnMagClientId;
                    Client client_return_mag = clients.stream().filter(c -> c.getId() == finalReturnMagClientId)
                            .findFirst().orElse(null);
                    if (client_return_mag != null) {
                        System.out.print("Enter Magazine ID to return: ");
                        int magIdToReturn = scanner.nextInt();
                        scanner.nextLine();
                        for (Magazine item : magazineLibrary) {
                            if (item.getId() == magIdToReturn) {
                                client_return_mag.returnItem(item);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Client not found.");
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
