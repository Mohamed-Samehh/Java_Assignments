package view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Manage Library Items");
        System.out.println("2. Manage Clients");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    public int showItemMenu() {
        System.out.println("\nLibrary Items Menu");
        System.out.println("1. Add Book");
        System.out.println("2. Add Magazine");
        System.out.println("3. Display All Items");
        System.out.println("4. Find Book by ID");
        System.out.println("5. Find Magazine by ID");
        System.out.println("6. Remove Book");
        System.out.println("7. Remove Magazine");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    public int showClientMenu() {
        System.out.println("\nClients Menu");
        System.out.println("1. Add Client");
        System.out.println("2. Display All Clients");
        System.out.println("3. Find Client by ID");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Borrow Magazine");
        System.out.println("7. Return Magazine");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }
}
