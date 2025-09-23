package school.sorokin.javacore;

import school.sorokin.javacore.exceptions.ItemNotFoundException;
import school.sorokin.javacore.exceptions.NoAvailableCopiesException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final CatalogManager catalog = new CatalogManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                printMenu();
                String input = scanner.nextLine().trim();
                switch (input) {
                    case "1" -> catalog.getCatalog();
                    case "2" -> catalog.addBook();
                    case "3" -> catalog.takeBook();
                    case "4" -> catalog.returnBook();
                    case "5" -> {
                        System.out.println("Thank you for using app Library!");
                        return;
                    }
                    default -> throw new InputMismatchException("Input data mismatch. Please try again.");
                }
            } catch (InputMismatchException  | NoAvailableCopiesException  | ItemNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Menu of commands:");
        System.out.println("1. Show all books");
        System.out.println("2. Add a new book");
        System.out.println("3. Take a book");
        System.out.println("4. Return a book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}